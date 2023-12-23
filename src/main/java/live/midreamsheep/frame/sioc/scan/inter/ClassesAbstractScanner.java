package live.midreamsheep.frame.sioc.scan.inter;

import java.util.Set;

public abstract class ClassesAbstractScanner implements ClassesScanner{

    private ClassesScanner next;

    public abstract Set<Class<?>> doScan();

    @Override
    public Set<Class<?>> scan(){
        Set<Class<?>> classes = this.doScan();
        if (this.next != null) {
            classes.addAll(this.next.scan());
        }
        return classes;
    }

    @Override
    public void next(ClassesScanner classesScanner) {this.next = classesScanner;}

}
