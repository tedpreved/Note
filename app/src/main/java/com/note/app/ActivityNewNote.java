package com.note.app;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class ActivityNewNote extends Activity implements AddSaveNote{

    HashMap<String, Object> hm;
    private static final String TITLE = "name";
    private static final String DESCRIPTION = "description";

    EditText editText1,editText2;
    HashMap<String, Object> hmBuff;



    Fragment myFrag=getFragmentManager().findFragmentById(R.id.fragment);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        editText1=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_note, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (featureId){
            case R.id.action_save:
               hmBuff =new HashMap<String, Object>();
                hmBuff.put(TITLE,editText1.getText().toString());
                hmBuff.put(DESCRIPTION,editText2.getText().toString());
                addNote(hmBuff);
                Toast.makeText(this, "work", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public void addNote(HashMap<String, Object> hm) {
        hm.put(TITLE,"first");
        hm.put(DESCRIPTION,"bla bla bla");
        Singleton.Notes.add(hm);
    }
}
