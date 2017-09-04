package springApp.controller.dto;

import org.springframework.web.bind.annotation.ModelAttribute;

public class AnswersDTO {
    private Integer id;
    private String answer;

    public AnswersDTO() {
    	
    }
    
    public AnswersDTO(String answer) {
		super();
		this.answer = answer;
	}

	

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
