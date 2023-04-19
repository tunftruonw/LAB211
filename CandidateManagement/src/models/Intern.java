/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author tungs
 */
public class Intern extends Candidate{
    private String major;
    private int semester;
    private String universiryName;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversiryName() {
        return universiryName;
    }

    public void setUniversiryName(String universiryName) {
        this.universiryName = universiryName;
    }
    
}
