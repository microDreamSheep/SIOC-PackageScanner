package live.midreamsheep.frame.sioc.scan.processor;

import live.midreamsheep.frame.sioc.scan.annotation.meta.ProcessorFlag;
import live.midreamsheep.frame.sioc.scan.api.processor.HandlerProcessor;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;

public abstract class AbstractHandlerProcessor implements HandlerProcessor {

    @Override
    public void init(ClassMetaDefinition classMetaDefinition) {
        ProcessorFlag annotation = classMetaDefinition.getAnnotationInfo().getAnnotation(ProcessorFlag.class);
        if (annotation==null){
            return;
        }
        init(annotation.value());
    }

    protected abstract void init(Class<?>[] classes);

    @Override
    public int getOrder() {
        return 0;
    }
}
