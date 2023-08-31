package com.example.ontap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BAI1_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        Socket socket = serverSocket.accept();
        System.out.println("Accept Success");

        while (true) {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int numberString = inputStream.read(bytes);
            int number = Integer.parseInt(new String(bytes, 0, numberString));
            System.out.println("Number need check: " + number);

            OutputStream outputStream = socket.getOutputStream();
            String result = checkNumber(number);
            outputStream.write(result.getBytes());
        }
    }

    public static String checkNumber(int number) {
        if (number <= 0) {
            return " khong phai so nguyen";
        } else {
            if (number % 2 == 0) return " so chan";
            else return " so le";
        }
    }
}
