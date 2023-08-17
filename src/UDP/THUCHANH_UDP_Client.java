package UDP;

import java.io.IOException;
import java.net.*;

public class THUCHANH_UDP_Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPost = 12345;
        DatagramSocket clientSocket = new DatagramSocket();

        //Create 1
        String message = "Hello, server!";
        byte[] sendData = message.getBytes();

        InetAddress serverAddress = InetAddress.getByName(serverIP);

        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, serverAddress, serverPost);
        clientSocket.send(sendPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String responMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Receive from server: " +  responMessage);
        clientSocket.close();
    }
}
