package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class THUCHANH_JDBC_Connect {
    public static void main(String[] args) {
        String  hostName = "localhost:3306";
        String dbName = "quanlydiem";
        String userName = "root";
        String password = "1";

        String url = "jdbc:mysql://" + hostName + "/" + dbName;
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connect success.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
