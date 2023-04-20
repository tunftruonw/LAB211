package bo;

import utils.ArrayUtils;

public class BubbleSort {
    
    public int[] bubbleSort(int[] arr) {
        int[] clone = ArrayUtils.cloneArray(arr);
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < clone.length - j; i++) {
                if (clone[i] > clone[i + 1]) {
                    ArrayUtils.swap(clone, i, i+1);
                    swapped = true;
                }
            }
        }
        return clone;
    }
}
