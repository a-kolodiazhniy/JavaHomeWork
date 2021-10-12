package com.pb.kolodiazhniy.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int x;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число");
        x = in.nextInt();

        if (x >=0 && x < 15) {
            System.out.println("Число " + x + " входит в интервал [0 - 14]");
        } else if (x >=15 && x < 36) {
            System.out.println("Число " + x + " входит в интервал [15 - 35]");
        } else if (x >=36 && x < 51) {
            System.out.println("Число " + x + " входит в интервал [36 - 50]");
        } else if (x >=51 && x < 101) {
            System.out.println("Число " + x + " входит в интервал [51 - 100]");
        } else {
            System.out.println("Число " + x + " не входит в заданные интервалы");
        }
    }
}
