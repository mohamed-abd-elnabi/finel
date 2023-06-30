module com.example.finel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.controller to javafx.fxml;
    exports com.example.controller;
    opens com.example.classes to javafx.base;

                }