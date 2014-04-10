package com.note.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActivityRoom extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_room, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_search:
			Intent NewNote = new Intent(this, ActivityNewNote.class);
			startActivity(NewNote);
			break;

		case R.id.change_pass:
			Intent ChangePass = new Intent(this, ActivityDialogChangePass.class);
			startActivity(ChangePass);
			break;

		}

		return super.onMenuItemSelected(featureId, item);
	}

}
