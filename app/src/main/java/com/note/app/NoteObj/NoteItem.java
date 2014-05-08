package com.note.app.NoteObj;

/**
 * Created by student on 5/8/14.
 */
public class NoteItem {

    private String title;
    private String text;
    private  int ID;
    private static int counter=0;


    public String getTitle(){
        return this.title;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    static {

    }

    public int getID(){
        return ID;
    }
    public NoteItem(String name, String descriptio){
        this.title=name;
        this.text=descriptio;
        this.ID=counter++;

    }
}
