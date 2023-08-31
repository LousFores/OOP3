package com.example.oop3;

import java.io.FileReader;
import java.lang.invoke.StringConcatFactory;
import java.nio.channels.ConnectionPendingException;
import java.sql.*;
import java.util.Scanner;

public class JDBC {
    private String hostName = "localhost:3306";
    private String dbName = "UserData";
    private String userName = "root";
    private String password = "1";
    private String url = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection connect() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }

    public void addUserToDatabase(People people) throws SQLException {
        Connection connection = this.connect();
        String query = "INSERT INTO People VALUES (?,?,?,?,?,?);";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, people.getiD());
            statement.setString(2, people.getFirstName());
            statement.setString(3, people.getLastName());
            statement.setString(4, people.getBirthday());
            statement.setString(5, people.getGmail());
            statement.setString(6, people.getAddress());

            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserFromDatabase(String ID) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("FirstName: ");
        String firstName = scanner.nextLine();
        System.out.println("LastName: ");
        String lastName = scanner.nextLine();
        System.out.println("Birthday: ");
        String birthday = scanner.nextLine();
        System.out.println("Gmail: ");
        String gmail = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();

        Connection connection = this.connect();
        String query = "UPDATE People \n" +
                       "SET FirstName = ?, LastName = ?, Birthday = ?, Gmail = ?, Address = ?\n" +
                       "WHERE ID = ?;";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, birthday);
            statement.setString(4, gmail);
            statement.setString(5, address);
            statement.setString(6, ID);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllUserFromDatabase() throws SQLException {
        Connection connection = this.connect();
        String query = "SELECT * FROM UserData.People;";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String birthday = resultSet.getString("Birthday");
                String gmail = resultSet.getString("Gmail");
                String address = resultSet.getString("Address");

                System.out.println("ID: " + id);
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Birthday: " + birthday);
                System.out.println("Gmail: " + gmail);
                System.out.println("Address: " + address);
                System.out.println("---------------------------------------");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showUserFromDatabase(String IP) throws SQLException {
        Connection connection = this.connect();
        String query = "SELECT * FROM UserData.People\n" +
                       "WHERE ID = ?;";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, IP);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) { //con tro trong resultset last, first,...
                String id = resultSet.getString("ID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String birthday = resultSet.getString("Birthday");
                String gmail = resultSet.getString("Gmail");
                String address = resultSet.getString("Address");

                System.out.println("ID: " + id);
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Birthday: " + birthday);
                System.out.println("Gmail: " + gmail);
                System.out.println("Address: " + address);
                System.out.println("---------------------------------------");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserFromDatabase(String ID) throws SQLException {
        Connection connection = this.connect();
        String query = "DELETE FROM UserData.People\n" +
                       "WHERE ID = ?;";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, ID);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
