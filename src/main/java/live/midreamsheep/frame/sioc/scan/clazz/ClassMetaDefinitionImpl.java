package live.midreamsheep.frame.sioc.scan.clazz;

import cn.hutool.core.lang.Snowflake;
import live.midreamsheep.frame.sioc.scan.clazz.annotation.AnnotationInfo;
import live.midreamsheep.frame.sioc.scan.clazz.field.FieldInfo;
import live.midreamsheep.frame.sioc.scan.clazz.method.MethodInfo;
import lombok.Data;

@Data
public class ClassMetaDefinitionImpl implements ClassMetaDefinition{

    private final Class<?> aClass;
    private final AnnotationInfo annotationInfo = new AnnotationInfo();
    private final MethodInfo methodInfo = new MethodInfo();
    private final FieldInfo fieldInfo = new FieldInfo();
    private long id;
    private static Snowflake snowflake = new Snowflake(1,1);

    public ClassMetaDefinitionImpl(Class<?> aClass) {
        this.aClass = aClass;
        //雪花算法生成id
        this.id = snowflake.nextId();
    }


    @Override
    public void initAnnotationInfo() {
        annotationInfo.init(aClass);
    }


    @Override
    public void initMethodInfo() {
        methodInfo.init(aClass);
    }

    @Override
    public void initFieldInfo() {
        fieldInfo.init(aClass);
    }

    @Override
    public Class<?> getOwnClass() {
        return aClass;
    }
}
