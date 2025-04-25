package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloConSpringTest {
	@Autowired
	@Qualifier("helloC")
	Hello hello;
	
	@Test
	void helloCons() {
		//System.out.println(hello.sayHello());
		assertEquals("Hello 생성자", hello.sayHello());
		hello.print();
	}
	
}
