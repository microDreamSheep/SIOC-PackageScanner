package live.midreamsheep.frame.sioc.scan.clazz.method;

import live.midreamsheep.frame.sioc.scan.clazz.annotation.AnnotationInfo;

public interface MethodInter<T> {

    String getMethodName();
    Class<?> getReturnType();
    Class<?>[] getParameterTypes();
    Class<?>[] getExceptionTypes();

    AnnotationInfo getAnnotationInfo();

    T getMethod();
}
