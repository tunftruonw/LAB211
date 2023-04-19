package ui;

import utils.MyUtils;
import controller.ExpenseController;
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
        ExpenseController expenseController = new ExpenseController();
        String menu = "============Handy Expense============\n"
                + "1. Add an expense\n"
                + "2. Display all expenses\n"
                + "3. Remove an expense\n"
                + "4. Exit\n"
                + "Your choice: ";
        while (true) {
            int choice = MyUtils.getInt(menu, "Integer only", "Out of range", 1, 4);
            switch (choice) {
                case 1:
                    expenseController.inputAddingExpense();
                    break;
                case 2:
                    expenseController.displayAllExpense();
                    break;
                case 3:
                    expenseController.deleteAnExpense();
                    break;
                case 4:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
