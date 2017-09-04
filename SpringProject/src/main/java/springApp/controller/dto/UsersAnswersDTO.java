package springApp.controller.dto;

import java.util.HashMap;
import java.util.Map;

public class UsersAnswersDTO {

	private Integer userId;
	private String answer;
	private Integer questionId;



	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

}
