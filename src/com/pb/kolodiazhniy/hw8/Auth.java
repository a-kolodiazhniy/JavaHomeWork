package com.pb.kolodiazhniy.hw8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password;


    public void signUp() throws WrongLoginException, WrongPasswordException {
        String login, password, confirmPassword;
        Pattern loginPattern = Pattern.compile("[A-Za-z0-9]{5,20}");
        Pattern passwordPattern = Pattern.compile("[A-Za-z0-9_]{5,}");

        Scanner in = new Scanner(System.in);

        System.out.println("Регистрация в системе:\nПридумайте логин");
        login = in.nextLine();

        Matcher loginMatcher = loginPattern.matcher(login);
        if (!loginMatcher.find()) throw new WrongLoginException("Логин должен состоять только из латинских букв и цифр, длина 5-20 символов");

        System.out.println("Придумайте пароль");
        password = in.nextLine();

        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.find()) throw new WrongPasswordException("Пароль должен состоять только из латинских букв и цифр, символа подчеркивания, длина не менее 5");

        System.out.println("Введите повторно пароль");
        confirmPassword = in.nextLine();

        if (!password.equals(confirmPassword)) throw new WrongPasswordException("Пароли не совпадают");

        this.login = login;
        this.password = password;
        System.out.println("Вы успешно зарегистрированы");
    }

    public void signIn() throws WrongLoginException {
        String login, password;
        Scanner in = new Scanner(System.in);

        System.out.println("Вход в систему\nВведите Ваш логин");
        login = in.nextLine();

        System.out.println("Введите Ваш пароль");
        password = in.nextLine();

        if (!login.equals(this.login) || !password.equals(this.password)) throw new WrongLoginException("Неправильный логин или пароль");
        System.out.println("Вы авторизованы");
    }
}
