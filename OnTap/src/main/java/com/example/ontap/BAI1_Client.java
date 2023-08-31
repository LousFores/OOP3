package com.example.ontap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BAI1_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4444);
        while (true) {
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap vao so can xet: ");
            String numberString = scanner.nextLine();
            outputStream.write(numberString.getBytes());

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int numberByte = inputStream.read(bytes);
            String check = new String(bytes, 0, numberByte);
            System.out.println(numberString + check);
        }
    }
}
