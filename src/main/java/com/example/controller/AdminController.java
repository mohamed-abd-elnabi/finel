package com.example.controller;


import com.example.classes.Admin;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import com.example.classes.Teacher;
import com.example.classes.Student;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminController implements Initializable {


    public RadioButton RadioBtnFmale;
    public RadioButton RadioBtnmale;


    public RadioButton RadioBtnFmaleT;
    public RadioButton RadioBtnmaleT;
    @FXML
    private TableView<Teacher> TabelViewTeacher;

    @FXML
    private TableColumn<Teacher, String> nameTC;

    @FXML
    private TableColumn<Teacher, String> fieldTC;

    @FXML
    private TableColumn<Teacher, String> genderTC;

    @FXML
    private TableColumn<Teacher, String> usernameTC;


    @FXML
    private Label NumberOfTeachertext;

    @FXML
    private Label Numberofstudenttext;


    @FXML
    private Button Cansel_btn_Teacher;

    @FXML
    private Pane PaneAddStudant;

    @FXML
    private Pane PaneAddTeacher;

    @FXML
    private Pane PaneHome;

    @FXML
    private Pane PaneViewAllStudant;

    @FXML
    private Pane PaneViewAllTeacher;

    @FXML
    private PasswordField PasswordTvStudant;

    @FXML
    private PasswordField PasswordYvTeacher;

    @FXML
    private Pane PsswordTv;

    @FXML
    private Pane PsswordTv1;
    @FXML
    private TableView<Student> TabelviewStudant;

    @FXML
    private TextField UidTvStudant;

    @FXML
    private TextField UserNameTvStudant;

    @FXML
    private TextField UserNameTvTeacher;

    @FXML
    private Button addstu_btn;

    @FXML
    private Button addtea_btn;

    @FXML
    private AnchorPane admindash;

    @FXML
    private Button cansel_btn_Studant;

    @FXML
    private TextField dateTvStudant;

    @FXML
    private TextField dateTvTeacher;

    @FXML
    private TableColumn<Student, String> gender;

    @FXML
    private Button home_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TextField nameTvStudant;

    @FXML
    private TextField nameTvTeacher;

    @FXML
    private TextField salaryTvTeacher;

    @FXML
    private Button save_btn_Studant;

    @FXML
    private Button save_btn_Teacher;

    @FXML
    private TextField specialtyTv;

    @FXML
    private TableColumn<Student, String> universityId;

    @FXML
    private TableColumn<Student, String> username;

    @FXML
    private Button viewstu_btn;

    @FXML
    private Button viewtea_btn;

    @FXML
    void Logout(ActionEvent event) {

        Platform.exit();
    }

    @FXML
    void changePage(ActionEvent event) {
        if (home_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneAddTeacher.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllTeacher.setVisible(false);
            PaneHome.setVisible(true);
            Numberofstudenttext.setText(String.valueOf(Arrays.ListStudent.size()));
            NumberOfTeachertext.setText(String.valueOf(Arrays.ListTeacher.size()));
        } else if (addstu_btn.isFocused()) {
            PaneAddStudant.setVisible(true);
            PaneAddTeacher.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllTeacher.setVisible(false);
            PaneHome.setVisible(false);

        } else if (addtea_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneAddTeacher.setVisible(true);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllTeacher.setVisible(false);
            PaneHome.setVisible(false);

        } else if (viewstu_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneAddTeacher.setVisible(false);
            PaneViewAllStudant.setVisible(true);
            PaneViewAllTeacher.setVisible(false);
            PaneHome.setVisible(false);

        } else if (viewtea_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneAddTeacher.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllTeacher.setVisible(true);
            PaneHome.setVisible(false);

        } else {
            PaneAddStudant.setVisible(false);
            PaneAddTeacher.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllTeacher.setVisible(false);
            PaneHome.setVisible(true);
        }

    }

    @FXML
    public void AddTeacher(ActionEvent event) {
        String username = UserNameTvTeacher.getText().toString();
        String password = PasswordYvTeacher.getText().toString();
        String name = nameTvTeacher.getText().toString();
        String date = dateTvTeacher.getText().toString();
        String salary = salaryTvTeacher.getText().toString();
        String specialty = specialtyTv.getText().toString();
//      String gender = RadioBtnFmale.isSelected() ? "Female" : "Male";
        String gender = null;
        if (RadioBtnmaleT.isSelected()) {
            gender = "Male";
        } else if (RadioBtnFmaleT.isSelected()) {
            gender = "FMale";
        } else {

        }

        if (username.isEmpty() || password.isEmpty() || name.isEmpty() || date.isEmpty() || salary.isEmpty() || specialty.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Please check the information  !");
            alert.show();
            System.out.println("عبي الفراغات");
            return;
        }

        Arrays.ListTeacher.add(new Teacher(username, password, name, date, gender, salary, specialty));
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setHeaderText("        ⚫Add successfully");
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(okButton);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == okButton) {
            alert.close();
        }
        System.out.println("تم يمدير");

        UserNameTvTeacher.setText("");
        PasswordYvTeacher.setText("");
        nameTvTeacher.setText("");
        dateTvTeacher.setText("");
        salaryTvTeacher.setText("");
        specialtyTv.setText("");

        for (Teacher teacher : Arrays.ListTeacher) {
            System.out.println("Username    " + teacher.getUsername());
            System.out.println("Password    " + teacher.getPassword());
            System.out.println("Name   " + teacher.getName());
            System.out.println("Date of Birth " + teacher.getBirthdate());
            System.out.println("Gender        " + teacher.getGender());
            System.out.println("Salary         " + teacher.getSalary());
            System.out.println("Specialty       " + teacher.getSpecialty());
        }
    }

    @FXML
    private void AddStudent(ActionEvent event) {
        if (save_btn_Studant.isFocused()) {
            String username = UserNameTvStudant.getText().toString();
            String password = PasswordTvStudant.getText().toString();
            String name = nameTvStudant.getText().toString();
            String universityId = UidTvStudant.getText().toString();
            String dateTvStudantt = dateTvStudant.getText().toString();
//            String gendedr = RadioBtnFmale.isSelected() ? "Female" : "Male";
            String gender = null;
            if (RadioBtnmale.isSelected()) {
                gender = "Male";
            } else if (RadioBtnFmale.isSelected()) {
                gender = "FMale";
            }

            if (username.isEmpty() || password.isEmpty() || name.isEmpty() || universityId.isEmpty() || dateTvStudantt.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Please check the information  !");
                alert.show();
                System.out.println("عبي الفراغات");
                return;
            }


            Arrays.ListStudent.add(new Student(username, password, name, universityId, dateTvStudantt, gender));
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setHeaderText("        ⚫Add successfully");
            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(okButton);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == okButton) {
                alert.close();
            }


            UserNameTvStudant.setText("");
            PasswordTvStudant.setText("");
            nameTvStudant.setText("");
            UidTvStudant.setText("");
            dateTvStudant.setText("");


            for (Student student : Arrays.ListStudent) {
                System.out.println("Username    " + student.getUsername());
                System.out.println("Password    " + student.getPassword());
                System.out.println("Name   " + student.getName());
                System.out.println("Date of Birth " + student.getBirthdate());
                System.out.println("Gender        " + student.getGender());

            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setCellValueFactory(new PropertyValueFactory<Student, String>("username"));
        universityId.setCellValueFactory(new PropertyValueFactory<Student, String>("universityId"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        gender.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
        TabelviewStudant.setItems(Arrays.ListStudent);


//        ObservableList observableList = FXCollections.observableList(Arrays.studants);
//        TabelviewStudant.setItems(observableList);


        nameTC.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        usernameTC.setCellValueFactory(new PropertyValueFactory<Teacher, String>("username"));
        genderTC.setCellValueFactory(new PropertyValueFactory<Teacher, String>("gender"));
        fieldTC.setCellValueFactory(new PropertyValueFactory<Teacher, String>("specialty"));
        TabelViewTeacher.setItems(Arrays.ListTeacher);


//        ObservableList observableListT = FXCollections.observableList(Arrays.Teacher);
//        TabelviewStudant.setItems(observableListT);


    }

}

