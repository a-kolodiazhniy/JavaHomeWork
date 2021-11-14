package com.pb.kolodiazhniy.hw7;

public class Skirt extends Clothes implements WomanClothes {

    public Skirt(Size size, int cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина одела юбку\nразмер: "
                + size.getDescription() + "(" + size.getEuroSize() + ")\n"
                + "стоимость: " + cost + "$\n"
                + "цвет: " + color
        );
    }
}
