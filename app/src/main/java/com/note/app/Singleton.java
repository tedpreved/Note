package com.note.app;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;

public class Singleton extends Application{



    public static ArrayList<HashMap<String, Object>> Notes;
    HashMap<String, Object> hm;

        private static final String TITLE = "name";
        private static final String DESCRIPTION = "description";

    public void putItem(String noteName,String noteText) {
 }
	    	    	 
	    public Singleton() {

           Notes=new ArrayList<HashMap<String, Object>>();
            hm=new HashMap<String, Object>();
            hm.put(TITLE,"first");
            hm.put(DESCRIPTION,"bla bla bla");
            Notes.add(hm);

            hm=new HashMap<String, Object>();
            hm.put(TITLE,"Second");
            hm.put(DESCRIPTION,"bla bla bla  sdfljsngkjbfskvb lfnvkfdsbvnajlfhvnkfdsljvbnfldvnfdkllbnfdlsbndfslbn");
            Notes.add(hm);
	    }


}
