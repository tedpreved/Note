package com.note.app.UI.Room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.note.app.R;
import com.note.app.UI.ChangePass.ActivityDialogChangePass;
import com.note.app.UI.Main.ActivityMain;
import com.note.app.UI.NewNote.ActivityNewNote;

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
			NewNote.putExtra("ID", 888);
			startActivity(NewNote);
			break;

		case R.id.change_pass:
			Intent ChangePass = new Intent(this, ActivityDialogChangePass.class);
			startActivity(ChangePass);
			break;
		case R.id.logout:
			Intent Main = new Intent(this, ActivityMain.class);
			startActivity(Main);
			finish();
			break;

		}

		return super.onMenuItemSelected(featureId, item);
	}

}
