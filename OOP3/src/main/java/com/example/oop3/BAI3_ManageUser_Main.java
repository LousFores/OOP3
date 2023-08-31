package com.example.oop3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class BAI3_ManageUser_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader root = new FXMLLoader(BAI3_ManageUser_Main.class.getResource("manageUser-view.fxml"));
        Scene scene = new Scene(root.load(), 888, 642);
        primaryStage.setTitle("Table");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
