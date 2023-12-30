package live.midreamsheep.frame.sioc.scan.core;

import live.midreamsheep.frame.sioc.api.builder.application.ApplicationContextBuilder;
import live.midreamsheep.frame.sioc.api.context.application.ApplicationContext;
import live.midreamsheep.frame.sioc.core.context.CoreBeanHandlerInjector;
import live.midreamsheep.frame.sioc.core.context.application.CoreApplicationContext;
import live.midreamsheep.frame.sioc.core.context.factory.CoreBeanFactory;
import live.midreamsheep.frame.sioc.scan.PackageBeanDefinitionsFactory;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinitionImpl;
import live.midreamsheep.frame.sioc.scan.parse.CoreClassParserToDefinition;
import live.midreamsheep.frame.sioc.scan.scanner.HutoolScannerAdaptor;
import org.junit.Test;

public class CoreTest {
    @Test
    public void coreTest() {
        ApplicationContextBuilder applicationContextBuilder = new ApplicationContextBuilder();
        applicationContextBuilder.setApplicationContext(new CoreApplicationContext(new CoreBeanFactory()));
        applicationContextBuilder.setBeanHandlerInjector(new CoreBeanHandlerInjector());
        applicationContextBuilder.setClassbeanHandlerFactory(new PackageBeanDefinitionsFactory(new HutoolScannerAdaptor(""),new CoreClassParserToDefinition()));
        ApplicationContext build = applicationContextBuilder.build();
        TestBean bean = build.getBean(TestBean.class);
        bean.sayHello();
    }
}
