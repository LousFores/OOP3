package Bai_4_Networking;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class THUC_HANH_GuiNhanDuLieu_UseTCP_Client {
    public static void main(String[] args) throws IOException {

        //Khai báo địa chỉ IP của server và post của server
        String serverIP = "127.0.0.1";
        int serverPort = 8080;

        //Kết nối đến server
        Socket socket = new Socket(serverIP, serverPort);

        //Tiến hành gửi dữ liệu lên server
        OutputStream outputStream = socket.getOutputStream();
        String message = "Hello, server!";
        outputStream.write(message.getBytes());
        socket.close();
    }


}
