package com.note.app;

public class User {

	private String Login;
	private String Password;

	public User(String name, String pass) {
		Login = name;
		Password = pass;
	}

	public String getLogin() {
		return Login;
	}

	public String getPass() {
		return Password;
	}

	public void setPass(String NewPass) {
		Password = NewPass;
	}
}
