package com.example.classes;

public abstract class Questions {
    private int id;
    private String questionsText;
    private  int marks;
    public Questions(int id, String questionsText, int marks) {
        this.id = id;
        this.questionsText = questionsText;
        this.marks = marks;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionsText() {
        return questionsText;
    }

    public void setQuestionsText(String questionsText) {
        this.questionsText = questionsText;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }


}
