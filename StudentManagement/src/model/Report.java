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
public class Report extends Student{
    private int totalCourse;
    String STRING_FORMAT = "%-12s | %-20s | %-8s | %-10s\n";
    
    public Report(String id, String studentName, String course, int totalCourse){
        super(id, studentName, course);
        this.totalCourse = totalCourse;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return String.format(STRING_FORMAT, super.getId().toUpperCase(), TextUtility.normalFormName(super.getStudentName()), super.getCourseName(), totalCourse );
    }
}
