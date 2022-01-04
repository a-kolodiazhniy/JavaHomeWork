package com.pb.kolodiazhniy.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static class Consumer extends Thread {
        BufferedReader in;

        Consumer(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void start() {
            try {
                String message = null;
                while ((message = in.readLine()) != null) {
                    if (message.equals("exit")) break;
                    System.out.println(message);
                }
            } catch (Exception e) {
                System.out.println("ВОЗНИКЛА ОШИБКА");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Клиент стартовал");
        String serverIp = "127.0.0.1";
        int serverPort = 7654;
        System.out.println("Соединяемся с сервером " + serverIp + ":" + serverPort);

        Socket server = new Socket(serverIp, serverPort);

        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        Consumer consumer = new Consumer(in);
        consumer.run();

        String dataFromUser, dataFromServer;
        outServer.println("connected");


        try {
            // Основной цикл отправки сообщений серверу
            while ((dataFromUser = inConsole.readLine()) != null) {
                outServer.println(dataFromUser);
                if ("exit".equalsIgnoreCase(dataFromUser)) {
                    break;
                }
            }
        } finally {
            outServer.close();
            outServer.close();
            server.close();
        }
    }
}
