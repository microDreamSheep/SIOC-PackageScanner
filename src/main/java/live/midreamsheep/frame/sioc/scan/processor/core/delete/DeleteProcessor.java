package live.midreamsheep.frame.sioc.scan.processor.core.delete;

import live.midreamsheep.frame.sioc.api.handle.ContextHandler;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;
import live.midreamsheep.frame.sioc.scan.processor.AbstractHandlerProcessor;
import live.midreamsheep.frame.sioc.scan.processor.ProcessorManager;

import java.util.List;

public class DeleteProcessor extends AbstractHandlerProcessor {
    @Override
    public void process(ClassMetaDefinition classMetaDefinition, List<ContextHandler> contextHandlerList) {/*保持空处理*/}

    @Override
    protected void init(Class<?>[] classes) {
        for (Class<?> aClass : classes) {
            ProcessorManager.removeProcessor(aClass);
        }
    }
}
