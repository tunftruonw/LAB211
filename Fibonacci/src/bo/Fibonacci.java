/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import javax.sql.rowset.serial.SerialRef;

/**
 *
 * @author tungs
 */
public class Fibonacci {

    //create function to caculate and print fibonacci sequence
    //length is size of sequence, b is the number preciding c
    public static int fibo(int length, int b, int c) {
        //check if index < 2 or not, print the last number in the sequence
        if (length < 2) {
            System.out.println(c);
            return c;
        }
        //print sequence
        System.out.print(c+", ");
        //use recursion to generate new number in sequence
        return fibo(length - 1, c, b + c);
    }
    
    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    public void displayFibonacci(int n){
        System.out.println("The " + n + " sequense Fibonacci: ");
        for (int i = 0; i < n-1; i++) {
            System.out.print(fibonacci(i) + ", ");
        }
        System.out.println(fibonacci(n));
        System.err.println();
    }
    
}
