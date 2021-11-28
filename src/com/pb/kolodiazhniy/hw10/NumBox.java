package com.pb.kolodiazhniy.hw10;

public class NumBox<T extends Number> {
    private final Number[] array;

    public NumBox(int length) {
        array = new Number[length];
    }

    public void add(T num) throws Exception {
        int index = length();
        if (index == array.length) throw new Exception("Массив переполнен");
        array[index] = num;

    }

    public int length() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) return i;
        }
        return array.length;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public double average() {
        double sum = 0;
        for (Number el : array) {
            sum = sum + el.doubleValue();
        }
        return sum / array.length;
    }

    public double sum() {
        double sum = 0;
        for (Number el : array) {
            sum = sum + el.doubleValue();
        }
        return sum;
    }

    public T max() {
        double max = array[0].doubleValue();
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            double el = array[i].doubleValue();
            if (el > max) {
                max = el;
                maxIndex = i;
            }
        }
        return (T) array[maxIndex];
    }
}
