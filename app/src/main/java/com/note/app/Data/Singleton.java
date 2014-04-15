package com.note.app.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.note.app.User;

public class Singleton {

	private final ArrayList<HashMap<String, String>> Notes;

	private static final String TITLE = "name";
	private static final String DESCRIPTION = "description";
	private static Singleton sInstance;
	private HashMap<String, String> hm;
	private HashSet<User> Users;
	public User UserInSystem;

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
		hm = new HashMap<String, String>();
		hm.put(TITLE, "First");
		hm.put(DESCRIPTION, "It's the first note");
		Notes.add(hm);

		hm = new HashMap<String, String>();
		hm.put(TITLE, "Second");
		hm.put(DESCRIPTION, "It's the second note");
		Notes.add(hm);
	}

	public void InitUser() {

		Users.add(new User("Teo", "123"));
		Users.add(new User("Ted", "345"));

	}

	public ArrayList<HashMap<String, String>> getNotes() {
		return Notes;
	}

	public void putItem(String noteName, String noteText) {
		hm = new HashMap<String, String>();
		hm.put(TITLE, noteName);
		hm.put(DESCRIPTION, noteText);
		Notes.add(hm);
	}

	public void setPassword(User LogInUser, String Old, String repeatOld,
			String NewPass) {
		for (User user : Users) {
			if (user.getLogin().equals(LogInUser.getLogin()) == true) {
				if (user.getPass().equals(Old)) {
					user.setPassword(repeatOld, NewPass);
				}
			}
		}

	}

	public boolean Userscheck(String Name, String Pass) {
		for (User user : Users) {
			if (user.getLogin().equals(Name) == true) {
				if (user.getPass().equals(Pass) == true) {
					UserInSystem = user;
					return true;
				}
			}
		}
		return false;
	}

	public void setPass() {
	}

}
