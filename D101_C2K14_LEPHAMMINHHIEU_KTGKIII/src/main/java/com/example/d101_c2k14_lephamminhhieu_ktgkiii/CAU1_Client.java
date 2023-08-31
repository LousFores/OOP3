package com.example.d101_c2k14_lephamminhhieu_ktgkiii;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CAU1_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        while (true) {
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number: ");
            String number = scanner.nextLine();
            outputStream.write(number.getBytes());

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int databyte = inputStream.read(bytes);
            String result = new String(bytes, 0, databyte);
            System.out.println("Result: " + result);
        }
    }
}
