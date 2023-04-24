/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import utils.TextUtility;
import controller.StudentController;

/**
 *
 * @author tungs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        StudentController sc = new StudentController();
        sc.initializationStudent();
        String menu = "WELCOME TO STUDENT MANAGEMENT\n"
                + "1. Create\n"
                + "2. Find and Sort\n"
                + "3. Update/Delete\n"
                + "4. Report\n"
                + "5. Exit\n\n"
                + "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).";
        while (true) {
            int choice = TextUtility.getInt(menu, "Integer only", "Integer must in range 1-5", 1, 5);
            switch (choice) {
                case 1:
                    System.out.println("-------------Create new student-------------");
                    sc.addNewStudent();
                    break;
                case 2:
                    System.out.println("-------------Find and sort student-------------");

                    sc.findAndSearchStudent();
                    break;
                case 3:
                    System.out.println("-------------Updare or delete student-------------");
                    sc.updateOrDeleteStudent();
                    break;
                case 4:

                    break;
                case 5:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
