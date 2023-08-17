package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class THUCHANH_JDBC_Insert {
    public static void main(String[] args) {
        String hostName = "localhost:3306";
        String dbname = "quanlydiem";
        String userName = "root";
        String password = "1";
        String url = "jdbc:mysql://" + hostName + "/" + dbname;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connect success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String MaSV = "ph12344";
        String HoTen = "Louis Fores";
        String NgaySinh = "2003-10-11";
        String QueQuan = "Thanh Hoa";
        String GioiTinh = "Nam";
        String MaLop = "IT18301";

        String query = "INSERT INTO SINHVIEN VALUES (?,?,?,?,?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, MaSV);
            pstm.setString(2, HoTen);
            pstm.setString(3, NgaySinh);
            pstm.setString(4, QueQuan);
            pstm.setString(5, GioiTinh);
            pstm.setString(6, MaLop);

            int row = pstm.executeUpdate();
            if (row != 0) {
                System.out.println("Add success!");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
