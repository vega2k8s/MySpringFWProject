package mylab.student.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
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
	
	@Resource(name = "gradeService")
	GradeService service;
	
	@Test
	void testService() {
		assertNotNull(service);
		assertEquals("C001", service.getCourse().getCourseId());
		assertEquals("A", service.calculateGrade("S001"));
		assertEquals(2, service.getHighScoreStudents(80).size());
		
		for(Student student : service.getHighScoreStudents(80)) {
			System.out.println(student);
		}
	}
	
		
	@Test @Disabled
	void testCourse() {
		assertNotNull(course);
		assertEquals("Java Programming", course.getCourseName());
		assertEquals(3, course.getStudents().size());
		/*
		 * course.getStudents() => List<Student>  학생목록
		 * course.getStudents().get(0) => Student 학생
		 * course.getStudents().get(0).getName() => String 학생의 이름
		 */
		assertEquals("엠마", course.getStudents().get(0).getName());
		
		System.out.println(course.getAverageScore());
		assertEquals(83.333, course.getAverageScore(),0.001);
	}
}
