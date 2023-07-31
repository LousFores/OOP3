package Bai_4_Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class THUC_HANH_SuDungLopURLConnection {
    public static void main(String[] args) throws IOException {

        //Mở kết nối URL
        URL url = new URL("https://www.geeksforgeeks.org/javafx-filechooser-class/");
        URLConnection connection = url.openConnection();

        //Đọc dữ liệu từ URL
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        //Đọc kết nối theo từng dòng đến khi hết dữ liệu
        String line;
        while ((line = reader.readLine()) != null ) {
            System.out.println(line);
        }

        //Đóng kết nối
        reader.close();
    }
}
