package com.example.server;

import javafx.scene.control.TextArea;

import java.sql.*;

public class JDBC {
    private String hostName = "localhost:3306";
    private String dataName = "HistoryMessage1";
    private String userName = "root";
    private String password = "1";
    private String url = "jdbc:mysql://" + hostName + "/" + dataName;

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void addMessageToSQL(String name, String lineMess) {
        Connection connection = this.connect();
        String query = "INSERT INTO users (nameUser, line) VALUE (?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lineMess);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showHistoryMessageFromSQL(TextArea textArea) {
        Connection connection = this.connect();
        String query = "SELECT * FROM users";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("nameUser");
                String lineMess = resultSet.getString("line");
                textArea.appendText(name + ": " + lineMess + "\n");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
