package com.pb.kolodiazhniy.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        String str;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        str = in.nextLine();
        System.out.println("Результирующая строка: " + toUpper(str));
    }

    public static String toUpper(String str) {
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.toUpperCase(arr[i].charAt(0)) + arr[i].substring(1);
        }
        return String.join(" ", arr);
    }
}
