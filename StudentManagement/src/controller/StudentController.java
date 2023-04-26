/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.StudentInputer;
import bo.StudentManager;
import java.util.ArrayList;
import model.Report;
import model.Student;
import utils.TextUtility;

/**
 *
 * @author tungs
 */
public class StudentController {

    private StudentInputer studentInputer;
    private final StudentManager studentManager;

    public StudentController() {
        studentManager = new StudentManager();
    }

    public void addNewStudent() throws Exception {
        studentInputer = new StudentInputer();
        do {
            Student s = studentInputer.inputStudentToAdd();
            System.out.println("Student added succesfully");
            try {
                studentManager.addStudent(s);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (TextUtility.pressYNtoContinue("Do you want to create another student?(Y/N)"));
    }

    public void findAndSearchStudent() throws Exception {
        String idSearch = TextUtility.getNonEmptyString("Enter student name: ");
        try {
            System.out.println("Found list:");
            System.out.print(String.format(Student.DISPLAY_FORMAT, "ID", "Name", "Semester", "Course Name"));
            for (Student s : studentManager.findAndSortStudent(idSearch)) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateOrDeleteStudent() throws Exception {
        ArrayList<Student> foundStudent;
        String idSearch = TextUtility.getNonEmptyString("Enter ID: ");
        try {
            foundStudent = studentManager.findStudent(idSearch);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
        int number = 1;
        System.out.println("List of students found:");
        System.out.println(String.format("%-4s%-12s%-20s%-12s%-10s", "No", "ID", "Name", "Semester", "Course Name"));
        for (Student s : foundStudent) {
            System.out.println(String.format("%-4s%-12s%-20s%-12s%-10s", number, s.getId(), s.getStudentName(), s.getSemester(), s.getCourseName()));
            number++;
        }
        int studentNo = TextUtility.getInt("Enter student number you want to update or delete: ", "Integer only", "Must in range 1-" + number, 1, number);
        Student studentChoosen = foundStudent.get(studentNo - 1);
        String choice = TextUtility.getStringByRegex("Do you want to update(U) or delete(D)?", "Invalid", "[UDud]");
        if (choice.equalsIgnoreCase("d")) {
            studentManager.deleteStudent(studentChoosen.getId());
            System.out.println("Student have been delete succesfully\n");
        } else {
            updateStudent(studentChoosen.getId());
            System.out.println("Student have been update succesfully\n");
        }
    }

    public void updateStudent(String id) throws Exception {
        studentInputer = new StudentInputer();
        do {
            try {
                Student s = studentInputer.inputStudentToAdd();
                studentManager.updateStudent(id, s);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (TextUtility.pressYNtoContinue("Do you want to update again?(Y/N)"));

    }

    public void displayReport() {
        for (Report report : studentManager.reportStudentByHashMap()) {
            System.out.println(report);
        }
    }

    public void initializationStudent() throws Exception {
        studentManager.addStudent(new Student("HE176601", "Truong Quang Tung", 3, "Java"));
        studentManager.addStudent(new Student("HE176601", "Truong Quang Tung", 3, ".Net"));
        studentManager.addStudent(new Student("HE176601", "Truong Quang Tung", 2, "Java"));
        studentManager.addStudent(new Student("He176602", "Truong Tuan Linh", 1, "Java"));
        studentManager.addStudent(new Student("He176602", "truong Tuan Linh", 2, "Java"));
        studentManager.addStudent(new Student("Hs176603", "Tran Tuan Hieu", 4, "C/C++"));
        studentManager.addStudent(new Student("Hs176604", "Vu tuan Dat", 4, "C/C++"));
        studentManager.addStudent(new Student("Hs176604", "Vu tuan Dat", 3, ".Net"));
        studentManager.addStudent(new Student("He176601", "Truong Quang Tung", 4, "Java"));
    }
}
