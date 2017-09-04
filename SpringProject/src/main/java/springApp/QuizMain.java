package springApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springApp.controller.dto.QuizElementDTO;

@SpringBootApplication
public class QuizMain extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(QuizMain.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(QuizMain.class, args);

    }
}
