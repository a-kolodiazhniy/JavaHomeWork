package com.pb.kolodiazhniy.hw5;

public class Library {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Попандопало И.В.", "12345", "Живописи", "2004-05-23", "+380123456789");
        Reader reader2 = new Reader("Класс-молодец А.А.", "54321", "Театрального искусства", "2003-10-04", "+380987654321");

        Book book1 = new Book("Майн кампф", "Адольф Гитлер", "1926г.");
        Book book2 = new Book("Некрономикон", "Абдул Альхазред", "100500 лет д.н.э.");
        Book book3 = new Book("Букварь", "Дядя Вася", "2021г.");

        reader1.takeBook(2);
        reader2.takeBook(3);

        reader1.returnBook(2);
        reader2.returnBook(3);

        reader1.takeBook(book1.getTitle(), book2.getTitle());
        reader2.takeBook(book3.getTitle());

        reader1.returnBook(book1.getTitle(), book2.getTitle());
        reader2.returnBook(book3.getTitle());

        reader1.takeBook(book1, book2, book3);
        reader2.takeBook(book1, book2, book3);

        reader1.returnBook(book1, book2, book3);
        reader2.returnBook(book1, book2, book3);
    }
}
