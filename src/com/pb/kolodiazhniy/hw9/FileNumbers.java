package com.pb.kolodiazhniy.hw9;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileNumbers {
    static final int MAX_LENGTH = 10;
    static final String pathName = "src/com/pb/kolodiazhniy/hw9/files/numbers.txt";
    static final String newPathName = "src/com/pb/kolodiazhniy/hw9/files/odd-numbers.txt";

    private static int[] createRandomRow() {
        int[] array = new int[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    private static Path getFile(String name) {
        Path path = null;
        try {
            path = Files.createFile(Paths.get(name));
        } catch (Exception ignored) {
            path = Paths.get(name);
        }
        return path;
    }

    private static void createNumbersFile() {
        Path path = getFile(pathName);
        // write to file
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < MAX_LENGTH; i++) {
                String row = Arrays.stream(createRandomRow())
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
                writer.write(row);
                if (i < MAX_LENGTH - 1) writer.newLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error with file write: " + ex);
        }
        System.out.println("Файл " + pathName + " создан");
    }

    private static String replaceOdd(String str) {
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i]) % 2 == 0) arr[i] = "0";
        }
        return String.join(" ", arr);
    }

    private static void createOddNumbersFile() {
        Path path = getFile(pathName);
        Path newFile = getFile(newPathName);
        int i = 0;
        try (Scanner scan = new Scanner(path)) {
            try (BufferedWriter writer = Files.newBufferedWriter(newFile)) {
                while (scan.hasNext()) {
                    String str = scan.nextLine();
                    String replaced = replaceOdd(str);
                    if (i > 0) replaced = "\n" + replaced;
                    writer.write(replaced);
                    i++;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error with file write: " + ex);
                return;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Файл " + newPathName + " создан");
    }

    public static void main(String[] args) {
        createNumbersFile();
        createOddNumbersFile();
    }
}
