package com.pb.kolodiazhniy.hw11;

import com.google.gson.Gson;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        contactBook.add(new Contact("Пупкин Василий Иванович", LocalDate.parse("1987-05-23"), "+380991234567 +380957093989", "Дом дома и домом погоняет"));
        contactBook.add(new Contact("Васильев Пупк Пертович", LocalDate.parse("1988-01-02"), "+398784212454", "Город, улица и дом"));
        contactBook.add(new Contact("Грозный Иван Васильевич", LocalDate.parse("1530-08-25"), "голубь", "Русь бабушка"));
        contactBook.mainMenu();
    }
}
