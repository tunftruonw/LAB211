/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tungs
 */
public class TextUtility {
    private Scanner scan = new Scanner(System.in);
    public static String getStringByRegex(String mess, String error, String regex){
        Scanner scan = new Scanner(System.in);
        String output = null;
        while(true){
            System.out.println(mess);
            output = scan.nextLine();
            if(output.matches(regex) && !removeUnnecessaryBlank(output).equalsIgnoreCase("")){
                return output;
            } else {
                System.err.println(error);
            }
        }
    }
    
    public static String removeUnnecessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static String removeAllBlank(String input) {
        return input.trim().replaceAll("\\s+", "");
    }

    public static boolean pressYNtoContinue(String mess) {
        //"Do you want to continue (Y/N): "
        String input = getStringByRegex(mess, "Y/N only!!!", "[YNyn]");
        return input.equalsIgnoreCase("y");
    }

    public static String normalFormName(String input) {
        input = removeUnnecessaryBlank(input);
        String temp[] = input.split(" ");
        input = "";
        for (int i = 0; i < temp.length; i++) {
            input += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                input += " ";
            }
        }
        return input;
    }

    public static String getNonEmptyString(String mess) {
        String ret = "";
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            ret = removeUnnecessaryBlank(scan.nextLine());
            if (ret.equalsIgnoreCase("")) {
                System.err.println("Please input Non-Empty String!!!");
                continue;
            }
            return ret;
        }
    }

    public static String normalFormStringAfterDot(String input) {
        String output = "";
        input = removeUnnecessaryBlank(input);
        input = String.valueOf(input.charAt(0)).toUpperCase() + input.substring(1);

        input = input.replaceAll("\\.\\s+", "\\.").replaceAll("\\s+\\.", "\\.");
        output += input.charAt(0);
        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i - 1) == '.' && Character.isAlphabetic(input.charAt(i))) {
                output += " " + Character.toUpperCase(input.charAt(i));
            } else {
                output += input.charAt(i);
            }
        }
        return output;
    }

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

    public static String getEmail(String mess) {

        String regex = "^[A-Za-z](.*)([@]{1})(.{2,})(\\.)(.{2,})";//phai bat dau bang chu cai
        String email = getStringByRegex(mess, "Please enter email with format <account name>@<domain>", regex);
        return email;
    }

    public static String getPhone(int minLength, String mess) {
        String regex = "[0-9 ]+";
        while (true) {
            String phoneNum = getStringByRegex(mess, "Please enter number only!!", regex).replaceAll("\\s+", "");
            if (phoneNum.length() < minLength) {
                System.err.println("Phone number must be at least 10 characters");
            } else {
                return phoneNum;
            }
        }
    }
    
    public static String inputDate(String mess) {
        Scanner scan = new Scanner(System.in);
        System.out.print(mess);
        //set format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        //force user input exectly a date
        while(true) {
            String input = scan.nextLine();
            try {
                Date date = dateFormat.parse(input);
                //get current date
                Date curDate = Calendar.getInstance().getTime();
                //check range of date
                if (curDate.compareTo(date) < 0) {
                    System.out.print("Please input date that before current date: ");
                    continue;
                }
                dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                return dateFormat.format(date);
            } catch (Exception e) {
                System.out.print("Please input valid date (dd-MM-yyyy): ");
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(inputDate("da"));
    }
}


