package com.example.oop3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class THUCHANH_TinhTuoi_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader root = new FXMLLoader(THUCHANH_TinhTuoi_Main.class.getResource("age-view.fxml"));
        Scene scene = new Scene(root.load(), 600, 298);
        primaryStage.setScene(scene);
        primaryStage.setTitle("YEAR");
        primaryStage.show();
    }
}
