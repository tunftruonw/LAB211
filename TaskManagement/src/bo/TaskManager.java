/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import model.Task;

/**
 *
 * @author tungs
 */
public class TaskManager {
    private final ArrayList<Task> taskList;
    private int lastId;

    public TaskManager() {
        taskList = new ArrayList<>();
        lastId = 0;
    }

    public int getLastId() {
        return lastId;
    }

    public TaskManager(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTask(Task t) {
        t.setId(++lastId);
        taskList.add(t);
    }

    public Task deleteTask(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            System.out.println("Delete successfully");
            return taskList.remove(index);
        }
        throw new Exception("Delete task fail\n");
    }

    private int searchById(int id) {
        for (int index = 0; index < taskList.size(); index++) {
            if (taskList.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public void displayTask() {
        System.out.println(String.format("%-3s %-10s %-20s %-12s %-6s %-20s %-20s",
                "ID", "Task type", "Name", "Date", "Time", "Asignee", "Reviewer"));
        for (Task t : taskList) {
            System.out.println(t);
        }
    }

    public int duplicateTask(Task t) {
        int count = 0;
        for (Task task : taskList) {
            if (task.getDate().equals(t.getDate())
                    && task.getPlanFrom() == t.getPlanFrom()
                    && task.getPlanTo() == t.getPlanTo()
                    && task.getAssignee().equalsIgnoreCase(t.getAssignee())
                    && task.getReviewer().equalsIgnoreCase(t.getReviewer())
                    && task.getName().equalsIgnoreCase(t.getName())
                    && task.getTaskTypeId().equalsIgnoreCase(t.getTaskTypeId())) {
                count += 1;
            }
        }
        return count;
    }
}
