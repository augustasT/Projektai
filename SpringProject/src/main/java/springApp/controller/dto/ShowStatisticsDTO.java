package springApp.controller.dto;

public class ShowStatisticsDTO {
	private Integer userId;
	private QuizElementDTO questions;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public QuizElementDTO getQuestions() {
		return questions;
	}
	public void setQuestions(QuizElementDTO questions) {
		this.questions = questions;
	}

	
	
}
