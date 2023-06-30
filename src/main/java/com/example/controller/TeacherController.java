package com.example.controller;

import com.example.classes.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class TeacherController implements Initializable {

    @FXML
    private TableView<Student> TabelviewStudant;

    @FXML
    private TableColumn<Student, String> gender;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> universityId;

    @FXML
    private TableColumn<Student, String> username;

    ////////////////////////////////////////////////////////////
    @FXML
    private TableView<Questions> table;
    @FXML
    private TableColumn<Questions, Integer> column1;
    @FXML
    private TableColumn<Questions, String> column2;
    @FXML
    private TableColumn<Questions, Integer> column3;


    @FXML
    private Button AddExamT_btn;

    @FXML
    private Button AddQuesT_btn;

    @FXML
    private RadioButton AnswerFalse;

    @FXML
    private RadioButton AnswerTrue;

    @FXML
    private ToggleGroup Answers;

    @FXML
    private Button EditQuestoin_btn;

    @FXML
    private Button ExportExam_btn;

    @FXML
    private TextField MarksFillBlank_Answer;

    @FXML
    private TextField MarksFillBlank_Filed;

    @FXML
    private TextField MarksMultipleChoiceTextFiled;

    @FXML
    private TextField MarksYesNo_TextFiled;

    @FXML
    private TextField MultipleChoice_Choice1_TextFiled;

    @FXML
    private TextField MultipleChoice_Choice2_TextFiled;

    @FXML
    private TextField MultipleChoice_Choice3_TextFiled;

    @FXML
    private TextField MultipleChoice_Choice4_TextFiled;

    @FXML
    private Button MultipleChoicebtn;

    @FXML
    private Pane PaneAddQuestion;

    @FXML
    private Pane PaneAddStudant;

    @FXML
    private Pane PaneFillBalenk;

    @FXML
    private Pane PaneHome;

    @FXML
    private Pane PaneMultipleChoice;

    @FXML
    private Pane PaneStudantExamResalt;

    @FXML
    private Pane PaneViewAllExam;

    @FXML
    private Pane PaneViewAllQuestion;

    @FXML
    private Pane PaneViewAllStudant;

    @FXML
    private Pane PaneYesNoquestion;

    @FXML
    private PasswordField PasswordTvStudant;

    @FXML
    private Button ProfileT_btn;

    @FXML
    private Pane PsswordTv1;
    @FXML
    private Pane PaneAddExam;
    @FXML
    private TextArea QuestionFillblank_TextFiled;

    @FXML
    private TextArea QuestionMultipleChoice_TextFiled;

    @FXML
    private TextArea QuestionYesNo_TextFiled;

    @FXML
    private RadioButton RadioBtnFmaleT;

    @FXML
    private RadioButton RadioBtnmaleT;

    @FXML
    private Button StudantExamResalt_btn;

    @FXML
    private TextField UidTvStudant;

    @FXML
    private TextField UserNameTvStudant;

    @FXML
    private Button ViewAllExam_btn;

    @FXML
    private Button ViewAllQuestion_btn;

    @FXML
    private Button YesNoquestionbtn;

    @FXML
    private Button addstuT_btn;

    @FXML
    private Button blankQuestionbtn;

    @FXML
    private Button cansel_btn_Studant;

    @FXML
    private TextField dateTvStudant;

    @FXML
    private ToggleGroup genderT;

    @FXML
    private Button homeT_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private TextField nameTvStudant;

    @FXML
    private Button save_btn_FillBlank;

    @FXML
    private Button save_btn_MultipleChoice;

    @FXML
    private Button save_btn_Studant;

    @FXML
    private Button save_btn_YesNoQuestion;

    @FXML
    private Button viewstuT_btn;

    @FXML
    public ComboBox combobox;

    @FXML
    void EditQuestoin(ActionEvent event) {
    }


    @FXML
    void ExportExam(ActionEvent event) {
    }

    @FXML
    void Logout(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void AddFillBlank(ActionEvent event) {
        String textQuestionFillBlank = QuestionFillblank_TextFiled.getText().toString();
        String marksFillBlank = MarksFillBlank_Filed.getText().toString();
        String answerFillBlank = MarksFillBlank_Answer.getText().toString();

        if (textQuestionFillBlank.isEmpty() || marksFillBlank.isEmpty() || answerFillBlank.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Please fill in all fields.");
            alert.show();
            return;
        }

        try {
            int marks = parseInt(marksFillBlank);
            if (marks < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Please enter a positive number for marks.");
                alert.show();
                return;
            }

            int id = Arrays.questions.size() + 1;
            FillBlankQuestion newFillBlankQuestion = new FillBlankQuestion(id, textQuestionFillBlank, marks, answerFillBlank);
            Arrays.questions.add(newFillBlankQuestion);
            System.out.println("Question added successfully!");
            MarksFillBlank_Answer.setText("");
            MarksFillBlank_Filed.setText("");
            QuestionFillblank_TextFiled.setText("");
            for (Questions question : Arrays.questions) {
                System.out.println("Question Text: " + question.getQuestionsText());
                System.out.println("Marks: " + question.getMarks());
                System.out.println("ID: " + question.getId());
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Please enter a valid number for marks.");
            alert.show();
        }


    }

    @FXML
    void AddYesNoQuestion(ActionEvent event) {
        String textQuestion = QuestionYesNo_TextFiled.getText().toString();
        String marksYesNo = MarksYesNo_TextFiled.getText().toString();
        boolean Answer = AnswerTrue.isSelected();

        if (textQuestion.isEmpty() || marksYesNo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Please fill in all fields.");
            alert.show();
            return;
        }
        try {
            int ss = parseInt(marksYesNo);
            if (ss < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Please enter a positive number for marks.");
                alert.show();
                return;
            }
            int id = Arrays.questions.size() + 1;
            String answer = Answer ? "True" : "False";
//            Arrays.yesNoQuestions.add(new YesNoQuestion(id, textQuestion, ss, answer))
            YesNoQuestion yesNoQuestion1 = new YesNoQuestion(id, textQuestion, ss, answer);
            Arrays.questions.add(yesNoQuestion1);


            System.out.println("Question added successfully!");
            QuestionYesNo_TextFiled.setText("");
            MarksYesNo_TextFiled.setText("");
            AnswerTrue.setText("");
            for (YesNoQuestion yesNoQuestion : Arrays.yesNoQuestions) {
                System.out.println("QuestionsText: " + yesNoQuestion.getQuestionsText());
                System.out.println("Answer: " + yesNoQuestion.getAnswer());
                System.out.println("Marks: " + yesNoQuestion.getMarks());
                System.out.println("ID: " + yesNoQuestion.getId());
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Please enter a valid number for marks.");
            alert.show();
        }


    }

    @FXML
    void AddChoiceQuestion(ActionEvent event) {
        String QuestionMultipleChoice = QuestionMultipleChoice_TextFiled.getText().toString();
        String Choice1 = MultipleChoice_Choice1_TextFiled.getText().toString();
        String Choice2 = MultipleChoice_Choice2_TextFiled.getText().toString();
        String Choice3 = MultipleChoice_Choice3_TextFiled.getText().toString();
        String Choice4 = MultipleChoice_Choice4_TextFiled.getText().toString();
        String MarksMultipleChoice = MarksMultipleChoiceTextFiled.getText();
        int id = Arrays.questions.size() + 1;
        String Answer = (String) combobox.getSelectionModel().getSelectedItem();


        if (QuestionMultipleChoice.isEmpty() || Choice1.isEmpty() || Choice2.isEmpty() || Choice3.isEmpty() || Choice4.isEmpty() || Answer == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Please fill in all fields.");
            alert.show();
            return;
        }

        try {
            int ss = parseInt(MarksMultipleChoice);
            if (ss < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Please enter a positive number for marks.");
                alert.show();
                return;
            }
//            Arrays.choiceQuestions.add(new ChoiceQuestion(id, QuestionMultipleChoice, ss, Choice1, Choice2, Choice3, Choice4, Answer));
            ChoiceQuestion choiceQuestion = new ChoiceQuestion(id, QuestionMultipleChoice, ss, Choice1, Choice2, Choice3, Choice4, Answer);
            Arrays.questions.add(choiceQuestion);


            QuestionMultipleChoice_TextFiled.setText("");
            MultipleChoice_Choice1_TextFiled.setText("");
            MultipleChoice_Choice2_TextFiled.setText("");
            MultipleChoice_Choice3_TextFiled.setText("");
            MultipleChoice_Choice4_TextFiled.setText("");
            MarksMultipleChoiceTextFiled.setText("");


            for (ChoiceQuestion choiceQuestions : Arrays.choiceQuestions) {
                System.out.println("QuestionsText: " + choiceQuestions.getQuestionsText());
                System.out.println("Answer: " + choiceQuestions.getAnswer());
                System.out.println("Marks: " + choiceQuestions.getMarks());
                System.out.println("Choice1: " + choiceQuestions.getChoice1());
                System.out.println("Choice2: " + choiceQuestions.getChoice2());
                System.out.println("Choice3: " + choiceQuestions.getChoice3());
                System.out.println("Choice4: " + choiceQuestions.getChoice4());
                System.out.println("ID: " + choiceQuestions.getId());
                System.out.println("Answer: " + choiceQuestions.getAnswer());
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Please enter a valid number for marks.");
            alert.show();
        }


    }

    @FXML
    void SplitMenuButton(ActionEvent event) {

    }

    @FXML
    void changePage(ActionEvent event) {

        if (homeT_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneHome.setVisible(true);

        } else if (addstuT_btn.isFocused()) {
            PaneAddStudant.setVisible(true);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneHome.setVisible(false);

        } else if (viewstuT_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(true);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneHome.setVisible(false);

        } else if (viewstuT_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(true);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneHome.setVisible(false);

        } else if (AddQuesT_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneAddQuestion.setVisible(true);
            PaneYesNoquestion.setVisible(false);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneHome.setVisible(false);

        } else if (ViewAllQuestion_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(true);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneHome.setVisible(false);


//            for (Questions question : Arrays.questions) {
//                System.out.println("QuestionsText: " + question.getQuestionsText());
//                System.out.println("Marks: " + question.getMarks());
//                System.out.println("ID: " + question.getId());
//
//            }


            System.out.println(Arrays.questions.size());
        } else if (ViewAllExam_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(true);
            PaneAddQuestion.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneHome.setVisible(false);

        } else if (StudantExamResalt_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(true);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneHome.setVisible(false);


        } else if (YesNoquestionbtn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneYesNoquestion.setVisible(true);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneHome.setVisible(false);

        } else if (MultipleChoicebtn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(true);
            PaneHome.setVisible(false);

        } else if (blankQuestionbtn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneFillBalenk.setVisible(true);
            PaneMultipleChoice.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneHome.setVisible(false);

        } else if (AddExamT_btn.isFocused()) {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneYesNoquestion.setVisible(false);
            PaneAddExam.setVisible(true);
            PaneFillBalenk.setVisible(false);
            PaneMultipleChoice.setVisible(false);
            PaneHome.setVisible(false);

        } else {
            PaneAddStudant.setVisible(false);
            PaneViewAllStudant.setVisible(false);
            PaneViewAllQuestion.setVisible(false);
            PaneStudantExamResalt.setVisible(false);
            PaneViewAllExam.setVisible(false);
            PaneAddQuestion.setVisible(false);
            PaneAddExam.setVisible(false);
            PaneHome.setVisible(true);
        }


    }

    @FXML
    void profileT(ActionEvent event) {
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
            if (RadioBtnmaleT.isSelected()) {
                gender = "Male";
            } else if (RadioBtnFmaleT.isSelected()) {
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


    @FXML
    void setOnEditCommit(ActionEvent event) {


    }


    @FXML
    void setOnEditStart(ActionEvent event) {


    }

    @FXML
    void setOnEditCancel(ActionEvent event) {


    }

    @FXML
    void mohammed(TableColumn.CellEditEvent<Questions, String> cellEditEvent) {
        Questions questionsSelected = cellEditEvent.getRowValue();
        questionsSelected.setQuestionsText(cellEditEvent.getNewValue());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setCellValueFactory(new PropertyValueFactory<Student, String>("username"));
        universityId.setCellValueFactory(new PropertyValueFactory<Student, String>("universityId"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        gender.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
        TabelviewStudant.setItems(Arrays.ListStudent);

//////////////////////////////////////////////////////////////////////////////////

        column1.setCellValueFactory(new PropertyValueFactory<Questions, Integer>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<Questions, String>("questionsText"));
        column3.setCellValueFactory(new PropertyValueFactory<Questions, Integer>("marks"));
        table.setItems(Arrays.questions);
        table.setEditable(true);

        column2.setCellFactory(TextFieldTableCell.forTableColumn());
//////////////////////////////////////////////////////////////////////////////////
        ObservableList<String> observableList = FXCollections.observableArrayList("Choice1", "Choice2", "Choice3", "Choice4");
        combobox.setItems(observableList);

    }
}
