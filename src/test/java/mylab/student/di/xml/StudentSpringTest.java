package mylab.student.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {
	@Autowired
	Course course;
	
	@Test
	void testCourse() {
		assertNotNull(course);
		assertEquals("Java Programming", course.getCourseName());
		assertEquals(3, course.getStudents().size());
		assertEquals("emma", course.getStudents().get(0));
		
		System.out.println(course.getAverageScore());
		
	}
}
