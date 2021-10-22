package com.pb.kolodiazhniy.hw4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {
    public static void main(String[] args) {
        String str1, str2;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первую строку");
        str1 = in.nextLine();

        System.out.println("Введите первую строку");
        str2 = in.nextLine();

        isAnagram(str1, str2);

    }

    public static void isAnagram(String str1, String str2) {
        char[] arr1 = clearString(str1).toCharArray();
        char[] arr2 = clearString(str2).toCharArray();
        str1 = String.valueOf(sortArray(arr1));
        str2 = String.valueOf(sortArray(arr2));

        if (str1.equals(str2)) {
            System.out.println("Строка 2 является анаграммой строки 1");
        }else {
            System.out.println("Строка 2 НЕ является анаграммой строки 1");
        }
    }

    public static String clearString(String str) {
        String result = "";
        Pattern pattern = Pattern.compile("[а-я]+");
        Matcher matcher = pattern.matcher(str.toLowerCase());
        while (matcher.find()) {
            result += matcher.group();
        }
        return result;
    }

    public static char[] sortArray(char[] array) {
        int to = array.length - 1;
        for (int i = 0; i < to; i++) {
            char temp;
            for (int j = 0; j < to - i; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
