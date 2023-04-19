/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import model.Expense;
import utils.MyUtils;
/**
 *
 * @author tungs
 */
public class ExpenseInputer {
    private Expense expense;
    
    public ExpenseInputer(){
        expense = new Expense();
    }
    public Expense inputExpense(){
        expense.setDate(MyUtils.getDate("Enter date: ", "Invalid date, please enter following the format dd-MM-yyyy"));
        expense.setNumber(MyUtils.getDouble("Enter amount: ", "Invalid amount", "Out of range", 0, Integer.MAX_VALUE));
        expense.setContent(MyUtils.getNonEmptyString("Enter content: "));
        return expense;
    }
}
