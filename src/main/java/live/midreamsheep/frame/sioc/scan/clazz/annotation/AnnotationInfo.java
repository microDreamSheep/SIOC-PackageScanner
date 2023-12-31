package live.midreamsheep.frame.sioc.scan.clazz.annotation;

import lombok.Getter;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@SuppressWarnings("unchecked")
public class AnnotationInfo {

    private final Map<Class<?>,Annotation> annotations = new HashMap<>();

    public <T> T getAnnotation(Class<T> clazz){
        return annotations.containsKey(clazz) ? (T) annotations.get(clazz) : null;
    }

    public void addAnnotation(Annotation annotation){
        annotations.put(annotation.annotationType(),annotation);
    }

    public void removeAnnotation(Class<?> clazz){
        annotations.remove(clazz);
    }

    public boolean containsAnnotation(Class<?> clazz){
        return annotations.containsKey(clazz);
    }

    public void init(Class<?> clazz){
        init(clazz.getAnnotations());
    }

    public void init(Annotation[] annotations){
        for (Annotation annotation : annotations) {
            String name = annotation.annotationType().getName();
            if (name.startsWith("java.lang.annotation")|| name.startsWith("kotlin.annotation")||name.startsWith("kotlin.Metadata")){
                continue;
            }
            getAllAnnotations(annotation.annotationType()).forEach(this::addAnnotation);
            addAnnotation(annotation);
        }
    }

    private List<Annotation> getAllAnnotations(Class<?> clazz){
        List<Annotation> annotationList = new LinkedList<>();
        //获取类上的注解和注解信息
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            //排除java.lang.annotation包下的注解和Kotlin的元注解kotlin.annotation
            String name = annotation.annotationType().getName();
            if (name.startsWith("java.lang.annotation")|| name.startsWith("kotlin.annotation")||name.startsWith("kotlin.Metadata")){
                continue;
            }
            getAllAnnotations(annotation.annotationType()).forEach(this::addAnnotation);
            annotationList.add(annotation);
            annotationList.addAll(getAllAnnotations(annotation.annotationType()));
        }
        return annotationList;
    }
}