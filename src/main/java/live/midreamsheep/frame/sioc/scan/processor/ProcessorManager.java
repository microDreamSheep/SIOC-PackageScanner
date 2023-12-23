package live.midreamsheep.frame.sioc.scan.processor;

import live.midreamsheep.frame.sioc.scan.api.processor.HandlerProcessor;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ProcessorManager {
    private static final Map<Class<?>, HandlerProcessor> contextHandlerMap = new HashMap<>();

    /**
     * 用于新增上下文处理器
     * @param annotationClass 注解类
     * @param contextHandler 上下文处理器
     * */
    public static void addProcessor(Class<?> annotationClass, HandlerProcessor contextHandler){
        contextHandlerMap.put(annotationClass,contextHandler);
    }

    /**
     * 用于获取上下文处理器
     * @param annotationClass 注解类
     * @return 上下文处理器
     * */
    public static HandlerProcessor getProcessor(Class<?> annotationClass) {
        return contextHandlerMap.get(annotationClass);
    }

    /**
     * 删除上下文处理器
     * */
    public static HandlerProcessor removeProcessor(Class<?> annotationClass) {
        return contextHandlerMap.remove(annotationClass);
    }

    public static void addUserProcessor(ClassMetaDefinition handle) {
        //实例化handle
        try {
            Object o = handle.getOwnClass().getDeclaredConstructor().newInstance();
            if(o instanceof HandlerProcessor){
                ((HandlerProcessor)o).init(handle);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            //TODO
            throw new RuntimeException(e);
        }

    }
}