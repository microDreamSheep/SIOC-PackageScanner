package live.midreamsheep.frame.sioc.scan.processor.core.decorate;

import live.midreamsheep.frame.sioc.api.handle.ContextHandler;
import live.midreamsheep.frame.sioc.scan.api.processor.HandlerProcessor;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;
import live.midreamsheep.frame.sioc.scan.processor.AbstractHandlerProcessor;
import live.midreamsheep.frame.sioc.scan.processor.ProcessorManager;

import java.util.List;

public abstract class DecorateProcessor extends AbstractHandlerProcessor {
    protected HandlerProcessor processor;

    @Override
    public abstract void  process(ClassMetaDefinition classMetaDefinition, List<ContextHandler> contextHandlerList);

    @Override
    protected void init(Class<?>[] classes) {
        if(classes.length==0){
            return;
        }
        this.processor = ProcessorManager.getProcessor(classes[0]);
        for (Class<?> aClass : classes) {
            ProcessorManager.addProcessor(aClass,this);
        }
    }
}