package live.midreamsheep.frame.sioc.scan.clazz.method.method;

import live.midreamsheep.frame.sioc.scan.clazz.annotation.AnnotationInfo;
import live.midreamsheep.frame.sioc.scan.clazz.method.MethodInter;
import lombok.Data;

import java.lang.reflect.Method;

@Data
public class NormalMethodInfo implements MethodInter {

    private Method method;
    private AnnotationInfo annotationInfo;
    private String methodName;
    private Class<?> returnType;
    private Class<?>[] parameterTypes;
    private Class<?>[] exceptionTypes;

    public NormalMethodInfo(Method method) {
        this.method = method;
        this.methodName = method.getName();
        this.returnType = method.getReturnType();
        this.parameterTypes = method.getParameterTypes();
        this.exceptionTypes = method.getExceptionTypes();
        annotationInfo = new AnnotationInfo();
        annotationInfo.init(method.getAnnotations());
    }
}
