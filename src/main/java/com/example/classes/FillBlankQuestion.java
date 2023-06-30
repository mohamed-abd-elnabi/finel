package com.example.classes;

public class FillBlankQuestion extends Questions{
    private String Answer;
    public FillBlankQuestion(int id, String questionsText, int marks,String answer) {
        super(id, questionsText, marks);
        this.Answer=answer;
    }
    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
