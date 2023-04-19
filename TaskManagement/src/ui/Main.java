package ui;

import controller.TaskController;
import utils.MyUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author tungs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        TaskController taskController = new TaskController();
        while (true) {
            System.out.println("========= Task program =========");
            System.out.println(" 1. Add task");
            System.out.println(" 2. Delete task");
            System.out.println(" 3. Display task");
            System.out.println(" 4. Exit");
            int choice = MyUtils.getInt("Enter your choice: ", "Must input an integer number!", "Must input an integer in range [1,4]: ", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("-------------Add task-------------");
                    taskController.addTask();
                    break;
                case 2:
                    System.out.println("-------------Delete task-------------");
                    taskController.deleteTask();
                break;
                case 3:
                    System.out.println("-------------Display task-------------");
                    taskController.displayAllTask();
                    break;
                case 4:
                    return;
            }

        }
    }
}

