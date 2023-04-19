/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import bo.ExpenseInputer;
import bo.ExpenseManager;
import model.Expense;
import utils.MyUtils;
/**
 *
 * @author tungs
 */
public class ExpenseController {
    private ExpenseInputer expenseInputer;
    private ExpenseManager expenseManager;
    
    public ExpenseController(){
        expenseManager = new ExpenseManager();
    }
    
    public Expense inputAddingExpense(){
        System.out.println("-------------Add an expense-------------");
        expenseInputer = new ExpenseInputer();
        Expense e = expenseInputer.inputExpense();
        expenseManager.addExpense(e);
        return e;
    }
    
    public void deleteAnExpense() throws Exception{
        System.out.println("-------------Delete an expense-------------");
        int id = MyUtils.getInt("Enter ID: ", "ID invalid", "Out of range", 0, Integer.MAX_VALUE);
        try {
            expenseManager.deleteExpense(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void displayAllExpense(){
        System.out.println("-------------Display all expense-------------");
        expenseManager.displayExpense();
    }
}
