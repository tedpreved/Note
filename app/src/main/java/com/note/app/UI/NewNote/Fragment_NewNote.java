package com.note.app.UI.NewNote;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.note.app.R;
import com.note.app.Data.Singleton;
import com.note.app.UI.Room.ActivityRoom;

/**
 * Created by Monstr on 04.04.2014.
 */
public class Fragment_NewNote extends Fragment {

	private static final String ID = "ID";
	private static final String TEXT1 = "TEXT1";
	private static final String TEXT2 = "TEXT2";
	private static int position;

	EditText editText1, editText2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_new_note, null);
		Bundle b = getActivity().getIntent().getExtras();

		editText1 = (EditText) view.findViewById(R.id.editText);
		editText2 = (EditText) view.findViewById(R.id.tvOldPass);

		if (b.getInt(ID) != 888) {
			getActivity().setTitle(b.get(TEXT1).toString());
			position = b.getInt(ID);
			editText1.setText(b.get(TEXT1).toString());
			editText2.setText(b.get(TEXT2).toString());
		}

		return view;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.action_save) {
			if (getActivity().getTitle().equals("New Note") == true) {
				// --------------------Add Note to Singleton--------------
				Singleton.getInstance().addNote(editText1.getText().toString(),
						editText2.getText().toString());
			} else {
				Singleton.getInstance().editNote(position,
						editText1.getText().toString(),
						editText2.getText().toString());
			}
			// --------------------Start Activity Room------------------
			Intent Room = new Intent(getActivity(), ActivityRoom.class);
			Room.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(Room);
			// ----------------------------------------------------------
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
