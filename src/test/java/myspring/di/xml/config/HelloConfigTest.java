package myspring.di.xml.config;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import myspring.di.xml.Hello;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class )
public class HelloConfigTest {
	@Autowired
	List<String> namesList;
	
	@Autowired
	Hello hello;
	
	@Test
	void testHelloConfig() {
		
	}
	
	
	
	@Test
	void testNameList() {
		for (String name : namesList) {
			System.out.println(name);
		}
	}
	
}
