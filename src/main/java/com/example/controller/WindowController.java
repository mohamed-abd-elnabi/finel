package com.example.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowController {


    public static void openTeacherWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(WindowController.class.getResource("DashboardTeacher.fxml"));
            Parent root = loader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void openAdminWindow() {

        try {
            FXMLLoader loader = new FXMLLoader(WindowController.class.getResource("DashboardAdmin.fxml"));
            Parent root = loader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void openStudentWindow() {

        try {
            FXMLLoader loader = new FXMLLoader(WindowController.class.getResource("DashboardStudant.fxml"));
            Parent root = loader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
