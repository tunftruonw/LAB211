package bo;

import utils.ArrayUtils;

public class BinarySearch {
    // binary search with recursive
    public int recursiveBinarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return recursiveBinarySearch(array, value, left, middle - 1);
        } else {
            return recursiveBinarySearch(array, value, middle + 1, right);
        }
    }

    //binary search with iterative 
    public int iterativeBinarySearch(int arr[], int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                left = m + 1;
            else
                right = m - 1;
        }
        return -1;
    }

    // public void displaySearch(int[] arr) {
    // do {
    // int value = ArrayUtils.getInt("Enter search value: ", "Integer only", "Out of
    // range", Integer.MIN_VALUE, Integer.MAX_VALUE);
    // int foundIndex = binarySearch(arr, value, 0, arr.length - 1);
    // if (foundIndex == -1) {
    // System.out.println("Can't found " + value);
    // } else {
    // System.out.println("Found " + value + " at index: " + foundIndex);
    // break;
    // }
    // } while (ArrayUtils.pressYNtoContinue("Do you want to find other
    // value?(Y/N)"));
    // }
}
