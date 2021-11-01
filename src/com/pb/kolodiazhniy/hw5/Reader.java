package com.pb.kolodiazhniy.hw5;

public class Reader {
    private String name;
    private String ticket;
    private String faculty;
    private String birthdate;
    private String phone;

    public Reader(String name, String ticket, String faculty, String birthdate, String phone) {
        this.name = name;
        this.ticket = ticket;
        this.faculty = faculty;
        this.birthdate = birthdate;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getTicket() {
        return ticket;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void takeBook(int count) {
        System.out.println(name + " взял " + count + " книг(и)");
    }

    public void takeBook(String... titles) {
        System.out.print(name + " взял книги: ");
        System.out.println(String.join(", ", titles));
    }

    public void takeBook(Book... books) {
        String[] bookInfo = new String[books.length];
        System.out.print(name + " взял книги: ");
        for (int i = 0; i < books.length; i++) {
            bookInfo[i] = books[i].getTitle() + "("
                    + books[i].getAuthor() + " "
                    + books[i].getPublicationDate() + ")";
        }
        System.out.println(String.join(", ", bookInfo));
    }

    public void returnBook(int count) {
        System.out.println(name + " вернул " + count + " книг(и)");
    }

    public void returnBook(String... titles) {
        System.out.print(name + " вернул книги: ");
        System.out.println(String.join(", ", titles));
    }

    public void returnBook(Book... books) {
        String[] bookInfo = new String[books.length];
        System.out.print(name + " вернул книги: ");
        for (int i = 0; i < books.length; i++) {
            bookInfo[i] = books[i].getTitle() + "("
                    + books[i].getAuthor() + " "
                    + books[i].getPublicationDate() + ")";
        }
        System.out.println(String.join(", ", bookInfo));
    }
}
