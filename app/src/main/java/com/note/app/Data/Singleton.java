package com.note.app.Data;

import com.note.app.Data.UserExceptions.Error;
import com.note.app.NoteObj.NoteItem;
import com.note.app.User;

import java.util.ArrayList;
import java.util.HashSet;

public class Singleton {

	private static Singleton sInstance;
	private HashSet<User> Users;
	private User UserInSystem;

    private ArrayList<NoteItem> Notessss;//add

	public static Singleton getInstance() {
		if (sInstance == null) {
			sInstance = new Singleton();
		}
		return sInstance;
	}

	private Singleton() {
		Users = new HashSet<User>();
        Notessss= new   ArrayList<NoteItem>();// add

	}

	public void Init() {
        Notessss.add(new NoteItem("Firsttt","ttttt"));
        Notessss.add(new NoteItem("Seconddd","dddd"));
	}

	public void InitUser() {
		Users.add(newUser("Teo", "123"));
		Users.add(newUser("Ted", "345"));
	}

	public ArrayList<NoteItem> getNotes() {
		return Notessss;
	}

	public void addNote(String noteName, String noteText) {
       Notessss.add(new NoteItem(noteName,noteText));

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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        Notessss.get(position).setTitle(NewTitle);
        Notessss.get(position).setText(NewDescription);
	}

	public void removeNote(int position) {
        Notessss.remove(position);
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
