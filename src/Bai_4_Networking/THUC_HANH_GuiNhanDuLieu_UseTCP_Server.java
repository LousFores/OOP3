package Bai_4_Networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.spec.RSAOtherPrimeInfo;

public class THUC_HANH_GuiNhanDuLieu_UseTCP_Server {
    public static void main(String[] args) throws IOException {

        //Khai báo post trùng với post bên file Client
        int serverPort = 8080;

        //Tạo socket server lắng nghe kết nối từ Client
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server is running and waiting for connections...");

        //Chấp nhận kết nối từ Client
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        //Đọc dữ liệu từ Client
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String message = new String(buffer,0, bytesRead);
        System.out.println("Received massage from client: " + message);

        //Đóng cổng kết nối
        socket.close();
        serverSocket.close();
    }
}