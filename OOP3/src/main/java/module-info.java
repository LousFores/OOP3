module com.example.oop3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.oop3 to javafx.fxml;
    exports com.example.oop3;
}