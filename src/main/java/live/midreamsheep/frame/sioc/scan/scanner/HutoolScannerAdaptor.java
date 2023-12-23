package live.midreamsheep.frame.sioc.scan.scanner;

import cn.hutool.core.util.ClassUtil;
import live.midreamsheep.frame.sioc.scan.inter.ClassesAbstractScanner;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class HutoolScannerAdaptor extends ClassesAbstractScanner {

    private String basePackage;

    @Override
    public Set<Class<?>> doScan() {
        //扫描指定目录下的所有jar包
        return ClassUtil.scanPackage(basePackage);
    }
}
