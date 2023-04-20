package ui;

import utils.*;
import bo.BubbleSearch;
import bo.BubbleSort;
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
        BubbleSearch bbSearch = new BubbleSearch();
        BubbleSort bbSort = new BubbleSort();
        int length = ArrayUtils.getInt("Enter array length: ", "Integer only", "Must greater than 0", 1,
                Integer.MAX_VALUE);
        int[] arr = ArrayUtils.createArray(length, 10);
        do {
            int value = ArrayUtils.getInt("Enter search value: ", "Integer only", "Out of range", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int foundIndex = bbSearch.binarySearch(bbSort.bubbleSort(arr), value, 0, arr.length - 1);
            if (foundIndex == -1) {
                System.out.println("Can't found " + value);
            } else {
                System.out.println("Sorted Array: ");
                ArrayUtils.displayArray(bbSort.bubbleSort(arr));
                System.out.println("Found " + value + " at index: " + foundIndex);
                break;
            }
        } while (ArrayUtils.pressYNtoContinue("Do you want to find other value?(Y/N)"));
    }
}
