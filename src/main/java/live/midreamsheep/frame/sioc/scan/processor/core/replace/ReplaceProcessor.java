package live.midreamsheep.frame.sioc.scan.processor.core.replace;

import live.midreamsheep.frame.sioc.api.handle.ContextHandler;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;
import live.midreamsheep.frame.sioc.scan.processor.AbstractHandlerProcessor;
import live.midreamsheep.frame.sioc.scan.processor.ProcessorManager;

import java.util.List;

public abstract class ReplaceProcessor extends AbstractHandlerProcessor {
    @Override
    public abstract void process(ClassMetaDefinition classMetaDefinition, List<ContextHandler> contextHandlerList);

    @Override
    protected void init(Class<?>[] classes) {
        for (Class<?> aClass : classes) {
            ProcessorManager.addProcessor(aClass,this);
        }
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
