package com.pb.kolodiazhniy.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private String name;
    private static final String kind = "Собака";
    private String breed;

    public Dog() {
        super(kind);
    }

    public Dog(String food, String location) {
        super(food, location, kind);
    }

    public Dog(String food, String location, String breed) {
        super(food, location, kind);
        this.breed = breed;
    }

    public Dog(String food, String location, String breed, String name) {
        super(food, location, kind);
        this.name = name;
        this.breed = breed;
    }

    @Override
    public void makeNoise(){
        StringBuilder text = new StringBuilder(kind);
        if (breed != null) text.append(" породы " + breed);
        if (name != null) text.append(" по кличке " + name);
        text.append(" гавкнула");
        System.out.println(text);
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void eat() {
        StringBuilder text = new StringBuilder(kind);
        if (breed != null) text.append(" породы " + breed);
        if (name != null) text.append(" по кличке " + name);
        text.append(" ест " + super.getFood());
        System.out.println(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return name.equals(dog.name) && breed.equals(dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
