package com.pb.kolodiazhniy.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int x, y;
        char sign;
        float result;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое целое число");
        x = in.nextInt();
        System.out.println("Введите второе целое число");
        y = in.nextInt();
        System.out.println("Введите операцию +, -, * или /");
        sign = in.next().charAt(0);

        try {
            switch (sign) {
                case '+':
                    result = x + y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '*':
                    result = x * y;
                    break;
                case '/':
                    if (y == 0) throw new Exception("Делить на 0 нельзя");
                    result = x / y;
                    break;
                default:
                    throw new Exception("Неизвестная операция");
            }
            System.out.println("Результат операции: " + x + " " + sign + " " + y + " = " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
