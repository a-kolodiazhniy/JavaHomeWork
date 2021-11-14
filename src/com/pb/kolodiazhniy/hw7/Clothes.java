package com.pb.kolodiazhniy.hw7;

public abstract class Clothes {
    Size size;
    int cost;
    String color;

    public Clothes(Size size, int cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }
}
