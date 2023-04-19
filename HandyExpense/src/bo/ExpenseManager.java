/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import model.Expense;

/**
 *
 * @author tungs
 */
public class ExpenseManager {

    private final ArrayList<Expense> expense;
    private int lastId;

    public ExpenseManager() {
        expense = new ArrayList<>();
        lastId = 0;
    }

    public int getLastId() {
        return lastId;
    }

    public ExpenseManager(ArrayList<Expense> expense) {
        this.expense = expense;
    }

    public void addExpense(Expense e) {
        e.setId(++lastId);
        expense.add(e);
    }

    public Expense deleteExpense(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            System.out.println("Delete successfully");
            return expense.remove(index);
        }
        throw new Exception("Delete an expense fail\n");
    }

    private int searchById(int id) {
        for (int index = 0; index < expense.size(); index++) {
            if (expense.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public void displayExpense() {
        double total = 0;
        System.out.println(String.format("%-4s %-15s %-20s %-20s",
                "ID", "Date", "Amount of money", "Content"));
        for (Expense e : expense) {
            System.out.println(e);
            total += e.getNumber();
        }
        System.out.println("Total: " + total);
    }
}
