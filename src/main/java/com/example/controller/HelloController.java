package com.example.controller;



import com.example.classes.Admin;
import com.example.classes.Student;
import com.example.classes.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.example.controller.WindowController.openAdminWindow;


public class HelloController {

    public static Student currentStudent;
    @FXML
    private Label Password;

    @FXML
    private PasswordField PasswordTvSignin;

    @FXML
    private TextField UserNameTvSignin;

    @FXML
    private Label UsernameError;

    @FXML
    private Button btn_Logn;
    @FXML
    private Label namePassowrderror;


    @FXML
    void Loginbtn(ActionEvent event) {
        if (btn_Logn.isFocused()) {
            String userName = UserNameTvSignin.getText().toString();
            String password = PasswordTvSignin.getText().toString();
            if (userName.isEmpty() && userName.isEmpty()) {
                UsernameError.setText("Please check your username");
                Password.setText("Please check your Password");
            } else if (userName.isEmpty()) {
                UsernameError.setText("Please check your username");
            } else if (password.isEmpty()) {
                Password.setText("Please check your Password");
            } else {
                boolean validation = true;
                Admin admin=new Admin();
                if (userName.equals(admin.getUsername())&&password.equals(admin.getPassword())){
                    openAdminWindow();
                    System.out.println("تممممممممم");
                    validation = false;
                }
                for (int i = 0; i < Arrays.ListStudent.size(); i++) {
                    Student student = Arrays.ListStudent.get(i);
                    if (student.getUsername().equals(userName) && student.getPassword().equals(password)) {
                        currentStudent = student;
                        WindowController.openStudentWindow();
                        System.out.println("تممممممممم");
                        validation = false;
                        break;
                    }
                }
                for (int j = 0; j < Arrays.ListTeacher.size(); j++) {
                    Teacher teacher = Arrays.ListTeacher.get(j);
                    if (teacher.getUsername().equals(userName) && teacher.getPassword().equals(password)) {
                        WindowController.openTeacherWindow();
                        System.out.println("تمممممممممم");
                        validation = false;
                        break;
                    }
                }
                if (validation) {
                    Alert alert=new Alert( Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Please check your Password and username !");
//                    alert.setContentText("\uD83D\uDC4B\uD83D\uDC4B");
//                    namePassowrderror.setText("Please check your Password and username");
                    alert.show();
                }
            }
        }
    }








}
