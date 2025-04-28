package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//<context:component-scan base-package="myspring.di.annot" /> 
@ComponentScan(basePackages = {"myspring.di.annot"})
//<context:property-placeholder location="classpath:values.properties" />
@PropertySource(value="classpath:values.properties" )
public class HelloBeanConfig {

	public HelloBeanConfig() {
		System.out.println(this.getClass().getName() + " Config클래스 기본생성자 호출됨!");
	}
}
