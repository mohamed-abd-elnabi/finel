package com.example.controller;

import com.example.classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Arrays {
//    public  static ArrayList<Student> students=new ArrayList<>();
//    public static void AddStudent(){
//        students.add(new Student("s1","123456","moha","12002209925","14/2/2004","male"));
//    }
//    public  static ArrayList<Teacher> Teachers=new ArrayList<>();
//    public static void AddTeacher(){
//        Teachers.add(new Teacher("mohann","dds","nale","it"));
//    }

////////////////////////////////////////////////////////////////////////////


    static ObservableList<Student> ListStudent = FXCollections.observableArrayList(
            new Student("s1", "123456", "moha", "12002209925", "14/2/2004", "male")
    );

    static ObservableList<Teacher> ListTeacher = FXCollections.observableArrayList(
            new Teacher("1", "1", "mohammed", "14/2/2004", "male", "1200", "It")
    );






    static ObservableList<Questions> questions = FXCollections.observableArrayList();

//        public static ArrayList<Questions> questions = new ArrayList<>();
//    public static void AddQuestions() {
//        new Questions(1, "czzzdxzccc", 50);
//        new Questions(2, "sd", 50);
//        new Questions(3, "zxc", 50);
//        new Questions(4, "xc", 50);
//        new Questions(1, "xc", 50);
//
//    }



    public static ArrayList<YesNoQuestion> yesNoQuestions = new ArrayList<>();

    public static void yesNoQuestion() {
        yesNoQuestions.add(new YesNoQuestion(1, "cxc", 50, "ssss"));
    }


    public static ArrayList<FillBlankQuestion> fillBlankQuestion = new ArrayList<>();

    public static void fillBlankQuestions() {
        fillBlankQuestion.add(new FillBlankQuestion(1, "xcxc", 50, "ssss"));
    }


    public static ArrayList<ChoiceQuestion> choiceQuestions = new ArrayList<>();

    public static void choiceQuestions() {
        choiceQuestions.add(new ChoiceQuestion(1, "DDDDDDDD", 50, "ssss", "ss", "dd", "dd", "ddddd"));
    }


    static ArrayList<String> Choices = new ArrayList<>();


}
