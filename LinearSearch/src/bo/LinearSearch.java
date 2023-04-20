/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author tungs
 */
public class LinearSearch {

    public int[] linearSearch(int[] arr, int search) {
        int[] index = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                index[j++] = i;

            }
        }
        return index;
    }

    public void displayFoundIndex(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (i > 0 && arr[i] == 0) {
                break;
            } else if (arr[i + 1] == 0) {
                System.out.print(arr[i]+"\n");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
