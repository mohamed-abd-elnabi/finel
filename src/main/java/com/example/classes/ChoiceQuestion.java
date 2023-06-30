package com.example.classes;

public class ChoiceQuestion extends Questions{
private String Choice1;
private String Choice2;
private String Choice3;
private String Choice4;
private String Answer;

    public ChoiceQuestion(int id, String questionsText, int marks, String choice1, String choice2, String choice3, String choice4, String answer) {
        super(id, questionsText, marks);
        Choice1 = choice1;
        Choice2 = choice2;
        Choice3 = choice3;
        Choice4 = choice4;
        Answer = answer;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getChoice1() {
        return Choice1;
    }

    public void setChoice1(String choice1) {
        Choice1 = choice1;
    }

    public String getChoice2() {
        return Choice2;
    }

    public void setChoice2(String choice2) {
        Choice2 = choice2;
    }

    public String getChoice3() {
        return Choice3;
    }

    public void setChoice3(String choice3) {
        Choice3 = choice3;
    }

    public String getChoice4() {
        return Choice4;
    }

    public void setChoice4(String choice4) {
        Choice4 = choice4;
    }


    @Override
    public String toString() {
        return "/nChoiceQuestion{" +
                "Choice1='" + Choice1 + '\'' +
                ", Choice2='" + Choice2 + '\'' +
                ", Choice3='" + Choice3 + '\'' +
                ", Choice4='" + Choice4 + '\'' +
                ", Answer='" + Answer + '\'' +
                '}';
    }



}
