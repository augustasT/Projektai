package springApp.controller;

import org.apache.catalina.User;
import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.apache.jasper.tagplugins.jstl.core.Set;
import org.omg.PortableServer.ForwardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import springApp.controller.dto.AnswersDTO;
import springApp.controller.dto.QuizElementDTO;
import springApp.controller.dto.RegistrationDTO;
import springApp.controller.dto.ShowStatisticsDTO;
import springApp.controller.dto.UserDTO;
import springApp.controller.dto.UsersAnswersDTO;
import springApp.domain.Answer;
import springApp.domain.AnswerType;
import springApp.domain.Questions;
import springApp.domain.Users;
import springApp.domain.UsersAnswers;
import springApp.service.AnswersService;
import springApp.service.QuestionsService;
import springApp.service.UsersAnswersService;
import springApp.service.UsersService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Registration;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class QuestionJSPController {
	private QuestionsService questionsService;
	private UsersService usersService;
	private List<Users> userList;
	private AnswersService answerService;
	private UsersAnswersService usersAnswersService;

	@Autowired
	public QuestionJSPController(QuestionsService questionsService, UsersService usersService,
			AnswersService answersService, UsersAnswersService usersAnswersService) {
		this.usersAnswersService = usersAnswersService;
		this.answerService = answersService;
		this.questionsService = questionsService;
		this.usersService = usersService;
	}

	public List<Questions> getAllQuestions() {

		return questionsService.getAllQuestions();
	}

	public List<UsersAnswers> getAllAnswers() {
		return usersAnswersService.getAllUsersAnswers();
	}

	public List<Users> getAllUsers() {
		return usersService.findAllUsers();
	}

	private void generateQuestionDTOList(List<QuizElementDTO> questionList) {
		for (Questions key : questionsService.getAllQuestions()) {
			questionList.add(new QuizElementDTO(key, key.getAnswers()));
		}
	}

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public ModelAndView startUp() {
		ModelAndView modelNView = new ModelAndView("start");
		return modelNView;
	}

	//////////// QUIZ //////////////////////////////////////////////////

	@RequestMapping(value = "/submitAnswers", method = RequestMethod.POST)
	public ModelAndView getQuizAnswers(@ModelAttribute("usersAnswers") UsersAnswersDTO usersAnswersDTO,
			BindingResult result, ModelMap model, HttpServletRequest request) {
		List<QuizElementDTO> questionList = new ArrayList<QuizElementDTO>();
		userList = new ArrayList<Users>();

		generateQuestionDTOList(questionList);

		model.addAttribute("questionList", questionList);
		model.addAttribute("userID", usersAnswersDTO.getUserId());

		Map<String, String[]> answersMap = new HashMap<String, String[]>();
		answersMap = request.getParameterMap();

		for (String key : answersMap.keySet()) {
			for (String answer : answersMap.get(key)) {
				try {
					usersAnswersDTO.setQuestionId(Integer.parseInt(key));
				}

				catch (NumberFormatException e) {
					continue;
				}

				usersAnswersDTO.setAnswer(answer);
				usersAnswersService.saveUsersAnswers(usersAnswersDTO);

			}
		}

		ModelAndView modelView = new ModelAndView("answers");

		List<Questions> questionsList = new ArrayList<Questions>();
		questionsList = getAllQuestions();

		List<UsersAnswers> answersList = new ArrayList<UsersAnswers>();
		answersList = getAllAnswers();

		List<Users> userList = new ArrayList<Users>();
		userList = getAllUsers();

		modelView.addObject("questionList", questionsList);
		modelView.addObject("answerList", answersList);
		modelView.addObject("userList", userList);
		modelView.addObject("userId", usersAnswersDTO.getUserId());
		return modelView;
	}
	////////////////////////////////////////////////////////////////////////

	//////////////// LOGIN
	//////////////// ///////////////////////////////////////////////////////////
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView logIn() {
		userList = new ArrayList<Users>();

		for (Users user : usersService.findAllUsers())
			userList.add(user);

		ModelAndView modelNView = new ModelAndView("logIn");
		modelNView.addObject("userList", userList);
		modelNView.addObject("user", new UserDTO());
		modelNView.addObject("invalid", false);

		return modelNView;
	}

	@RequestMapping(value = "logincheck", method = RequestMethod.POST)
	public ModelAndView logInCheck(@ModelAttribute("user") UserDTO userDTO, BindingResult result, ModelMap model,
			HttpServletRequest request) {
		userList = new ArrayList<Users>();

		for (Users user : usersService.findAllUsers())
			userList.add(user);

		model.addAttribute("password", userDTO.getPassword());
		model.addAttribute("lastName", userDTO.getLastName());

		String password = userDTO.MyMD5(userDTO.getPassword());
		String lastName = userDTO.getLastName();

		for (Users user : userList) {
			if (password.equals(user.getPassword()) && lastName.equals(user.getLastName())) {

				List<QuizElementDTO> questionList = new ArrayList<QuizElementDTO>();
				generateQuestionDTOList(questionList);
				UsersAnswersDTO usersAnswersDTO = new UsersAnswersDTO();
				usersAnswersDTO.setUserId(user.getId());

				ModelAndView modelNView = new ModelAndView("quiz");
				modelNView.addObject("questionList", questionList);
				modelNView.addObject("usersAnswers", usersAnswersDTO);
				modelNView.addObject("userID", user.getId());
				modelNView.addObject("userList", getAllUsers());

				return modelNView;
			}
		}

		ModelAndView modelnView = new ModelAndView("logIn");
		modelnView.addObject("invalid", true);

		return modelnView;

	}

	@RequestMapping(value = "/showAllResults", method = RequestMethod.GET)
	public ModelAndView showAllResults() {
		ModelAndView modelView = new ModelAndView("showAllResults");
		modelView.addObject("userList", getAllUsers());
		modelView.addObject("questionList", getAllQuestions());
		modelView.addObject("answerList", getAllAnswers());

		return modelView;
	}
	////////////////////////////////////////////////////////////////////////

	// REGISTRATION ////////////////////////////////////////////////////////
	@RequestMapping(value = "/jsptest", method = RequestMethod.GET)
	public ModelAndView welcome() {
		List<QuizElementDTO> questionList = new ArrayList<QuizElementDTO>();

		generateQuestionDTOList(questionList);
		ModelAndView modelNView = new ModelAndView("register");
		modelNView.addObject("questionList", questionList);

		modelNView.addObject("user",
				UserDTO.UserDTOBuilder.aUserDTOBuilder().withName("vardas").withLastName("pavarde").build());

		return modelNView;
	}

	@RequestMapping(value = "/receiveAnswer", method = RequestMethod.POST)
	public ModelAndView receiveAnswer(@ModelAttribute("user") UserDTO userDTO, BindingResult result, ModelMap model,
			HttpServletRequest request) {
		List<QuizElementDTO> questionList = new ArrayList<QuizElementDTO>();
		userList = new ArrayList<Users>();

		generateQuestionDTOList(questionList);

		model.addAttribute("questionList", questionList);
		model.addAttribute("name", userDTO.getName());
		model.addAttribute("lastName", userDTO.getLastName());
		model.addAttribute("gender", userDTO.getGender());

		String[] languages = request.getParameterValues("choice");
		String password = request.getParameter("password");
		for (String x : languages)
			userDTO.addNewLanguage(x);

		password = userDTO.MyMD5(password);
		userDTO.setPassword(password);
		usersService.saveNewUser(userDTO);

		for (Users user : usersService.findAllUsers())
			userList.add(user);

		model.addAttribute("userList", userList);

		return new ModelAndView("redirect:login");
	}

	////////////////////////////////////////////////////////////////////////

	/*public void createAllResultList() {

		List<Users> userList = new ArrayList<Users>();
		userList = getAllUsers();
		List<UsersAnswers> answerList = new ArrayList<UsersAnswers>();
		answerList = getAllAnswers();

		List<Questions> questionList = new ArrayList<Questions>();
		questionList = getAllQuestions();
		List<QuizElementDTO> dtoList = new ArrayList<QuizElementDTO>();
		
		List<ShowStatisticsDTO> statisticsList = new ArrayList<ShowStatisticsDTO>();

		for (Users user : userList) {
			ShowStatisticsDTO userStatistic = new ShowStatisticsDTO();
			userStatistic.setUserId(user.getId());
			
			for (Questions question : questionList) {
				QuizElementDTO dto = new QuizElementDTO();
				List<String> newAnswerList = new ArrayList<String>();
				
				dto.setQuestion(question.getQuestion());
				
				for(UsersAnswers answer: answerList) {
					if(answer.getQuestionId()==question.getId() && answer.getUserId()==user.getId())
						newAnswerList.add(answer.getAnswer());
				}
				dto.setAnswers(newAnswerList);
				
			}
			statisticsList.add(userStatistic);

		}

	}*/

	@RequestMapping(value = "/add-question", method = RequestMethod.GET)
	public ModelAndView newQuestion() {

		ModelAndView modelView = new ModelAndView("newQuestion");

		RegistrationDTO reg = new RegistrationDTO();

		modelView.addObject("registration", reg);

		return modelView;
	}

	@RequestMapping(value = "/save-question", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute("registration") RegistrationDTO reg, BindingResult result, ModelMap model,
			HttpServletRequest request) {

		model.addAttribute("question", reg.getQuestion());
		model.addAttribute("answer1", reg.getAnswer1());
		model.addAttribute("answer2", reg.getAnswer2());
		model.addAttribute("answer3", reg.getAnswer3());
		model.addAttribute("answer4", reg.getAnswer4());
		model.addAttribute("answer5", reg.getAnswer5());

		String string = request.getParameter("questionType");

		AnswerType type = AnswerType.checkbox;
		if (string.equals("input"))
			type = AnswerType.input;
		else if (string.equals("radiobutton"))
			type = AnswerType.radiobutton;
		else if (string.equals("select"))
			type = AnswerType.select;

		Questions newQuestion = new Questions();
		newQuestion.setQuestion(reg.getQuestion());
		newQuestion.setType(type);
		questionsService.saveQuestion(newQuestion);

		Answer answer1 = new Answer();
		Answer answer2 = new Answer();
		Answer answer3 = new Answer();
		Answer answer4 = new Answer();
		Answer answer5 = new Answer();

		answer1.setAnswer(reg.getAnswer1());
		if (!answer1.getAnswer().equals("")) {
			answer1.setFid(newQuestion.getId());
			answerService.saveAnswer(answer1);
		}

		answer2.setAnswer(reg.getAnswer2());
		if (!answer2.getAnswer().equals("")) {
			answer2.setFid(newQuestion.getId());
			answerService.saveAnswer(answer2);
		}

		answer3.setAnswer(reg.getAnswer3());
		if (!answer3.getAnswer().equals("")) {
			answer3.setFid(newQuestion.getId());
			answerService.saveAnswer(answer3);
		}
		answer4.setAnswer(reg.getAnswer4());
		if (!answer4.getAnswer().equals("")) {
			answer4.setFid(newQuestion.getId());
			answerService.saveAnswer(answer4);
		}
		answer5.setAnswer(reg.getAnswer5());
		if (!answer5.getAnswer().equals("")) {
			answer5.setFid(newQuestion.getId());
			answerService.saveAnswer(answer5);
		}

		return "getBack";
	}

}
