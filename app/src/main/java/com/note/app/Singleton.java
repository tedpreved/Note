package com.note.app;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Application;

public class Singleton extends Application {

	public static final ArrayList<HashMap<String, Object>> Notes;
	HashMap<String, Object> hm;
	public static int Counter = 0;

	public static final String testLogin;
	public static final String testPass;

	private static final String TITLE = "name";
	private static final String DESCRIPTION = "description";

	public void putItem(String noteName, String noteText) {
	}

	static {
		Notes = new ArrayList<HashMap<String, Object>>();
		testLogin = "Admin";
		testPass = "123";

	}

	public Singleton() {

		hm = new HashMap<String, Object>();
		hm.put(TITLE, "first");
		hm.put(DESCRIPTION, "bla bla bla");
		Notes.add(hm);

		hm = new HashMap<String, Object>();
		hm.put(TITLE, "Second");
		hm.put(DESCRIPTION,
				"bla bla bla  sdfljsngkjbfskvb lfnvkfdsbvnajlfhvnkfdsljvbnfldvnfdkllbnfdlsbndfslbn");
		Notes.add(hm);
	}

}
