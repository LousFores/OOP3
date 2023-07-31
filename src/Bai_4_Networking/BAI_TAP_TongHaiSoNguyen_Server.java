package Bai_4_Networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BAI_TAP_TongHaiSoNguyen_Server {
    public static void main(String[] args) throws IOException {
        //Khởi tạo Post server
        int serverPost = 1234;

        //Tạo kết nối Socket server để lắng nghe Client
        ServerSocket serverSocket = new ServerSocket(serverPost);
        System.out.println("Running...");

        //Chấp nhận kết nối client
        Socket socket = serverSocket.accept();

        //Đọc dữ liệu tù Client và tính tổng 2 số
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        int number1 = inputStream.readInt();
        int number2 = inputStream.readInt();
        int total = number1 + number2;

        //Gửi kết quả về Client
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeInt(total);

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();

//        int serverPost = 1234;
//        ServerSocket  serverSocket = new ServerSocket(serverPost);
//        System.out.println("Server is running...");
//        Socket socket = serverSocket.accept();
//
//        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
//        int number1 = inputStream.readInt();
//        int number2 = inputStream.readInt();
//
//        int total = number1 + number2;
//
//        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
//        outputStream.writeInt(total);
//
//        socket.close();
//        serverSocket.close();
    }
}
