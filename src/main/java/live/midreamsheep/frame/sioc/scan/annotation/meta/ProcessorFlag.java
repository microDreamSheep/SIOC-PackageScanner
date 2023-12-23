package live.midreamsheep.frame.sioc.scan.annotation.meta;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用于标记上下文处理器类<br/>
 * ProcessorFlag，用于向上下文中添加上下文<br/>
 * 处理器类必须实现接口{@link live.midreamsheep.frame.sioc.api.handle.ContextHandler}<br/>
 * @author midreamsheep
 * */
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessorFlag {
    Class<?>[] value();
}
