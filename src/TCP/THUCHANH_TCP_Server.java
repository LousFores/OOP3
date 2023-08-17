package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerError;

public class THUCHANH_TCP_Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server is running and waiting for connections...");

        //Accept connect from client
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        //Read data from Client
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[10224];
        int bytesRead = inputStream.read(buffer);
        String message = new String(buffer, 0, bytesRead);
        System.out.println("Received message from client: " + message);

        //Close Client
        socket.close();
        serverSocket.close();
    }
}
