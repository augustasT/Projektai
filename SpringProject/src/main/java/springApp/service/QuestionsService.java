package springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springApp.domain.Answer;
import springApp.domain.Questions;

@Component
public class QuestionsService {
    private QuestionRepository questionRepository;
    private AnswersRepository answersRepository;

    @Autowired
    public QuestionsService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional(readOnly = true)
    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Transactional
    public void saveQuestion(Questions question){
        questionRepository.saveAndFlush(question);
    }

   @Transactional
    public void deleteQuestion(Integer id){
        questionRepository.delete(id);

   }
   @Transactional
    public void deleteAnswer(List<Answer> answers){
        for(Answer answer: answers){
            answersRepository.delete(answer.getId());
        }
   }

}

