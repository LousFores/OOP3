module com.example.ontap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ontap to javafx.fxml;
    exports com.example.ontap;
}