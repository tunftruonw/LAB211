/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;
import model.Student;
import utils.TextUtility;
/**
 *
 * @author tungs
 */
public class StudentInputer {
    private Student student;

    public StudentInputer() {
        student = new Student();
    }
    
    private String inputCourse() {
        System.out.println("Enter Course"
                + "\n1. Java"
                + "\n2. .Net"
                + "\n3. C/C++");
        int choose = TextUtility.getInt("Your choice: ", "Number only", "Number out of range", 1, 3);
        String course="";
        switch (choose) {
            case 1:
                course= "Java";
            case 2:
                course =".Net";
            case 3:
                course ="C/C++";
        }
        return course;
    }
    
    public Student inputStudentToAdd(){
        student.setId(TextUtility.getNonEmptyString("Enter ID: "));
        student.setStudentName(TextUtility.getStringByRegex("Enter student name: ", "Name invalid", "[A-Za-z ]+"));
        student.setSemester(TextUtility.getInt("Enter semester: ", "Number only", "Out of range", 1, 100));
        student.setCourseName(inputCourse());
        return student;
    }
    
    public Student inputStudentToUpdate(){
        student.setStudentName(TextUtility.getStringByRegex("Enter student name: ", "Name invalid", "[A-Za-z ]+"));
        student.setSemester(TextUtility.getInt("Enter semester: ", "Number only", "Out of range", 1, 100));
        student.setCourseName(inputCourse());
        return student;
    }
    
    
}
