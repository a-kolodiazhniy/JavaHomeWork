package com.pb.kolodiazhniy.hw11;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void add(Contact contact) {
        contacts.add(contact);
    }

    private void newContact() {
        Scanner in = new Scanner(System.in);
        LocalDate dateOfBirth;
        String name, address, phones;
        System.out.println("Вы в меню добавления контактов");

        System.out.println("Введите имя контакта");
        name = in.nextLine();
        dateOfBirth = getDate(in);

        System.out.println("Введите номера телефонов через пробел");
        phones = in.nextLine();

        System.out.println("Введите адрес контакта");
        address = in.nextLine();

        Contact contact = new Contact(name, dateOfBirth, phones, address);
        contacts.add(contact);
        System.out.println("Добавлен новый контакт:\n" + contact);
        mainMenu();
    }

    private LocalDate getDate(Scanner in) {
        try {
            System.out.println("Введите дату рождения в формате YYYY-MM-DD");
            String[] date = in.nextLine().split("-");
            return LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        } catch (Exception e) {
            System.out.println("Неправильная дата. Попробуйте еще раз");
            getDate(in);
        }
        return LocalDate.now();
    }

    public void mainMenu() {
        System.out.println("Приветствуем Вас в главном меню телефонного справочника");
        switch (getMenu(8)) {
            case 1:
                newContact();
                break;
            case 2:
                deleteContacts();
                break;
            case 3:
                findContacts();
                break;
            case 4:
                printAll();
                break;
            case 5:
                editContact();
                break;
            case 6:
                saveToFile();
                break;
            case 7:
                loadFromFile();
                break;
            case 8:
                break;
        }

    }

    private int getMenu(int menus) {
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите меню:");
        System.out.println("1) Добавить контакт;\n2) Удалить контакт;\n3) Найти контакт;\n4) Показать все контакты;\n5) Редактировать контакт;\n6) Сохранить в файл;\n7) Загрузить из файла;\n8) Выход.");
        try {
            int num = in.nextInt();
            if (num > 0 && num <= menus) return num;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Необходимо ввести число от 1 до " + menus);
            getMenu(menus);
        }
        return 0;
    }

    private ArrayList<Contact> getContacts() {
        System.out.println("В справочнике " + contacts.size() + " контактов.\nВведите критерий поиска");
        Scanner in = new Scanner(System.in);
        String query = in.nextLine();
        return (ArrayList<Contact>) contacts.stream()
                .filter(x -> x.toString().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    private void findContacts() {
        Scanner in = new Scanner(System.in);
        ArrayList<Contact> foundedContacts = getContacts();
        System.out.println();
        if (foundedContacts.size() > 0) {
            for (Contact contact : foundedContacts) {
                System.out.println(contact);
            }
        } else {
            System.out.println("По заданному критерию контакты не найдены");
        }

        System.out.println("Искать еще?\n1 - Да\n2 - Главное меню");
        switch (in.nextInt()) {
            case 1:
                findContacts();
                break;
            case 2:
                mainMenu();
                break;
        }
    }

    private void deleteContacts() {
        Scanner in = new Scanner(System.in);
        ArrayList<Contact> foundContacts = getContacts();
        System.out.println();
        if (foundContacts.size() > 0) {
            int i = 0;
            for (Contact contact : foundContacts) {
                i++;
                System.out.println("№" + i + ")\n" + contact);
            }
            System.out.println("№" + ++i + ") Удалить все");
            System.out.println("№" + ++i + ") Главное меню");
            System.out.println("Какой контакт удалить? Введите его номер:");
            int toDeleteIdx = in.nextInt() - 1;

            if (toDeleteIdx == foundContacts.size() + 1) {
                mainMenu();
                return;
            }

            if (toDeleteIdx == foundContacts.size()) {
                contacts.removeAll(foundContacts);
                System.out.println("Удалено контактов " + foundContacts.size());
            } else {
                while (toDeleteIdx > foundContacts.size() + 1 || toDeleteIdx < 0) {
                    System.out.println("Некорректный номер. Попробуйте еще раз...");
                    toDeleteIdx = in.nextInt() - 1;
                }
                contacts.remove(foundContacts.get(toDeleteIdx));
                System.out.println("Удален контакт " + foundContacts.get(toDeleteIdx));
            }
        } else {
            System.out.println("По заданному критерию контакты не найдены");
        }

        System.out.println("Искать еще?\n1 - Да\n2) - Главное меню");
        switch (in.nextInt()) {
            case 1:
                findContacts();
                break;
            case 2:
                mainMenu();
                break;
        }
    }

    private void editContact() {
        Scanner in = new Scanner(System.in);
        Contact toEdit = null;
        ArrayList<Contact> foundContacts = getContacts();
        System.out.println();
        if (foundContacts.size() > 0) {
            int i = 0;
            for (Contact contact : foundContacts) {
                i++;
                System.out.println("№" + i + ")\n" + contact);
            }
            System.out.println("№" + ++i + ") Главное меню");
            System.out.println("Какой контакт редактировать? Введите его номер:");
            int toDeleteIdx = in.nextInt() - 1;

            if (toDeleteIdx == foundContacts.size()) {
                mainMenu();
                return;
            }
            while (toDeleteIdx > foundContacts.size() + 1 || toDeleteIdx < 0) {
                System.out.println("Некорректный номер. Попробуйте еще раз...");
                toDeleteIdx = in.nextInt() - 1;
            }
            toEdit = foundContacts.get(toDeleteIdx);
            editParameter(toEdit);
        } else {
            System.out.println("По заданному критерию контакты не найдены");
            System.out.println("Искать еще?\n1 - Да\n2) - Главное меню");
            switch (in.nextInt()) {
                case 1:
                    editContact();
                    break;
                case 2:
                    mainMenu();
                    break;
            }
        }
    }
    
    private void editParameter(Contact toEdit) {
        Scanner in = new Scanner(System.in);
        System.out.println("Какое поле редактировать? Введите номер");
        System.out.println("1) Имя\n2) Дата рождения\n3) Телефоны\n4) Адрес\n5) Главное меню");
        int num = in.nextInt();
        int maxMenus = 5;
        while (num > maxMenus || num < 1){
            System.out.println("Некорректный пункт. Попробуйте еще раз");
            num = in.nextInt();
        }
        String input;

        switch (num) {
            case 1:
                System.out.println("Введите новое имя");
                input = in.next();
                toEdit.setName(input);
                break;
            case 2:
                System.out.println("Введите новую дату");
                input = in.next();
                toEdit.setDateOfBirth(LocalDate.parse(input));
                break;
            case 3:
                System.out.println("Введите новое имя");
                input = in.next();
                toEdit.setPhones(input);
                break;
            case 4:
                System.out.println("Введите новый адрес");
                input = in.next();
                toEdit.setAddress(input);
                break;
            case 5:
                mainMenu();
                return;
        }
        System.out.println("Новое значение:\n" + toEdit);

        System.out.println("Редактировать другое поле?\n1 - Да\n2) - Главное меню");
        switch (in.nextInt()) {
            case 1:
                editParameter(toEdit);
                break;
            case 2:
                mainMenu();
                break;
        }
    }

    private void printAll() {
        System.out.println("Вы в меню отображения всех контактов. В справочнике " + contacts.size() + " контактов");

        Scanner in = new Scanner(System.in);
        System.out.println("По какому полю сортировать?\n1) По имени;\n2) По дате рождения;\n3) По адресу;\n4) Главное меню");
        switch (in.nextInt()) {
            case 1:
                contacts.stream().sorted((x1, x2) -> x1.getName().compareToIgnoreCase(x2.getName())).forEach(System.out::println);
                break;
            case 2:
                contacts.stream().sorted(Comparator.comparing(Contact::getDateOfBirth)).forEach(System.out::println);
                break;
            case 3:
                contacts.stream().sorted((x1, x2) -> x1.getAddress().compareToIgnoreCase(x2.getAddress())).forEach(System.out::println);
                break;
            case 4:
                mainMenu();
                return;
            default:
                printAll();
                return;
        }

        printAll();
    }

    private String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();;
        return gson.toJson(contacts);
    }

    private void fromJson(String json) {
        Gson gson = new Gson();
        contacts = gson.fromJson(json, new TypeToken<List<Contact>>(){}.getType());
    }

    private void saveToFile() {
        System.out.println("Введите имя файла");
        Scanner in = new Scanner(System.in);
        Path path = getFile(in.nextLine() + ".json");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(toJson());
            System.out.println("Данные успешно сохранены в файл " + path);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Ошибка записи в файл: " + ex);
        }
        System.out.println();
        mainMenu();
    }

    private void loadFromFile() {
        System.out.println("Введите имя файла");
        Scanner in = new Scanner(System.in);
        Path path = getFile(in.nextLine() + ".json");
        StringBuilder fileData = new StringBuilder();


        try (Scanner scan = new Scanner(path)) {
            while (scan.hasNext()) {
                fileData.append(scan.nextLine());
            }
            fromJson(fileData.toString());
            System.out.println("Данные успешно загружены из файла " + path);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка чтения их файла: " + ex);
        }

        System.out.println();
        mainMenu();
    }

    private static Path getFile(String name) {
        String basePath = new File("").getAbsolutePath();
        String allPath = basePath + "/src/com/pb/kolodiazhniy/hw11/files/" + name;
        Path path;
        try {
            path = Files.createFile(Paths.get(allPath));
        } catch (Exception ignored) {
            path = Paths.get(allPath);
        }
        return path;
    }
}
