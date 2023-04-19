/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import java.util.Collections;
import model.Student;
import java.util.HashMap;

/**
 *
 * @author tungs
 */
public class StudentManager {

    private ArrayList<Student> listStudent;

    public StudentManager() {
        listStudent = new ArrayList<>();
    }
    
    private boolean isSameStudent(Student s1, Student s2) {
        return s1.getId().equalsIgnoreCase(s2.getId())
                && s1.getStudentName().equalsIgnoreCase(s2.getStudentName())
                && s1.getSemester() == s2.getSemester()
                && s1.getCourseName().equalsIgnoreCase(s2.getCourseName());
    }

    private boolean checkDuplicate(Student student) {
        for (Student s : listStudent) {
            if (isSameStudent(s, student)) {
                return true;
            }
            if (s.getId().equals(student.getId())
                    && !s.getStudentName().equals(student.getStudentName())) {
                return true;
            }
        }
        return false;
    }

    public boolean createStudent(Student s) throws Exception {
        if (!checkDuplicate(s)) {
            return listStudent.add(s);
        }
        throw new Exception("Duplicate Student");
    }

    public int searchById(String id) {
        for (int index = 0; index < listStudent.size(); index++) {
            if (listStudent.get(index).getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }

    public Student findStudent(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            listStudent.get(index);
        }
        throw new Exception("No student found");
    }

    public ArrayList<Student> findAndSortStudent(String s) throws Exception {
        ArrayList<Student> listFoundStudent = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getStudentName().contains(s)) {
                listFoundStudent.add(student);
            }
        }
        Collections.sort(listFoundStudent);
        if (!listFoundStudent.isEmpty()) {
            return listFoundStudent;
        }
        throw new Exception("Student code doesn’t exist");
    }

    public Student updateCandidate(String id, Student s) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listStudent.set(index, s);
            //update candidate by index 
        }
        throw new Exception("Student not found!");
    }

    public Student deleteCandidate(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listStudent.remove(index);
            //remove candidate by index
        }
        throw new Exception("Student does not exist");
    }

    private boolean checkStudentName(String name, Student student) {
        String[] listName = student.getStudentName().trim().split("[ ]+");
        for (String s : listName) {
            if (s.contains(name)) {
                return true;
            }
        }
        return false;
    }

}
