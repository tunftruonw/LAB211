package bo;

import utils.ArrayUtils;

public class BubbleSearch {

    public int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }

//    public void displaySearch(int[] arr) {
//        do {
//            int value = ArrayUtils.getInt("Enter search value: ", "Integer only", "Out of range", Integer.MIN_VALUE, Integer.MAX_VALUE);
//            int foundIndex = binarySearch(arr, value, 0, arr.length - 1);
//            if (foundIndex == -1) {
//                System.out.println("Can't found " + value);
//            } else {
//                System.out.println("Found " + value + " at index: " + foundIndex);
//                break;
//            }
//        } while (ArrayUtils.pressYNtoContinue("Do you want to find other value?(Y/N)"));
//    }
}
