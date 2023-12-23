package live.midreamsheep.frame.sioc.scan.clazz.field.field;

import live.midreamsheep.frame.sioc.scan.clazz.annotation.AnnotationInfo;
import live.midreamsheep.frame.sioc.scan.clazz.field.FieldInter;
import lombok.Data;

import java.lang.reflect.Field;

@Data
public class NormalField implements FieldInter {

    private final Field field;
    private String fieldName;
    private Class<?> fieldType;
    private final AnnotationInfo annotationInfo = new AnnotationInfo();


    public NormalField(Field field) {
        this.field = field;
        this.fieldName = field.getName();
        this.fieldType = field.getType();
        this.annotationInfo.init(field.getAnnotations());
    }
}
