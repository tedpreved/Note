package com.note.app;

import java.util.List;

public class Singleton {
	
	 private static final Singleton instance;
	 
	 private List<String> ListNotes; 
	 
	 
	 
	    static {
	        try {
	            instance = new Singleton();
	        } catch (Exception e) {
	            throw new RuntimeException("Darn, an error occurred!", e);
	        }
	    }
	 
	    public static Singleton getInstance() {
	        return instance;
	    }
	    	    	 
	    private Singleton() {	
	    	
	     ListNotes.add("1");
	   	 ListNotes.add("2");
	   	 ListNotes.add("3");
	   	 
	    }
	    public void putInstance(String stuff) {
			ListNotes.add(stuff);
		}

}
