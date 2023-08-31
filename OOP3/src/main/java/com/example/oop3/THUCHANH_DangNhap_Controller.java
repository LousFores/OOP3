package com.example.oop3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class THUCHANH_DangNhap_Controller {
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    protected void login() {
        String username = textField.getText();
        String password = passwordField.getText();
        if ( (username.equals("admin")) && (password.equals("11112222")) ) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Login success");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("ERROR");
            alert.show();
        }
    }

}
