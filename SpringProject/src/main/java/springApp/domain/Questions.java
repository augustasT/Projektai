package springApp.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "questions")
public class Questions implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "question")
    private String question;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AnswerType type;
    
    @OneToMany(mappedBy = "fid")
    private List<Answer> answers;

    
    public List<Answer> getAnswers(){
        return answers;
    }

    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public AnswerType getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setType(AnswerType type) {
        this.type = type;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
