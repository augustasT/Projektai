package springApp.controller.dto;

import springApp.domain.Answer;
import springApp.domain.AnswerType;
import springApp.domain.Questions;

import java.util.List;

public class QuizElementDTO {
    private int id;
    private String question;
    private AnswerType type;
    private List<Answer> answers;
    private int selection;

    public void setId(int id) {
        this.id = id;
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setType(AnswerType type) {
        this.type = type;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    public QuizElementDTO() {

    }
    public QuizElementDTO(Questions list, List<Answer> answers) {
        this.answers = answers;
        this.id = list.getId();

        this.question = list.getQuestion();
        this.type = list.getType();
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public AnswerType getType() {
        return type;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
