/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;
import bo.Fibonacci;
import utils.TextUtility;

/**
 *
 * @author tungs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Enter size of fibonacci sequence
        int n = TextUtility.getInt("Enter size of fibonacci sequence", "Integer number only", "Integer number must in range 1-10000", 1, 10000);
        Fibonacci.fibo(n, 1, 0);
    }

}
