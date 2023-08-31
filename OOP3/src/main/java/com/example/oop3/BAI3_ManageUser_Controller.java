package com.example.oop3;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.stream.events.StartElement;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BAI3_ManageUser_Controller implements Initializable {
    @FXML
    private TableView<People> tableView;
    @FXML
    private TableColumn<People, String> idColumn;
    @FXML
    private TableColumn<People, String> firstNameColum;
    @FXML
    private TableColumn<People, String> lastNameColumn;
    @FXML
    private TableColumn<People, String > birthdayColumn;
    @FXML
    private TableColumn<People, String>  gmailColumn;
    @FXML
    private TableColumn<People, String> addressColumn;
    @FXML
    private ObservableList<People> peopleList;
    @FXML
    private TextField idText;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField birthdayText;
    @FXML
    private TextField gmailText;
    @FXML
    private TextField addressText;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        peopleList = FXCollections.observableArrayList();

        idColumn.setCellValueFactory(new PropertyValueFactory<People, String>("iD"));
        firstNameColum.setCellValueFactory(new PropertyValueFactory<People, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<People, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<People, String>("birthday"));
        gmailColumn.setCellValueFactory(new PropertyValueFactory<People, String>("gmail"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<People, String>("address"));

        tableView.setItems(peopleList);
    }

    @FXML
    protected void add() {
        People newPeople = new People();
        newPeople.setiD(idText.getText());
        newPeople.setFirstName(firstNameText.getText());
        newPeople.setLastName(lastNameText.getText());
        newPeople.setBirthday(birthdayText.getText());
        newPeople.setGmail(gmailText.getText());
        newPeople.setAddress(addressText.getText());
        peopleList.add(newPeople);
    }

    @FXML
    protected void delete() {
        People choicePeople = tableView.getSelectionModel().getSelectedItem();
        peopleList.remove(choicePeople);
    }
}
