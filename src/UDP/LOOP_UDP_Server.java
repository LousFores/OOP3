package UDP;

import java.io.IOException;
import java.lang.constant.ClassDesc;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.jar.Attributes;

public class LOOP_UDP_Server {
    public static void main(String[] args) throws IOException {
        int serverPost = 12355;
        DatagramSocket datagramSocket = new DatagramSocket(serverPost);
        System.out.println("Server is running...");

        while (true) {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            datagramSocket.receive(receivePacket);
            String messageFromClient = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Message from client: " + messageFromClient);

            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Message to client: " );
            String messageToClient = scanner.nextLine();
            byte[] sendData = messageToClient.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            datagramSocket.send(sendPacket);
        }
    }
}
