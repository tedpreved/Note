package com.note.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Home on 3/29/14.
 */
public class Fragment_Registration extends Fragment {

	EditText editNewLogin, editNewPass, editNewPassVer;

	@Override
	public void onSaveInstanceState(Bundle outState) {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_registration, null);

		editNewLogin = (EditText) view.findViewById(R.id.editNewLogin);
		editNewPass = (EditText) view.findViewById(R.id.editNewPass);
		editNewPassVer = (EditText) view.findViewById(R.id.editNewPassVer);

		return view;
	}
}
