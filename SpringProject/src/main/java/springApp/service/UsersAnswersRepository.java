package springApp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import springApp.domain.UsersAnswers;

public interface UsersAnswersRepository extends JpaRepository<UsersAnswers, Integer>{

}
