package com.example.controller;

import com.example.classes.Questions;
import com.example.classes.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentController implements Initializable {


    @FXML
    private TextField AnswerTF;

    @FXML
    private Button Lastbtn;

    @FXML
    private Button NextBtn;

    @FXML
    private Label NumberQuestion;

    @FXML
    private Pane PaneEditProfile;

    @FXML
    private Pane PaneHome;

    @FXML
    private Pane PaneSolveExam;

    @FXML
    private Pane PaneViewExamResult;

    @FXML
    private TextField PasswordTvStudant;

    @FXML
    private Button ProfileS_btn;

    @FXML
    private Pane PsswordTv1;

    @FXML
    private Label QuestionNumber;

    @FXML
    private Button SolveExam_btn;

    @FXML
    private Label TextQuestionlb;

    @FXML
    private Button ViewExamResult_btn;

    @FXML
    private Button cansel_btn_Studant;

    @FXML
    private TextField dateTvStudant;

    @FXML
    private Button homeS_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private TextField nameTvStudant;

    @FXML
    private Button save_btn_Studant;
    int counter = 0;
    private int correctAnswersCount = 0;
    private ArrayList<String> studentAnswers = new ArrayList<>();

    @FXML
    void goToNext(ActionEvent event) {
        String currentAnswer = AnswerTF.getText();
        AnswerTF.setText("");
        studentAnswers.add(currentAnswer);

        if (counter < Arrays.questions.size()) {
            if (counter < Arrays.fillBlankQuestion.size() && !Arrays.fillBlankQuestion.isEmpty() && studentAnswers.get(counter).equalsIgnoreCase(Arrays.fillBlankQuestion.get(counter).getAnswer())) {
                System.out.println("صح");
                correctAnswersCount++;
            } else if (counter < Arrays.choiceQuestions.size() && !Arrays.choiceQuestions.isEmpty() && studentAnswers.get(counter).equalsIgnoreCase(Arrays.choiceQuestions.get(counter).getAnswer())) {
                System.out.println("صح");
                correctAnswersCount++;
            } else if (counter < Arrays.yesNoQuestions.size() && !Arrays.yesNoQuestions.isEmpty() && studentAnswers.get(counter).equalsIgnoreCase(Arrays.yesNoQuestions.get(counter).getAnswer())) {
                System.out.println("صح");
                correctAnswersCount++;
            } else {
                System.out.println("غلط");
            }

            counter++;
            if (counter < Arrays.questions.size()) {
                QuestionNumber.setText((counter + 1) + "/" + Arrays.questions.size());
                TextQuestionlb.setText(Arrays.questions.get(counter).getQuestionsText());
            }
        }

        System.out.println("عدد الإجابات الصحيحة: " + correctAnswersCount);
    }

    @FXML
    void goToPrevious(ActionEvent event) {
        if (counter > 0) {
            counter--;
            QuestionNumber.setText(counter + 1 + "/" + Arrays.questions.size());
            TextQuestionlb.setText(Arrays.questions.get(counter).getQuestionsText());
            }
        }

    @FXML
    void showResults(ActionEvent event) {
        System.out.println("عدد الإجابات الصحيحة: " + correctAnswersCount);
    }


    @FXML
    void EditProfilebtn(ActionEvent event) {
        String newpassword = PasswordTvStudant.getText().toString();
        String newname = nameTvStudant.getText().toString();
        String newbirthdate = dateTvStudant.getText().toString();

        HelloController.currentStudent.setPassword(newpassword);
        HelloController.currentStudent.setName(newname);
        HelloController.currentStudent.setBirthdate(newbirthdate);

        System.out.println("Username    " + HelloController.currentStudent.getUsername());
        System.out.println("Password    " + HelloController.currentStudent.getPassword());
        System.out.println("Name   " + HelloController.currentStudent.getName());
        System.out.println("Date of Birth " + HelloController.currentStudent.getBirthdate());


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Profile Update");
        alert.setHeaderText("Profile Updated Successfully");
        alert.setContentText("Your profile has been updated.");
        alert.show();

        PasswordTvStudant.setText("");
        nameTvStudant.setText("");
        dateTvStudant.setText("");


    }

    @FXML
    void Logout(ActionEvent event) {

    }

    @FXML
    void changePage(ActionEvent event) {

        if (homeS_btn.isFocused()) {
            PaneViewExamResult.setVisible(false);
            PaneEditProfile.setVisible(false);
            PaneSolveExam.setVisible(false);
            PaneHome.setVisible(true);

        } else if (SolveExam_btn.isFocused()) {
            PaneViewExamResult.setVisible(false);
            PaneEditProfile.setVisible(false);
            PaneSolveExam.setVisible(true);
            PaneHome.setVisible(false);
        } else if (ProfileS_btn.isFocused()) {
            PaneViewExamResult.setVisible(false);
            PaneEditProfile.setVisible(true);
            PaneSolveExam.setVisible(false);
            PaneHome.setVisible(false);
        } else if (ViewExamResult_btn.isFocused()) {
            PaneViewExamResult.setVisible(true);
            PaneEditProfile.setVisible(false);
            PaneSolveExam.setVisible(false);
            PaneHome.setVisible(false);
        } else {
            PaneViewExamResult.setVisible(false);
            PaneEditProfile.setVisible(false);
            PaneSolveExam.setVisible(false);
            PaneHome.setVisible(true);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        QuestionNumber.setText(counter + 1 + "/" + Arrays.questions.size());
//        TextQuestionlb.setText(Arrays.questions.get(counter).getQuestionsText());

        Student student = HelloController.currentStudent;
        PasswordTvStudant.setText(student.getPassword());
        nameTvStudant.setText(student.getName());
        dateTvStudant.setText(student.getBirthdate());

        System.out.println(Arrays.questions.size());

    }

}
