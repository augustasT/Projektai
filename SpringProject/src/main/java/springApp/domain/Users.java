package springApp.domain;

import springApp.controller.dto.UserDTO;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column (name = "gender")
    private String gender;

    @Column (name="programming_language")
    private String languageString;
    
    @Column(name = "password")
    private String password;

    
    public Users() {
    	
    }
    
    

    public String getLanguageString() {
		return languageString;
	}



	public void setLanguageString(String languageString) {
		this.languageString = languageString;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Users(UserDTO user) {
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.gender = user.getGender();
        this.languageString = user.getLanguageString();
        this.password = user.getPassword();

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
