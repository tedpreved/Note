package com.note.app.Data;

import com.note.app.Data.UserExceptions.Error;
import com.note.app.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Singleton {

	private final ArrayList<HashMap<String, String>> Notes;

	private static final String TITLE = "name";
	private static final String DESCRIPTION = "description";
	private static Singleton sInstance;
	private HashMap<String, String> noteBuffer;
	private HashSet<User> Users;
	private User UserInSystem;

	public static Singleton getInstance() {
		if (sInstance == null) {
			sInstance = new Singleton();
		}
		return sInstance;
	}

	private Singleton() {
		Notes = new ArrayList<HashMap<String, String>>();
		Users = new HashSet<User>();
	}

	public void Init() {
		noteBuffer = new HashMap<String, String>();
		noteBuffer.put(TITLE, "First");
		noteBuffer.put(DESCRIPTION, "It's the first note");
		Notes.add(noteBuffer);

		noteBuffer = new HashMap<String, String>();
		noteBuffer.put(TITLE, "Second");
		noteBuffer.put(DESCRIPTION, "It's the second note");
		Notes.add(noteBuffer);
	}

	public void InitUser() {
		Users.add(newUser("Teo", "123"));
		Users.add(newUser("Ted", "345"));
	}

	public ArrayList<HashMap<String, String>> getNotes() {
		return Notes;
	}

	public void addNote(String noteName, String noteText) {
		noteBuffer = new HashMap<String, String>();
		noteBuffer.put(TITLE, noteName);
		noteBuffer.put(DESCRIPTION, noteText);
		Notes.add(noteBuffer);
	}

	public boolean setPassword(User LogInUser, String Old, String NewPass) {
		for (User user : Users) {
			if (user.getLogin().equals(LogInUser.getLogin()) == true) {
				if (LogInUser.getPass().equals(Old)) {
					user.setPass(NewPass);
					return true;
				}
			}
		}
		return false;
	}

	public void login(String Name, String Pass) throws UserExceptions {
		for (User user : Users) {
			if (user.getLogin().equals(Name)) {
				if (user.getPass().equals(Pass)) {
					setUserInSystem(user);
					return;
				} else {
					throw new UserExceptions(Error.WRONG_PASSWORD);
				}
			}
		}
		throw new UserExceptions(Error.USER_NOT_FOUND);
	}

	public User getUserInSystem() {
		return UserInSystem;
	}

	private void setUserInSystem(User userInSystem) {
		UserInSystem = userInSystem;
	}

	private User newUser(String Login, String Pass) {
		return new User(Login, Pass);
	}

	public void addUser(String Login, String Pass) {
		Users.add(newUser(Login, Pass));
	}

	public void editNote(int position, String NewTitle, String NewDescription) {
		Notes.get(position).put(TITLE, NewTitle);
		Notes.get(position).put(DESCRIPTION, NewDescription);

	}

	public void removeNote(int position) {
		Notes.remove(position);
	}

	public void registrationNewUser(String Login, String Pass, String repeatPass) throws UserExceptions {
		boolean nameFree = true;
		for (User user : Users) {
			if (user.getLogin() == Login) {
				nameFree = false;
			}}
            if(nameFree){
                if (Pass.equals(repeatPass)) {
                    Singleton.getInstance().addUser(Login, repeatPass);
                } else{ throw new UserExceptions(Error.PASSWORD_MISSMATCH);}
            } else { throw new UserExceptions(Error.THIS_LOGIN_NOT_FREE);}


	}

}
