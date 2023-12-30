package live.midreamsheep.frame.sioc.scan.api.processor;

import live.midreamsheep.frame.sioc.api.handle.ContextHandler;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;

import java.util.List;

public interface HandlerProcessor {
    void process(ClassMetaDefinition classMetaDefinition, List<ContextHandler> contextHandlerList);

    void init(ClassMetaDefinition classMetaDefinition);

    int getOrder();
}
