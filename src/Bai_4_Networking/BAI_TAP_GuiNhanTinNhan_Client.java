package Bai_4_Networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BAI_TAP_GuiNhanTinNhan_Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int localhost = 3456;
        Socket socket = new Socket(serverIP, localhost);

        while (true) {
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Người dùng nhập tin nhắn: ");
            String messenger = scanner.nextLine();
            outputStream.write(messenger.getBytes());

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRoad = inputStream.read(buffer);
            String receive = new String(buffer, 0, bytesRoad);
            System.out.println("Tin nhắn từ server: " + receive);

            if ("exit".equals(messenger)) socket.close();
        }

    }
}
