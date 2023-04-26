/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;

/**
 *
 * @author tungs
 */
public class LinearSearch {

    public ArrayList<Integer> linearSearch(int[] arr, int search) {
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                index.add(i);
            }
        }
        return index;
    }

    public void displayFoundIndex(ArrayList<Integer> index) {
        for (int i = 0; i < index.size()-1; i++) {
                System.out.print(index.get(i).intValue() + ", ");
        }
        System.out.print(index.get(index.size()-1).intValue()+"\n");
    }
}
