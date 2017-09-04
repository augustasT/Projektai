package springApp.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "answer")
	private String answer;

	@Column(name = "f_id")
	private int fid;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public Integer getId() {
		return id;
	}

	public String getAnswer() {
		return answer;
	}

	public int getFid() {
		return fid;
	}
}
