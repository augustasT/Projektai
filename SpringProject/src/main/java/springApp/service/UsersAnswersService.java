package springApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import springApp.controller.dto.UsersAnswersDTO;
import springApp.domain.UsersAnswers;

@Component
public class UsersAnswersService {
	UsersAnswersRepository repository;

	@Autowired
	public UsersAnswersService(UsersAnswersRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public List<UsersAnswers> getAllUsersAnswers() {
		return repository.findAll();
	}

	@Transactional
	public void saveUsersAnswers(UsersAnswersDTO usersAnswersDTO) {
		
		UsersAnswers usersAnswers = new UsersAnswers();
		usersAnswers.setAnswer(usersAnswersDTO.getAnswer());
		usersAnswers.setQuestionId(usersAnswersDTO.getQuestionId());
		usersAnswers.setUserId(usersAnswersDTO.getUserId());
		repository.saveAndFlush(usersAnswers);
	}

}
