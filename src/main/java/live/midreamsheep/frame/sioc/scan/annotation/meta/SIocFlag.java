package live.midreamsheep.frame.sioc.scan.annotation.meta;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用于标记被处理类<br/>
 * 主要用于为上下文处理器的生成提供源数据<br/>
 * @author midreamsheep
 * */
@Retention(RetentionPolicy.RUNTIME)
public @interface SIocFlag {
}
