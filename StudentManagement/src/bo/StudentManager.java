/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import model.Student;
import model.Report;

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

    private boolean checkDuplicate(Student student, boolean isUpdate) {
        for (Student s : listStudent) {
            if (isSameStudent(s, student)) {
                return true;
            }
            if (!isUpdate) {
                if (s.getId().equalsIgnoreCase(student.getId())
                && !s.getStudentName().equalsIgnoreCase(student.getStudentName())) {
            return true;
        }
            }
            
        }
        return false;
    }

    public boolean addStudent(Student s) throws Exception {
        if (!checkDuplicate(s, false)) {
            return listStudent.add(s);
        }
        throw new Exception("This student is already exist");
    }

    public int searchById(String id) {
        for (int index = 0; index < listStudent.size(); index++) {
            if (listStudent.get(index).getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }

    public ArrayList<Student> findStudent(String id) throws Exception {
        ArrayList<Student> listFoundStudent = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                listFoundStudent.add(student);
            }
        }
        if (listFoundStudent.isEmpty()) {
            throw new Exception("No student found");
        }
        return listFoundStudent;
    }

    public ArrayList<Student> findAndSortStudent(String s) throws Exception {
        ArrayList<Student> listFoundStudent = new ArrayList<>();
        for (Student student : listStudent) {
            if (checkStudentName(s, student)) {
                listFoundStudent.add(student);
            }
        }
        Collections.sort(listFoundStudent);
        if (!listFoundStudent.isEmpty()) {
            return listFoundStudent;
        }
        throw new Exception("Student code doesn’t exist");
    }

    public ArrayList<Report> reportStudentByArrayList() {
        ArrayList<Report> reportList = new ArrayList<>();
        for (Student s1 : listStudent) {
            int totalCourse = 0;
            String id1 = s1.getId();
            String course1 = s1.getCourseName();
            for (Student s2 : listStudent) {
                String id2 = s2.getId();
                String course2 = s2.getCourseName();
                if (id1.equalsIgnoreCase(id2) && course1.equalsIgnoreCase(course2)) {
                    totalCourse++;
                }
            }
            if (!duplicateReport(reportList, id1, course1)) {
                reportList.add(new Report(id1, s1.getStudentName(), course1, totalCourse));
            }
        }
        return reportList;
    }

    public ArrayList<Report> reportStudentByHashMap() {
        HashMap<String, Report> tmp = new HashMap<>();
        for (Student s : listStudent) {
            String key = s.getId().toUpperCase() + "|" + s.getCourseName();
            Report r = tmp.get(key);
            if (r == null) {
                tmp.put(key, new Report(s.getId(), s.getStudentName(), s.getCourseName(), 1));
            } else {
                r.setTotalCourse(r.getTotalCourse() + 1);
            }
        }
        ArrayList<Report> reportList = new ArrayList<>();
        for (Report value : tmp.values()) {
            reportList.add(value);
        }
        return reportList;
    }

    private boolean duplicateReport(ArrayList<Report> reportList, String id, String course) {
        for (Report report : reportList) {
            if (report.getId().equalsIgnoreCase(id) && report.getCourseName().equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    public Student updateStudent(String id, Student s) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            if (checkDuplicate(s, true)) {
                throw new Exception("This student is already existed");
            }
            for (Student student : listStudent) {
                if (student.getId().equalsIgnoreCase(id)) {
                    student.setId(s.getId());
                    student.setStudentName(s.getStudentName());
                }
            }
            return listStudent.set(index, s);
        }
        throw new Exception("Student not found!");
    }

    public Student deleteStudent(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listStudent.remove(index);
            // remove candidate by index
        }
        throw new Exception("Student does not exist");
    }

    private boolean checkStudentName(String name, Student student) {
        String[] listName = student.getStudentName().trim().split("[ ]+");
        for (String s : listName) {
            if (s.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
