package ui;

import java.util.ArrayList;

import bo.LinearSearch;
import utils.ArrayUtils;

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
    public static void main(String[] args) {

        LinearSearch ls = new LinearSearch();
        int length = ArrayUtils.getInt("Enter array length: ", "Integer only", "Must greater than 0", 1,
                Integer.MAX_VALUE);
        int[] arr = ArrayUtils.createArray(length, 10);
        System.out.println("The array: ");
        ArrayUtils.displayArray(arr);
        do {
            int search = ArrayUtils.getInt("Enter search value: ", "Integer only", "Out of range", Integer.MIN_VALUE,
                    Integer.MAX_VALUE);
            ArrayList<Integer> foundIndex = ls.linearSearch(arr, search);
            if (foundIndex.isEmpty()) {
                System.out.println("Can't found " + search);
            } else {
                System.out.print("Found " + search + " at indexs: ");
                ls.displayFoundIndex(foundIndex);
            }
        } while (ArrayUtils.pressYNtoContinue("Do you want to find other value?(Y/N)"));
    }
}
