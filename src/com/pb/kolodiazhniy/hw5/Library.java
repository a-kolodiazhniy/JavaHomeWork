package com.pb.kolodiazhniy.hw5;

public class Library {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Попандопало И.В.", "12345", "Живописи", "2004-05-23", "+380123456789");
        Reader reader2 = new Reader("Класс-молодец А.А.", "54321", "Театрального искусства", "2003-10-04", "+380987654321");
        Reader reader3 = new Reader("Праведно-счастливый И.О.", "67890", "Тёмного искусства", "2006-06-06", "+380666666666");

        Book book1 = new Book("Майн кампф", "Адольф Гитлер", "1926г.");
        Book book2 = new Book("Некрономикон", "Абдул Альхазред", "100500 лет д.н.э.");
        Book book3 = new Book("Букварь", "Дядя Вася", "2021г.");

        Reader[] readers = new Reader[] {reader1, reader2, reader3};
        Book[] books = new Book[] {book1, book2, book3};

        System.out.println("Книги в наличии:");
        for (Book book: books) {
            System.out.println(book.getTitle() + "("
                    + book.getAuthor() + " "
                    + book.getPublicationDate() + ")");
        }

        System.out.println("\nЧитатели в библиотеке:");
        for (Reader reader: readers) {
            System.out.println("Имя: " + reader.getName()
            + "\nУченический билет: " + reader.getTicket()
            + "\nФакультет: " + reader.getFaculty()
            + "\nДата рождения: " + reader.getBirthdate()
            + "\nТелефон: " + reader.getPhone() + "\n");
        }

        reader1.takeBook(2);
        reader2.takeBook(3);

        reader1.returnBook(2);
        reader2.returnBook(3);

        reader3.takeBook(book1.getTitle(), book2.getTitle());
        reader2.takeBook(book3.getTitle());

        reader3.returnBook(book1.getTitle(), book2.getTitle());
        reader2.returnBook(book3.getTitle());

        reader1.takeBook(book1, book2, book3);
        reader2.takeBook(book1, book2, book3);

        reader1.returnBook(book1, book2, book3);
        reader2.returnBook(book1, book2, book3);
    }
}
