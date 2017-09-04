package springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import springApp.domain.Answer;

@Component
public class AnswersService {
	AnswersRepository repository;

	@Autowired
	public AnswersService(AnswersRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public void saveAnswer(Answer answer) {
		repository.saveAndFlush(answer);
	}

}
