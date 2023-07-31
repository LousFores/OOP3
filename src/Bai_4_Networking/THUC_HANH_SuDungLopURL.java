package Bai_4_Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class THUC_HANH_SuDungLopURL {
    public static void main(String[] args) throws IOException {

        //Tạo đối tượng URL với địa chỉ web bất kì
        URL url = new URL("https://www.youtube.com/watch?v=3xKnHdcrl_I");
        BufferedReader brd = new BufferedReader(new InputStreamReader(url.openStream()));

        //Đọc dữ liệu bằng cách đọc từng dòng trên trang web đến hết
        String line;
        while ((line = brd.readLine()) != null) {
            System.out.println(line);
        }
        //Đóng kết nối
        brd.close();
    }
}
