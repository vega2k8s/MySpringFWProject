package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//<context:component-scan base-package="myspring.di.annot" /> 
@ComponentScan(basePackages = {""})
public class HelloBeanConfig {

}
