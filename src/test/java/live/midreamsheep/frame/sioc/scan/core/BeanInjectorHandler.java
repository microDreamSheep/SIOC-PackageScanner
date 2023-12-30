package live.midreamsheep.frame.sioc.scan.core;

import live.midreamsheep.frame.sioc.api.context.application.ApplicationContext;
import live.midreamsheep.frame.sioc.api.handle.AbstractContextHandler;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationTargetException;

@AllArgsConstructor
public class BeanInjectorHandler extends AbstractContextHandler {

    private Class<?> aClass;

    @Override
    public void handle(ApplicationContext applicationContext) {
        Object o = null;
        try {
            o = aClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        applicationContext.registerBean(o.getClass().getName(),o);
    }
}
