package com.example.oop3;

import javafx.scene.Parent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BAI1_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3456);
        Socket socket = serverSocket.accept();
        System.out.println("Socket Accept");
        while (true) {
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                String newNumber = new String(bytes, 0, inputStream.read(bytes));
                int number = Integer.parseInt(newNumber);
                System.out.println("Number to be process: " + number);

                String result = checkParity(number);

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(result.getBytes());
        }

    }
    public static String checkParity(int number) {
        if (number <= 0) return "false";
        else {
            if (number % 2 == 0) return "Chan";
            else return "Le";
        }
    }
}
