package com.pb.kolodiazhniy.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        byte SIZE = 10;
        int[] array = new int[SIZE];
        boolean isError = false;
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите целое число, " + (i+1) + "-й элемент массива из " + SIZE);
            try {
                array[i] = in.nextInt();
            }catch (Exception e){
                System.out.println("Вы ввели не целое число");
                isError = true;
                break;
            }
        }
        if (!isError) {
            System.out.print("Введенный массив: " + Arrays.toString(array));
            System.out.println("\nСумма всех элементов массива: " + sum(array));
            System.out.println("Количество положительных элементов массива: " + positiveCount(array));
            System.out.println("Отсортированный массив : " + Arrays.toString(sortArray(array)));
        }
        System.out.println("Конец процесса");
    }

    public static long sum(int[] array) {
        long sum = 0;
        for (int el : array) {
            sum += el;
        }
        return sum;
    }

    public static int positiveCount(int[] array) {
        int count = 0;
        for (int el : array) {
            if (el > 0) count++;
        }
        return count;
    }
    
    public static int[] sortArray(int[] array) {
        int to = array.length - 1;
        for (int i = 0; i < to; i++) {
            int temp;
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
