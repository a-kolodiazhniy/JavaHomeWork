package com.pb.kolodiazhniy.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientInterface extends JFrame {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 7654;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private class EventHandler implements ActionListener{
        private PrintWriter out;
        private JTextField nickname;

        public EventHandler(PrintWriter out, JTextField nickname) {
            this.out = out;
            this.nickname = nickname;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField input = (JTextField) e.getSource();
            String nick = nickname.getText();
            out.println(nick + ": " + e.getActionCommand());
            input.setText("");
        }
    }

    private static class Consumer extends Thread {
        BufferedReader in;
        JTextArea textArea;

        Consumer(BufferedReader in, JTextArea textArea) {
            this.in = in;
            this.textArea = textArea;
        }

        @Override
        public void run() {
            try {
                String message = null;
                while ((message = in.readLine()) != null) {
                    if (message.equals("exit")) break;
                    textArea.append(message + "\n");
                }
            } catch (Exception e) {
                System.out.println("ВОЗНИКЛА ОШИБКА");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new ClientInterface();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private final JTextArea textArea = new JTextArea();
    private final JTextField nickname = new JTextField("Client");
    private final JTextField input = new JTextField();


    private ClientInterface() throws IOException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setResizable(false);

        textArea.setEditable(false);
        textArea.setLineWrap(true);

        nickname.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        input.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        System.out.println("Соединяемся с сервером " + IP + ":" + PORT);
        Socket server = new Socket(IP, PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);

        Consumer consumer = new Consumer(in, textArea);
        consumer.start();

        outServer.println(nickname.getText() + ": успешно подключился");

        input.addActionListener(new EventHandler(outServer, nickname));

        add(textArea, BorderLayout.CENTER);
        add(input, BorderLayout.SOUTH);
        add(nickname, BorderLayout.NORTH);

        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                outServer.println(nickname.getText() + ": отключился");
                System.exit(0);
            }
        });
    }
}
