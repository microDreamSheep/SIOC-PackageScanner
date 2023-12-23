package live.midreamsheep.frame.sioc.scan.clazz.method.method;

import live.midreamsheep.frame.sioc.scan.clazz.annotation.AnnotationInfo;
import live.midreamsheep.frame.sioc.scan.clazz.method.MethodInter;
import lombok.Data;

import java.lang.reflect.Constructor;

@Data
public class ConstructorMethodInfo implements MethodInter<Constructor<?>> {
    private Constructor<?> constructor;
    private AnnotationInfo annotationInfo;
    private String methodName;
    private Class<?> returnType;
    private Class<?>[] parameterTypes;
    private Class<?>[] exceptionTypes;

    public ConstructorMethodInfo(Constructor<?> constructor) {
        this.constructor = constructor;
        this.methodName = constructor.getName();
        this.returnType = constructor.getDeclaringClass();
        this.parameterTypes = constructor.getParameterTypes();
        this.exceptionTypes = constructor.getExceptionTypes();
        annotationInfo = new AnnotationInfo();
        annotationInfo.init(constructor.getAnnotations());
    }

    @Override
    public Constructor<?> getMethod() {
        return constructor;
    }
}
