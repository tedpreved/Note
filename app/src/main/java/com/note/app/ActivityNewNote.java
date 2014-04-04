package com.note.app;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;


public class ActivityNewNote extends Activity {

    HashMap<String, Object> hm;
    private static final String TITLE = "name";
    private static final String DESCRIPTION = "description";



    Fragment myFrag=getFragmentManager().findFragmentById(R.id.fragment);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_note, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return myFrag.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
