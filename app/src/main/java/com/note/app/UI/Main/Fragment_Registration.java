package com.note.app.UI.Main;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.note.app.R;
import com.note.app.Data.Singleton;

/**
 * Created by Home on 3/29/14.
 */
public class Fragment_Registration extends Fragment {

	EditText editNewLogin, editNewPass, editNewPassVer;
	Button btnRegistration;

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

		btnRegistration = (Button) view.findViewById(R.id.btnRegistration);

		OnClickListener btnAction = new OnClickListener() {

			@Override
			public void onClick(View v) {

				switch (v.getId()) {
				case R.id.btnRegistration:
					Singleton.getInstance().verifyUser(
							editNewLogin.getText().toString(),
							editNewPass.getText().toString(),
							editNewPassVer.getText().toString());
					Toast.makeText(getActivity(), "Registration succesfull",
							Toast.LENGTH_SHORT).show();

					break;
				}

			}
		};

		btnRegistration.setOnClickListener(btnAction);
		return view;
	}

}
