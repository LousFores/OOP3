package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LOOP_TCP_Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 8081;

        Socket socket = new Socket(serverIP, serverPort);

        while (true) {
            //Send data to server
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Message to Server: ");
            String messageToServer = scanner.nextLine();
            outputStream.write(messageToServer.getBytes());

            if(messageToServer.equals("exit")) break;

            //Receive data from server
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String messageFromServer = new String(buffer, 0, bytesRead);
            System.out.println("Server: " + messageFromServer);
        }
    }
}
