package com.pb.kolodiazhniy.hw6;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class VetСlinic {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Рефлексия
        Class сlazz = Class.forName("com.pb.kolodiazhniy.hw6.Veterinarian");
        Veterinarian veterinarian = null;
        Constructor constr = сlazz.getConstructor(new Class[] {});
        Object obj = constr.newInstance();
        if (obj instanceof Veterinarian) veterinarian = (Veterinarian) obj;
        //Штампуем животных
        Dog dog1 = new Dog("что дадут", "во дворах");
        Dog dog2 = new Dog("что дадут", "во дворах", "дворовая");
        Dog dog3 = new Dog("что дадут", "во дворах", "дворовая", "Псина-дубина");

        Cat cat1 = new Cat("мясо", "квартира");
        Cat cat2 = new Cat("рыбу", "свежевыстиранная одежда", "Шерстяное создание");

        Horse horse1 = new Horse("овёс", "ферма");
        Horse horse2 = new Horse("морковку", "зоопарк", "гнедой");
        Horse horse3 = new Horse("печенько", "воля", "вороной");

        Animal[] animals = new Animal[] {dog1, dog2, dog3, cat1, cat2, horse1, horse2, horse3};

        for (Animal animal: animals) {
            if (veterinarian != null) {
                veterinarian.treatAnimal(animal);
            }
            animal.makeNoise();
            animal.eat();
            animal.sleep();
            if (animal instanceof Cat) ((Cat) animal).doHobby();
            if (animal instanceof Horse) ((Horse) animal).run();
        }
    }
}
