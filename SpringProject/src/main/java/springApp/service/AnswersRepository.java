package springApp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import springApp.domain.Answer;

public interface AnswersRepository extends JpaRepository<Answer, Integer>{
}
