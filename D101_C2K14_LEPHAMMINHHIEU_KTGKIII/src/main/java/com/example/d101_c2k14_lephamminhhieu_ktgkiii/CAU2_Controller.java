package com.example.d101_c2k14_lephamminhhieu_ktgkiii;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CAU2_Controller implements Initializable {
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> ageColumn;
    @FXML
    private TableColumn<Student, String> genderColumn;
    @FXML
    private TableColumn<Student, String> addressColumn;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField addressField;
    private JDBC connectJDBC = new JDBC();
    @FXML
    private ObservableList<Student> listStudent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listStudent = FXCollections.observableArrayList();
        connectJDBC.showAllStudentFromDatabase(listStudent);
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("age"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
        tableView.setItems(listStudent);
    }

    @FXML
    protected void addStudentToTableView() {
        Student newStudent = new Student(
                idField.getText(),
                nameField.getText(),
                ageField.getText(),
                genderField.getText(),
                addressField.getText()
        );
        connectJDBC.addStudentToDatabase(listStudent,newStudent);
        clearField();
    }

    @FXML
    protected void findStudentFromTableView() {
        String idStudent = idField.getText();
        connectJDBC.findStudentFromDatabase(idStudent);
        clearField();
    }
    public void clearField() {
        idField.clear();
        nameField.clear();
        ageField.clear();
        genderField.clear();
        addressField.clear();
    }
}
