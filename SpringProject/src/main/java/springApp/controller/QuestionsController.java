/*
package springApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springApp.controller.dto.QuizElementDTO;
import springApp.domain.Answer;
import springApp.domain.AnswerType;
import springApp.domain.Questions;
import springApp.service.QuestionsService;

import java.util.ArrayList;
import java.util.List;

@RestController

@ResponseStatus(HttpStatus.OK)
public class QuestionsController {
    QuestionsService questionsService;
    List<QuizElementDTO> questionList = new ArrayList<QuizElementDTO>();

    @Autowired
    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }


    public List<Questions> getAllQuestions() {

        return questionsService.getAllQuestions();
    }

    @GetMapping(value = "/question")
    public String getQuestion(int id){

        return questionList.get(id).getQuestion();
    }

    @GetMapping(value = "/questions")
    public List<QuizElementDTO> questions() {

        for (Questions key : questionsService.getAllQuestions()) {
            questionList.add(new QuizElementDTO(key, key.getAnswers()));
        }


        return questionList;
    }

    @RequestMapping(value = "/save-question", method = RequestMethod.POST)
    public String addQuestion(@RequestBody QuizElementDTO dto) {
        Questions newQuestion = new Questions();
        newQuestion.setQuestion(dto.getQuestion());
        newQuestion.setType(dto.getType());
        questionsService.saveQuestion(newQuestion);
        return "Question Saved!";
    }

    @RequestMapping(value = "/save-answers", method = RequestMethod.POST)
    public String addAnswers(@RequestParam Integer fId, String atsakymas) {
        Answer answer = new Answer();
        answer.setFid(fId);
        answer.setAnswer(atsakymas);

        return "Answers added!";
    }

    @GetMapping(value = "/delete-question")
    public String deleteQuestion(@RequestParam Integer id) {

        for (QuizElementDTO dto : questionList) {
            if (dto.getId() == id) {
                questionsService.deleteQuestion(id);
            }
        }
        return "Question deleted!";
    }

}



*/
