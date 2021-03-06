package model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;



public class User {
	
	@Email 
	private String email;
	
	@Size(min=8, max=20)
	private String password;
	
	@Size(min=4) 
	private String name;
	
	
	private int id;
	
	@Pattern(regexp="[0-9]")
	private String account;
	
	private String fileName;

	private String facebookId;
	
	public User() {

	}
	
	public User(String fId, String fName){
		this.facebookId = fId;
		this.name = fName;
	}
	
	public User(String email, String password, String name, String account) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean checkPs(String inputPs) {
		return this.password.equals(inputPs);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getFileName() {
		return fileName;
	}

	public void setUserFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	
	public String getFacebookId() {
		return this.facebookId;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", id=" + id + ", account=" + account + ", fileName="
				+ fileName + ", facebookId=" + facebookId + "]";
	}

}
