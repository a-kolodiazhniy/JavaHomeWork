package com.pb.kolodiazhniy.hw7;

public class Atelier {

    public static void dressMan(Clothes[] clothes) throws Exception {
        for (Clothes close : clothes) {
            if (!(close instanceof Skirt)) {
                close.getClass().getMethod("dressMan").invoke(close);
                System.out.println();
            }
        }
    }

    public static void dressWoman(Clothes[] clothes) throws Exception {
        for (Clothes close : clothes) {
            if (!(close instanceof Tie)) {
                close.getClass().getMethod("dressWomen").invoke(close);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Clothes[] clothes = new Clothes[]{
                new Tshirt(Size.XSS, 5, "красная"),
                new Pants(Size.L, 8, "черные"),
                new Skirt(Size.XS, 4, "коричневая"),
                new Tie(Size.XS, 4, "голубой"),
        };

        dressMan(clothes);
        dressWoman(clothes);
    }
}
