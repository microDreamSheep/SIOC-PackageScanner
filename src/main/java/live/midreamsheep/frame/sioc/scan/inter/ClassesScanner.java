package live.midreamsheep.frame.sioc.scan.inter;

import java.util.Set;

/**
 * 类扫描器，扫描出所有类
 * @author midreamsheep
 * */
public interface ClassesScanner {

    /**
     * 获取所有的对象，如果需要传入参数，推荐在实现类中添加构造函数或使用构造者模式
     * */
    Set<Class<?>> scan();

    /**
     * 调用链，设置下一执行扫描的扫描器
     * */
    void next(ClassesScanner classesScanner);
}
