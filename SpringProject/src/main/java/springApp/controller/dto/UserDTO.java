package springApp.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

	private String name;
	private String lastName;
	private String gender;
	private String languageString = "";
	private String password;

	public String getPassword() {
		
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLanguageString() {
		return languageString;
	}

	public void setLanguageString(String languageString) {
		this.languageString = languageString;
	}

	public void addNewLanguage(String language) {
		languageString += " " + language;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String MyMD5(String unhidden) {
		String hidden = "";

		for (int i = 0; i < unhidden.length()-1; i++) {
			hidden += unhidden.charAt(unhidden.length()-1-i);
		}

		return hidden;
	}

	public static class UserDTOBuilder {
		private String name;
		private String lastName;
		private List<String> genderList = new ArrayList<String>();

		public static UserDTOBuilder aUserDTOBuilder() {

			return new UserDTOBuilder();
		}

		public UserDTOBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public UserDTOBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		/*
		 * public UserDTOBuilder withDefaultGenders() { genderList.add("vyras");
		 * genderList.add("moteris"); genderList.add("trans");
		 * 
		 * return this; }
		 */

		public UserDTO build() {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(name);
			userDTO.setLastName(lastName);
			return userDTO;
		}

	}

}
