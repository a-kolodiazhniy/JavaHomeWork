package com.pb.kolodiazhniy.hw7;

public class Tie extends Clothes implements ManClothes {

    public Tie(Size size, int cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина одел галстук\nразмер: "
                + size.getDescription() + "(" + size.getEuroSize() + ")\n"
                + "стоимость: " + cost + "$\n"
                + "цвет: " + color
        );
    }
}
