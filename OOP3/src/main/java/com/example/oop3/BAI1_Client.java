package com.example.oop3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class BAI1_Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 3456;
        Socket socket = new Socket(serverIP, serverPort);
        while (true) {
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Number: ");
            String number = scanner.nextLine();
            outputStream.write(number.getBytes());

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            String check = new String(bytes, 0, inputStream.read(bytes));
            if (check.equalsIgnoreCase("false")) {
                System.out.println("Day khong phai so nguyen");
            } else {
                System.out.println("Day la so " + check);
            }
         }
    }
}
