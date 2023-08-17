package UDP;

import com.sun.nio.sctp.SendFailedNotification;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class THUCHANH_UDP_Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 12345;
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        System.out.println("Server is running and waiting for client...");

        //Receive from client
        byte[] receiveDate = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(receiveDate, receiveDate.length);
        serverSocket.receive(datagramPacket);

        //Convert data into String - Chuyển đổi dữ liệu
        String message = new String(datagramPacket.getData(),0, datagramPacket.getLength());
        System.out.println("Received from client: " + message);

        //IP and Port Client's
        InetAddress clientAddress = datagramPacket.getAddress();
        int clientPort = datagramPacket.getPort();

        //Chuẩn bị dữ liệu gửi đi
        String responseMessage = "Hello, client!";
        byte[] sendData = responseMessage.getBytes();

        //Create datapacket send Client
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

        //Send Client
        serverSocket.send(sendPacket);
    }
}
