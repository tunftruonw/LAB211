/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import model.Task;
import utils.MyUtils;

/**
 *
 * @author tungs
 */
public class TaskInputer {

    private Task task;

    public TaskInputer() {
        task = new Task();
    }

    public Task inputTask() {
        task.setName(MyUtils.getStringByRegex("Requirement Name: ", "Invalid name", "[A-Za-z ]+"));
        task.setDate(MyUtils.getDate("Date: ", "Invalid date"));
        task.setTaskTypeId(MyUtils.getInputTaskType());
        task.setPlanFrom(MyUtils.getDouble("From: ", "Please enter follow format <8-17>.<0 or 5>", "Must in range 8.0-17.0", 8, 17.0));
        while (true) {
            try {
                task.setPlanTo(MyUtils.getDouble("To: ", "Please enter follow format <8-17>.<0 or 5>", "Must in range 8.0-17.5", 8, 17.5));
                task.getTime();
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        task.setAssignee(MyUtils.getNonEmptyString("Assignee: "));
        task.setReviewer(MyUtils.getNonEmptyString("Reviewer: "));
        return task;
    }
}
