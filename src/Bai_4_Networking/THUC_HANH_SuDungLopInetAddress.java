package Bai_4_Networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class THUC_HANH_SuDungLopInetAddress {
    public static void main(String[] args) {
        try {
            //Lấy đối tượng InetAddress từ địa chỉ IP
            InetAddress address = InetAddress.getByName("www.example.com");

            //Lấy địa chỉ IP dạng chuỗi
            String ipAddress = address.getHostAddress();
            System.out.println("IP Address: " + ipAddress);

            //Lấy tên máy chủ từ địa chỉ IP
            String hostName = address.getHostName();
            System.out.println("Host Name: " + hostName);

            //Kiểm tra sự kết nối với địa chỉ IP
            boolean reachable= address.isReachable(5000);
            System.out.println("Reachable: " + reachable);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
