package com.pb.kolodiazhniy.hw11;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Contact {
    private String name;
    private LocalDate dateOfBirth;
    private String phones;
    private String address;
    private LocalDateTime modifyDate;

    public Contact(){
        this.modifyDate = LocalDateTime.now();
    }

    public Contact(String name, LocalDate dateOfBirth, String phones, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phones = phones;
        this.address = address;
        this.modifyDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(dateOfBirth, contact.dateOfBirth) && Objects.equals(phones, contact.phones) && Objects.equals(address, contact.address) && Objects.equals(modifyDate, contact.modifyDate);
    }

    @Override
    public String toString() {
        return MessageFormat.format("Имя: {0}\nДата рождения: {1}\nТелефоны: {2}\nАдрес: {3}\nДата модификации: {4}\n",
                name, dateOfBirth.toString(), phones, address, modifyDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, phones, address, modifyDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.modifyDate = LocalDateTime.now();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.modifyDate = LocalDateTime.now();
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
        this.modifyDate = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.modifyDate = LocalDateTime.now();
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate() {
        this.modifyDate = LocalDateTime.now();
    }
}
