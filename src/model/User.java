package model;

import org.springframework.stereotype.Component;

public class User {
	private String email;
	private String password;
	private String name;
	private int id;
	private String account;

	public User() {

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

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name="
				+ name + ", id=" + id + ", account=" + account + "]";
	}

}
