package live.midreamsheep.frame.sioc.scan.processor.core.register;

import live.midreamsheep.frame.sioc.scan.processor.AbstractHandlerProcessor;
import live.midreamsheep.frame.sioc.scan.processor.ProcessorManager;

/**
 * 用于注册handler的处理器
 * */
public abstract class RegisterProcessor extends AbstractHandlerProcessor {

    @Override
    public void init(Class<?>[] classes) {
        for (Class<?> aClass : classes) {
            ProcessorManager.addProcessor(aClass,this);
        }
    }

}
