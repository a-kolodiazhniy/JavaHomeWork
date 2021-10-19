package com.pb.kolodiazhniy.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Random random = new Random();
        int from = 0, to = 100;
        int NUMBER = Math.abs(random.nextInt(to + 1));
        //System.out.println(NUMBER);
        int tries = 0;
        String exit = "exit";
        Scanner in = new Scanner(System.in);
        System.out.println("Угадайте число");

        while (true){
            System.out.println("Введите целое число или exit");
            String input = in.next();
            if (input.equals(exit)) break;

            try {
                int num = Integer.parseInt(input);
                if (num < from || num > to) {
                    System.out.println("Число должно быть в диапазоне [" + from + ".." + to + "]\n");
                    continue;
                }
                tries++;
                if (num == NUMBER) {
                    System.out.println("Вы угадали число за " + tries + " попыток\n");
                    break;
                }else if (num > NUMBER) {
                    System.out.println("Указанное число больше загаданного\n");
                }else {
                    System.out.println("Указанное число меньше загаданного\n");
                }
            }catch(Exception ignored) {}
        }

        System.out.println("Конец игры");
    }
}
