package Bai_4_Networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BAI_TAP_PhanTichIP_Server {
    public static void main(String[] args) throws IOException {
        //Khởi tạo Post cho server
        int serverPost = 8080;
        //Tạo kết nối socket server lắng nghe kết nối Client
        ServerSocket serverSocket = new ServerSocket(serverPost);
        System.out.println("Server is running...");
        //Chấp nhận kết nối từ Client
        Socket socket = serverSocket.accept();
        //Đọc dữ liệu từ Client
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        byte[] bytes = new byte[1024];
        int lengthBytes = inputStream.read(bytes);
        String ipAddress = new String(bytes, 0, lengthBytes);
        System.out.println("Địa chỉ IP được cho là: " + ipAddress);
        //Xử lí IP được nhập
        if (isValidIP(ipAddress)) {
            System.out.println("Địa chỉ IP hợp lệ.");
        } else {
            System.out.println("Địa chỉ IP không hợp lệ.");
        }

    }
    public static boolean isValidIP(String ip) {
        String[] arrayList = ip.split(".");
        if (arrayList.length != 4) return false;
        for (String value : arrayList) {
            int number = Integer.parseInt(value);
            if (number < 0 || number > 255) return false;
        }
        return true;
    }
}
