package live.midreamsheep.frame.sioc.scan.core;

import live.midreamsheep.frame.sioc.api.handle.ContextHandler;
import live.midreamsheep.frame.sioc.scan.annotation.meta.ProcessorFlag;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;
import live.midreamsheep.frame.sioc.scan.processor.core.register.RegisterProcessor;

import java.util.List;

@ProcessorFlag({Injector.class})
public class BeanInjector extends RegisterProcessor {
    @Override
    public void process(ClassMetaDefinition classMetaDefinition, List<ContextHandler> contextHandlerList) {
        contextHandlerList.add(new BeanInjectorHandler(classMetaDefinition.getOwnClass()));
    }
}
