package com.pb.kolodiazhniy.hw8;

public class OnlineShop {
    public static void main(String[] args) {
        Auth user = new Auth();
        try {
            user.signUp();
            System.out.println("===============================");
            user.signIn();
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Возникла ошибка: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
