package live.midreamsheep.frame.sioc.scan.inter;

import live.midreamsheep.frame.sioc.api.handle.HandlerSet;

import java.util.Set;

/**
 * 解析class为bean定义
 * */
public interface ClassParserToDefinition {

    /**
     * 解析class为bean定义
     * @param classes 需要解析的class
     * @return bean定义
     * */
    HandlerSet parse(Set<Class<?>> classes);

}
