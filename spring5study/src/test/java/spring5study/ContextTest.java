package spring5study;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ContextTest {

	@Test
	public void testContext() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Bean1 bean1 = ctx.getBean("bean1", Bean1.class);
		assertNotNull(bean1);
		System.out.println(bean1);
	}
	
	@Test
	public void testGenericContext() {
		GenericApplicationContext ctx = new GenericApplicationContext();
		new XmlBeanDefinitionReader(ctx).loadBeanDefinitions("classpath:applicationContext.xml");
		ctx.refresh();
		Bean1 bean1 = ctx.getBean("bean1", Bean1.class);
		BeanDefinition beanDefinition = ctx.getBeanDefinition("bean1");
		assertNotNull(bean1);
		System.out.println(bean1);
	}
}
