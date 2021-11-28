package com.pb.kolodiazhniy.hw10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Float");
        NumBox<Float> arr1 = new NumBox<>(3);
        arr1.add(2.3f);
        arr1.add(5f);
        arr1.add(1.1f);
        //arr1.add(4.12f);
        System.out.println("Первый элемент:" + arr1.get(0));
        System.out.println("Длина массива:" + arr1.length());
        System.out.println("Среднее арифметическое:" + arr1.average());
        System.out.println("Сумма элементов:" + arr1.sum());
        System.out.println("Максимальный элемент:" + arr1.max());

        System.out.println("=======\nInteger");
        NumBox<Integer> arr2 = new NumBox<>(3);
        arr2.add(2);
        arr2.add(5);
        arr2.add(1);
        //arr2.add(4.12f);
        System.out.println("Первый элемент:" + arr2.get(0));
        System.out.println("Длина массива:" + arr2.length());
        System.out.println("Среднее арифметическое:" + arr2.average());
        System.out.println("Сумма элементов:" + arr2.sum());
        System.out.println("Максимальный элемент:" + arr2.max());
    }
}
