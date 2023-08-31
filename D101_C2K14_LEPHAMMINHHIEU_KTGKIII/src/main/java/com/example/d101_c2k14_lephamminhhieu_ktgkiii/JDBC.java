package com.example.d101_c2k14_lephamminhhieu_ktgkiii;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.*;
import java.time.Period;

public class JDBC {
    private String hostName = "localhost:3306";
    private String dbName = "mydb";
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
    public void showAllStudentFromDatabase(ObservableList<Student> listStudent) {
        String query = "select * from Student;";
        Connection connection = this.connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = String.valueOf(resultSet.getInt("stuID"));
                String name = resultSet.getString("stuName");
                String age = String.valueOf(resultSet.getInt("age"));
                String gender = String.valueOf(resultSet.getInt("gender"));
                String address = resultSet.getString("address");
                listStudent.add(new Student(id,name,age,gender,address));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showAllStudentFromDatabaseSimple() {
        String query = "select * from Student;";
        Connection connection = this.connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = String.valueOf(resultSet.getInt("stuID"));
                String name = resultSet.getString("stuName");
                String age = String.valueOf(resultSet.getInt("age"));
                String gender = String.valueOf(resultSet.getInt("gender"));
                String address = resultSet.getString("address");
                System.out.println(id + "-" + name + "-" + age + "-" + gender + "-" + address);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addStudentToDatabase(ObservableList<Student> listStudent, Student student) {
        String query = "insert into Student values (?,?,?,?,?);";
        Connection connection = this.connect();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getAge());
            statement.setString(4, student.getGender());
            statement.setString(5, student.getAddress());
            statement.executeUpdate();
            listStudent.add(student);
            connection.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("ERROR ID");
            alert.show();
        }
    }

    public void findStudentFromDatabase(String id) {
        String query = "select * from Student where stuID = ?;";
        Connection connection = this.connect();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("stuName");
                String age = String.valueOf(resultSet.getInt("age"));
                String gender = String.valueOf(resultSet.getInt("gender"));
                String address = resultSet.getString("address");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("ID: " + id + "\n"
                        + "Name: " + name + "\n"
                        + "Age: " + gender + "\n"
                        + "Gender: " + gender + "\n"
                        + "Address: " + address);
                alert.show();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
