package Bai_4_Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BAI_TAP_PhanTichIP_Client {
    public static void main(String[] args) throws IOException {
        //Khởi tạo địa chỉ IP và Post kết nối server
        String serverIP = "127.0.0.1";
        int serverPost = 8080;

        //Tạo 1 kết nối đến server
        Socket socket = new Socket(serverIP, serverPost);

        //Nhập IP cần xử lí
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào địa chỉ IP cần xử lí: ");
        String addressIP = scanner.nextLine();
        outputStream.write(addressIP.getBytes());
        socket.close();
    }
}
