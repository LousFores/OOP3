package Bai_4_Networking;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class BAI_TAP_TongHaiSoNguyen_Client {
    public static void main(String[] args) throws IOException {
        //Khai báo IP và post của server
        String serverIP = "127.0.0.1";
        int serverPost = 1234;

        //Kết nối đến server
        Socket socket = new Socket(serverIP, serverPost);

        //Tiếng hành gửi 2 số đến server để xử lí
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số thứ nhất: ");
        int number1 = scanner.nextInt();
        outputStream.writeInt(number1);

        System.out.print("Nhập vào số thứ hai: ");
        int number2 = scanner.nextInt();
        outputStream.writeInt(number2);

        //Nhận dữ liệu từ server
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        int result = inputStream.readInt();
        System.out.println("Tổng 2 số nguyên: " + result);

        socket.close();






//        String serverIP = "127.0.0.1";
//        int serverPort = 1234;
//        Socket socket = new Socket(serverIP, serverPort);
//
//        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Nhập số thứ 1: ");
//        int number1 = scanner.nextInt();
//        outputStream.writeInt(number1);
//        System.out.println("Nhập số thứ 2: ");
//        int number2 = scanner.nextInt();
//        outputStream.writeInt(number2);
//
//        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
//        int result = inputStream.readInt();
//        System.out.println("Kết quả tổng: " + result);
//
//        socket.close();
    }
}
