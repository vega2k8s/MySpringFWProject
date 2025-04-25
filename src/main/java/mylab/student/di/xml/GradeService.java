package mylab.student.di.xml;

import java.util.ArrayList;
import java.util.List;

public class GradeService {
    private Course course;
    
    public GradeService() {}
    
    // Getters and Setters
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    
    // 특정 점수 이상인 학생 목록 반환
    public List<Student> getHighScoreStudents(int threshold) {
        List<Student> highScoreStudents = new ArrayList<>();
        
        for (Student student : course.getStudents()) {
            if (student.getScore() >= threshold) {
                highScoreStudents.add(student);
            }
        }
        
        return highScoreStudents;
    }
    
    // 특정 학생의 등급 계산
    public String calculateGrade(String studentId) {
        for (Student student : course.getStudents()) {
            if (student.getId().equals(studentId)) {
                int score = student.getScore();
                if (score >= 90) return "A";
                else if (score >= 80) return "B";
                else if (score >= 70) return "C";
                else if (score >= 60) return "D";
                else return "F";
            }
        }
        return "학생을 찾을 수 없습니다.";
    }
    
    @Override
    public String toString() {
        return "GradeService [course=" + course + "]";
    }
}