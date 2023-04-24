/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tungs
 */
public class Task {
    private int id;
    private String taskTypeId;
    private String name;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;
    private double time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    public double getTime() throws Exception{
        //validate time
        time = planTo - planFrom;
        if (time>0){
            return time;
        } else {
            throw new Exception("Plan to must later than plan from");
        }
    }

    @Override
    public String toString() {
        return String.format("%-3s %-10s %-20s %-12s %-6.1f %-20s %-20s", 
                id, taskTypeId, name, date, time, assignee, reviewer);
    }
    
    
}
