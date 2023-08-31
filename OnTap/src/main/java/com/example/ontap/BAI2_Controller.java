package com.example.ontap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BAI2_Controller implements Initializable {
    @FXML
    private TableView<People> tableView;
    @FXML
    private TableColumn<People, String> idColumn;
    @FXML
    private TableColumn<People, String> nameUserColumn;
    @FXML
    private TableColumn<People, String> ageColumn;
    @FXML
    private TableColumn<People, String> gmailColumn;
    @FXML
    private TableColumn<People, String> addressColumn;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameUserField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField gmailField;
    @FXML
    private TextField addressField;
    @FXML
    private ObservableList<People> listPeople;
    @FXML
    private JDBC connectJDBC = new JDBC();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listPeople = FXCollections.observableArrayList();
        connectJDBC.showAllUseFromDatabase(listPeople);
        idColumn.setCellValueFactory(new PropertyValueFactory<People, String>("id"));
        nameUserColumn.setCellValueFactory(new PropertyValueFactory<People, String>("nameUser"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<People, String>("age"));
        gmailColumn.setCellValueFactory(new PropertyValueFactory<People, String>("gmail"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<People, String>("address"));
        tableView.setItems(listPeople);
    }
    @FXML
    protected void addUserToTableView() {
        People newPeople = putOutTextField();
        connectJDBC.addUseToDatabase(listPeople, newPeople);
        clearTextField();
    }
    @FXML
    protected void deleteUseFromTableView() {
        People choicePeople = tableView.getSelectionModel().getSelectedItem();
        connectJDBC.deleteUserFromDatabase(listPeople, choicePeople);
        clearTextField();
    }
    @FXML
    protected void updateUserFromTableView() {
        People updatePeople = putOutTextField();
        connectJDBC.UpdateUserFromDatabase(tableView, listPeople, updatePeople);
        clearTextField();
    }
    @FXML
    protected void closeTableView(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
    public People putOutTextField() {
        People newPeople = new People(
                idField.getText(),
                nameUserField.getText(),
                ageField.getText(),
                gmailField.getText(),
                addressField.getText()
        );
        return newPeople;
    }

    public void clearTextField() {
        idField.clear();
        nameUserField.clear();
        ageField.clear();
        gmailField.clear();
        addressField.clear();
    }
}
