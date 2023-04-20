package utils;

import java.util.Random;
import java.util.Scanner;

public class ArrayUtils {

    public static int getInt(String mess, String errorNumberFormat, String errorOutOfRange, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return ret;
            }
        }

    }

    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner scan = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.println(mess);
            output = scan.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }
    
    public static boolean pressYNtoContinue(String mess) {
        //"Do you want to continue (Y/N): "
        String input = getStringByRegex(mess, "Y/N only!!!", "[YNyn]");
        return input.equalsIgnoreCase("y");
    }

    public static int[] createArray(int length, int limitRandom) {
        int[] arr = new int[length];
        randomArrayValue(arr, limitRandom);
        return arr;
    }

    public static int[] cloneArray(int[] arr) {
        int[] clone = new int[arr.length];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            clone[c++] = arr[i];
        }
        return clone;
    }

    public static int[] randomArrayValue(int[] arr, int limitRandom) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(limitRandom);
        }
        return arr;
    }
    
    public static void swap(int array[], int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }
}
