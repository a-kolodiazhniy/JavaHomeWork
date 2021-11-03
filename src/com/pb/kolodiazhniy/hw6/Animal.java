package com.pb.kolodiazhniy.hw6;

public class Animal {
    private String food = "неизвестно";
    private String location = "неизвестно";
    private String kind = "Животное";

    Animal() {

    }

    Animal(String kind) {
        this.kind = kind;
    }

    Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    Animal(String food, String location, String kind) {
        this.food = food;
        this.location = location;
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }
    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public void makeNoise() {
        System.out.println(kind + " издает звуки");
    }

    public void eat() {
        System.out.println("Животное ест");
    }

    public void sleep() {
        System.out.println(kind + " спит");
    }
}
