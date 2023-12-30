package live.midreamsheep.frame.sioc.scan.core;

import live.midreamsheep.frame.sioc.api.handle.ContextHandler;
import live.midreamsheep.frame.sioc.scan.annotation.meta.ProcessorFlag;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;
import live.midreamsheep.frame.sioc.scan.processor.core.decorate.DecorateProcessor;

import java.util.List;

@ProcessorFlag({Injector.class})
public class BeanDecorator extends DecorateProcessor {
    @Override
    public void process(ClassMetaDefinition classMetaDefinition, List<ContextHandler> contextHandlerList) {
        System.out.println(processor.getOrder());
        processor.process(classMetaDefinition,contextHandlerList);
    }
}
