package com.example.d101_c2k14_lephamminhhieu_ktgkiii;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CAU2_Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader root = new FXMLLoader(CAU2_Main.class.getResource("manage_student.fxml"));
        Scene scene = new Scene(root.load(), 761, 525);
        stage.setScene(scene);
        stage.setTitle("Manage Student");
        stage.show();
    }
}
