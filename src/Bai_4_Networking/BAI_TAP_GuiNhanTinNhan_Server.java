package Bai_4_Networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BAI_TAP_GuiNhanTinNhan_Server {
    public static void main(String[] args) throws IOException {
        int serverPost = 3456;
        ServerSocket serverSocket = new ServerSocket(serverPost);
        System.out.println("Server is running...");

        Socket socket = serverSocket.accept();

        while (true) {
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRoad = inputStream.read(buffer);
            String receive = new String(buffer, 0, bytesRoad);
            System.out.print("Tin nhắn tới: " + receive + "\n");


            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Máy chủ nhập: ");
            String messenger = scanner.nextLine();
            outputStream.write(messenger.getBytes());

            if ("exit".equals(messenger)) {
                socket.close();
                serverSocket.close();
            }
        }

    }
}
