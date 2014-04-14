package com.note.app.Note;

import android.app.Application;

import com.note.app.Data.Singleton;

/**
 * Created by Monstr on 12.04.2014.
 */
public class NoteApp extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Singleton.getInstance().Init();
	}

}
