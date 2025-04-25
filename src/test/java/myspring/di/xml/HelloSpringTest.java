package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

//SpringExtension 클래스는 ApplicationContext(컨테이너)객체를 생성하는 역할을 함
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloSpringTest {
	@Autowired
	Hello hello;
	
	@Autowired
	Printer strPrinter;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Resource(name = "hello")
	Hello helloBean;
	
	@Test
	void helloSpringBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", strPrinter.toString());
		
		System.out.println(strPrinter.getClass().getName());
		
		assertEquals("Hello 스프링", printer.toString());
	
		assertEquals("Hello 스프링", helloBean.sayHello());
	}
}
