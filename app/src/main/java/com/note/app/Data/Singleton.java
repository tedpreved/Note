package com.note.app.Data;

import java.util.ArrayList;
import java.util.HashMap;

public class Singleton {

	private final ArrayList<HashMap<String, String>> Notes;

	private static final String TITLE = "name";
	private static final String DESCRIPTION = "description";

	private static Singleton sInstance;

	private HashMap<String, String> hm;

	public static Singleton getInstance() {
		if (sInstance == null) {
			sInstance = new Singleton();
		}
		return sInstance;
	}

	private Singleton() {
		Notes = new ArrayList<HashMap<String, String>>();
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

	public ArrayList<HashMap<String, String>> getNotes() {
		return Notes;
	}

	public void putItem(String noteName, String noteText) {
		hm = new HashMap<String, String>();
		hm.put(TITLE, noteName);
		hm.put(DESCRIPTION, noteText);
		Notes.add(hm);
	}

}
