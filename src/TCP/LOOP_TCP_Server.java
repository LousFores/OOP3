package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.constant.ClassDesc;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class LOOP_TCP_Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 8081;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server is running and waiting for connect");

        //Accept connect from Client
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        while (true) {
            //Read from Client
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytes = inputStream.read(buffer);
            String messageFromClient = new String(buffer, 0, bytes);
            System.out.println("Client: " + messageFromClient);

            if (messageFromClient.equals("exit")) break;

            //Send to Client
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Message to Client: ");
            String messageToClient = scanner.nextLine();
            outputStream.write(messageToClient.getBytes());
        }
    }
}
