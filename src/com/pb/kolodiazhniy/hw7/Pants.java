package com.pb.kolodiazhniy.hw7;

public class Pants extends Clothes implements ManClothes, WomanClothes {

    public Pants(Size size, int cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина одел штаны\nразмер: "
                + size.getDescription() + "(" + size.getEuroSize() + ")\n"
                + "стоимость: " + cost + "$\n"
                + "цвет: " + color
        );
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина одела штаны\nразмер: "
                + size.getDescription() + "(" + size.getEuroSize() + ")\n"
                + "стоимость: " + cost + "$\n"
                + "цвет: " + color
        );
    }
}
