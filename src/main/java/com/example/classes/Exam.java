package com.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Exam {

        private int numberOfQuestions;
        private double minPassAverage;
        private List<Questions> questions;

        public Exam(int numberOfQuestions, double minPassAverage) {
            this.numberOfQuestions = numberOfQuestions;
            this.minPassAverage = minPassAverage;
            this.questions = new ArrayList<>();
        }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public double getMinPassAverage() {
        return minPassAverage;
    }

    public void setMinPassAverage(double minPassAverage) {
        this.minPassAverage = minPassAverage;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
}
