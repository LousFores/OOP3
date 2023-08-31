package com.example.ontap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

import java.sql.*;
public class JDBC {
    private String hostName = "localhost:3306";
    private String dbName = "ManageUser";
    private String userName = "root";
    private String password = "1";
    private String url = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void addUseToDatabase(ObservableList<People> listPeople, People people) {
        String query = "INSERT INTO Users (id, nameUser, age, gmail, address) VALUES (?, ?, ?, ?, ?);";
        Connection connection = this.connect();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, people.getId());
            statement.setString(2, people.getNameUser());
            statement.setString(3, people.getAge());
            statement.setString(4, people.getGmail());
            statement.setString(5, people.getAddress());
            statement.executeUpdate();
            listPeople.add(people);
            connection.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Duplicate ID");
            alert.show();
        }
    }

    public void showUseFromDatabase(String ID) {
        String query = "SELECT * FROM Users WHERE id = ?;";
        Connection connection = this.connect();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, ID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String NameUser = resultSet.getString("nameUser");
                String Age = resultSet.getString("age");
                String Gmail = resultSet.getString("gmail");
                String Address = resultSet.getString("address");
                System.out.println("Name: " +  NameUser + "\n" + "Age: " + Age + "\n" + "Gmail: " + Gmail + "\n" + "Address: " + Address);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllUseFromDatabase(ObservableList<People> listPeople) {
        String query = "SELECT * FROM Users;";
        Connection connection = this.connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String ID = resultSet.getString("id");
                String NameUser = resultSet.getString("nameUser");
                String Age = resultSet.getString("age");
                String Gmail = resultSet.getString("gmail");
                String Address = resultSet.getString("address");
                People newPeople = new People(ID, NameUser, Age, Gmail, Address);
                listPeople.add(newPeople);
                System.out.println("ID: " + ID + "\n" + "Name: " + NameUser + "\n" + "Age: " + Age + "\n" + "Gmail: " + Gmail + "\n" + "Address: " + Address);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserFromDatabase(TableView<People> tableView, ObservableList<People> listPeople, People updatePeple) {
        String query = "UPDATE Users SET nameUser = ?, age = ?, gmail = ?, address = ? WHERE id = ?;";
        PreparedStatement statement = null;
        Connection connection = this.connect();

        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, updatePeple.getNameUser());
            statement.setString(2, updatePeple.getAge());
            statement.setString(3, updatePeple.getGmail());
            statement.setString(4, updatePeple.getAddress());
            statement.setString(5, updatePeple.getId());
            statement.executeUpdate();

            for (People people : listPeople) {
                if ( updatePeple.getId() == people.getId()) {
                    listPeople.set(listPeople.indexOf(people), updatePeple);
                    break;
                }
            }
            ObservableList<People> newListPeople = FXCollections.observableArrayList();
            listPeople.clear();
            tableView.setItems(newListPeople);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserFromDatabase(ObservableList<People> listPeople, People people) {
        String query = "DELETE FROM Users WHERE id = ?;";
        Connection connection = this.connect();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, people.getId());
            statement.executeUpdate();
            listPeople.remove(people);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
