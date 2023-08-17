package JDBC;

import java.sql.*;

public class THUCHANH_JDBC_Select {
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

        String query = "SELECT * FROM KETQUA";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String MaSV = resultSet.getString("masv");
                String MaMH = resultSet.getString("mamh");
                int LanThi = resultSet.getInt("lanthi");
                double DiemThi = resultSet.getDouble("diemthi");
                System.out.println(MaSV + "-" + MaMH + "-" + LanThi + "-" + DiemThi);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
