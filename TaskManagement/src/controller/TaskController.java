/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.TaskInputer;
import bo.TaskManager;
import model.Task;
import utils.MyUtils;

/**
 *
 * @author tungs
 */
public class TaskController {
    private TaskInputer taskInputer;
    private TaskManager taskManager;

    public TaskController() {
        taskManager = new TaskManager();
    }

    public Task addTask() {
        taskInputer = new TaskInputer();
        Task t = taskInputer.inputTask();
        if (taskManager.duplicateTask(t) > 0) {
            if (MyUtils.pressYNtoContinue("You already enter this task " + taskManager.duplicateTask(t) + " times.\n"
                    + "(Y/N)Do you want to input this task again?")) {
                taskManager.addTask(t);
                System.out.println("Add new task successfully");
            } else {
                System.out.println("Add new task fail");
            }
        } else {
            taskManager.addTask(t);
            System.out.println("Add new task successfully");
        }
        return t;
    }

    public void deleteTask() throws Exception {
        int id = MyUtils.getInt("Enter ID: ", "ID invalid", "Out of range", 0, Integer.MAX_VALUE);
        try {
            taskManager.deleteTask(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void displayAllTask() {
        taskManager.displayTask();
    }
}
