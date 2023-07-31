package Bai_4_Networking;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class THUC_HANH_GuiNhanDuLieu_Use_TCP {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 8080;
        Socket socket = new Socket(serverIP, serverPort);
        OutputStream outputStream = socket.getOutputStream();
        String message = "Hello, server!";
        outputStream.write(message.getBytes());
        socket.close();

        int socket = 8080;
    }


}
