package com.note.app;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ActivityNewNote extends Activity {

	Fragment myFrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_note);
		myFrag = getFragmentManager().findFragmentById(R.id.fragment);

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

	

}
