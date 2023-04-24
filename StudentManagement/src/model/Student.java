/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import utils.TextUtility;
/**
 *
 * @author tungs
 */
public class Student implements Comparable<Student>{
    // ID, Student Name, Semester, Course Name
  
    private String id;
    private String studentName;
    private int semester;
    private String courseName;
    public static final String DISPLAY_FORMAT = "%-12s%-20s%-12s%-10s\n";
    public static final String DISPLAY_HEAD = String.format(DISPLAY_FORMAT, "ID", "Name", "Semester", "Course Name");
    
    public Student(String id, String studentName, int semester, String course) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = course;
    }

    public Student(String id, String studentName, String course) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = course;
    }
    
    public Student() {
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return String.format(DISPLAY_FORMAT, id.toUpperCase(), TextUtility.normalFormName(studentName), semester, courseName);
    }
    
    @Override
    public int compareTo(Student student) {
        return this.getStudentName().compareTo(student.getStudentName());
    }
}
