package com.example.oop3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class THUCHANH_TinhTuoi_Controller {
    @FXML
    private TextField inputField;
    @FXML
    private TextField outputField;
    @FXML
    private Button sendButton;
    @FXML
    protected void calculateAge() {
        int now = 2023;
        int age = now - Integer.parseInt(inputField.getText());
        outputField.setText(new String(String.valueOf(age)));
        inputField.clear();
    }

}
