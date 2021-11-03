package com.pb.kolodiazhniy.hw6;

import java.util.Objects;

public class Cat extends Animal{
    private String name;
    private static final String kind = "Кот";
    private String hobby = "распространять шерсть по всему дому";

    public Cat() {
        super(kind);
    }

    public Cat(String food, String location) {
        super(food, location, kind);
    }

    public Cat(String food, String location, String name) {
        super(food, location, kind);
        this.name = name;
    }

    @Override
    public void makeNoise(){
        StringBuilder text = new StringBuilder(kind);
        if (name != null) text.append(" по кличке " + name);
        text.append(" начал орать, что голоден");
        System.out.println(text);
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    @Override
    public void eat() {
        StringBuilder text = new StringBuilder(kind);
        if (name != null) text.append(" по кличке " + name);
        text.append(" ест " + super.getFood());
        System.out.println(text);
    }

    public void doHobby() {
        StringBuilder text = new StringBuilder(kind);
        if (name != null) text.append(" по кличке " + name);
        text.append(" занялся своим любимым делом: " + hobby);
        System.out.println(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return name.equals(cat.name) && hobby.equals(cat.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hobby);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
