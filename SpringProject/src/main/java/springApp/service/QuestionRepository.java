package springApp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import springApp.domain.Questions;


public interface QuestionRepository  extends JpaRepository<Questions, Integer>{


}
