package com.pb.kolodiazhniy.hw15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMultiThread {
    public static ArrayList<PrintWriter> writers = new ArrayList<>();

    static class Handler implements Runnable {
        private final Socket socket;
        private final String name;

        public Handler(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + ": Получен запрос от клиента");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter outServer = new PrintWriter(socket.getOutputStream(), true);
                writers.add(outServer);

                String dataFromUser;

                while ((dataFromUser = in.readLine()) != null) {
                    String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                    for (PrintWriter pw: writers) {
                        pw.println(now + " " + dataFromUser);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 7654;
        int clientNumber = 1;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            Handler handler = new Handler(clientSocket, "Client-" + clientNumber);
            threadPool.submit(handler);

            clientNumber++;
        }
    }
}
