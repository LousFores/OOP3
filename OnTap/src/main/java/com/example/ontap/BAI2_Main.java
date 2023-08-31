package com.example.ontap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class BAI2_Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader root = new FXMLLoader(BAI2_Main.class.getResource("user-view.fxml"));
        Scene scene = new Scene(root.load(), 868,702);
        stage.setTitle("Manage User");
        stage.setScene(scene);
        stage.show();
    }
}
