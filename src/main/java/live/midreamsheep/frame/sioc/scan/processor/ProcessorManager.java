package live.midreamsheep.frame.sioc.scan.processor;

import live.midreamsheep.frame.sioc.scan.api.processor.HandlerProcessor;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
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

    public static void addUserProcessors(Map<Class<?>,ClassMetaDefinition> handleList)  {
        List<HandlerProcessor> handlerProcessors = handleList.values().stream().map(classMetaDefinition -> {
            try {
                return (HandlerProcessor) classMetaDefinition.getOwnClass().getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException ignored) {

            }
            return null;
        }).sorted((o1, o2) -> {
            assert o1 != null;
            int order1 = o1.getOrder();
            int order2 = o2.getOrder();
            return Integer.compare(order1, order2);
        }).collect(java.util.stream.Collectors.toList());
        //对handlerProcessors通过order进行排序
        for (HandlerProcessor handlerProcessor : handlerProcessors) {
            handlerProcessor.init(handleList.get(handlerProcessor.getClass()));
        }

    }
}