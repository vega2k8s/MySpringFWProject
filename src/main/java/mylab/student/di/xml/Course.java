package mylab.student.di.xml;

import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private List<Student> students;
    
    public Course() {}
    
    // Getters and Setters
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
    
    public double getAverageScore() {
        if (students == null || students.isEmpty()) {
            return 0;
        }
        
        int total = 0;
        for (Student student : students) {
            total += student.getScore();
        }
        return (double) total / students.size();
    }
    
    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + 
               ", students=" + students + "]";
    }
}