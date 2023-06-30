package com.example.classes;

public class YesNoQuestion extends Questions {
    private String answer;
    public YesNoQuestion(int id, String questionsText, int marks, String answer) {
        super(id, questionsText, marks);
        this.answer=answer;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
