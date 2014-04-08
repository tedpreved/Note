package com.note.app;

import java.util.HashMap;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Monstr on 04.04.2014.
 */
public class Fragment_NewNote extends Fragment implements AddSaveNote {

	private static final String TITLE = "name";
	private static final String DESCRIPTION = "description";

	EditText editText1, editText2;
	HashMap<String, Object> hmBuff;
	Button btnAdd;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_new_note, null);

		editText1 = (EditText) view.findViewById(R.id.editText);
		editText2 = (EditText) view.findViewById(R.id.editText2);

		return view;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.action_save) {
			Log.d("asd", "onOptionsItemSelected " + item);
			hmBuff = new HashMap<String, Object>();
			hmBuff.put(TITLE, editText1.getText().toString());
			hmBuff.put(DESCRIPTION, editText2.getText().toString());
			addNote(hmBuff);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void addNote(HashMap<String, Object> hm) {
		Singleton.Notes.add(hm);

	}
}
