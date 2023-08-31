package com.example.d101_c2k14_lephamminhhieu_ktgkiii;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CAU1_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("Connecting accept!");
        while (true) {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int dataClient = inputStream.read(bytes);
            String numberFromClient = new String(bytes, 0, dataClient);

            OutputStream outputStream = socket.getOutputStream();
            String messageToClient = null;
            try {
                int numberInt = Integer.parseInt(numberFromClient);
                if (numberInt <= 0) {
                        messageToClient = "Not number in N";
                    } else if (numberInt % 2 == 0) {
                        messageToClient = "So chan";
                    } else {
                        messageToClient = "So le";
                    }
                outputStream.write(messageToClient.getBytes());
            } catch (Exception e) {
                String messToClient = "Number in Double or Not Number or Big Data";
                outputStream.write(messToClient.getBytes());
            }
        }
    }
}
