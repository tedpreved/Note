package com.note.app.Note;

import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.note.app.Data.DBHelper;
import com.note.app.Data.Singleton;

/**
 * Created by Monstr on 12.04.2014.
 */
public class NoteApp extends Application {

    DBHelper dbHelper;
    SQLiteDatabase sdb;


    public SQLiteDatabase callbackBD(){
        return sdb;
    }


	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Singleton.getInstance().Init();
		Singleton.getInstance().InitUser();



        dbHelper = new DBHelper(this, "mydatabase.db", null, 1);

        sdb = dbHelper.getWritableDatabase();

        ContentValues newValues = new ContentValues();
        // Задайте значения для каждой строки.
        newValues.put(dbHelper.USER_COLUMN, "Teo");
        newValues.put(dbHelper.TITLE_COLUMN, "Fist try SQLite");
        newValues.put(dbHelper.NOTE_COLUM, "Uda4a");
        // Вставляем данные в базу
        sdb.insert("notes", null, newValues);
	}

}
