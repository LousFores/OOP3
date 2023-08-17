package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class LOOP_UDP_Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 12355;
        DatagramSocket datagramSocket = new DatagramSocket();

        while (true) {
            System.out.println("Message to Server: ");
            Scanner scanner = new Scanner(System.in);
            String messageToServer = scanner.nextLine();
            byte[] sendData = messageToServer.getBytes();

            InetAddress serverAddress = InetAddress.getByName(serverIP);

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            datagramSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            datagramSocket.receive(receivePacket);
            String messageFromClient = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server: " + messageFromClient);
        }
    }
}
