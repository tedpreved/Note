package com.note.app.UI.Main;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.note.app.R;
import com.note.app.Data.Singleton;
import com.note.app.UI.Room.ActivityRoom;

/**
 * Created by Home on 3/29/14.
 */

public class Fragment_Login extends Fragment {

	private static String TAG_FOR_LOGIN = "Login";
	private static String TAG_FOR_PASS = "Password";
	private String mBufferLogin;
	private String mBufferPassword;

	EditText etLogin, etPassword;
	Button btnLogin;

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(TAG_FOR_LOGIN, mBufferLogin);
		outState.putString(TAG_FOR_PASS, mBufferPassword);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState == null) {
			// mBufferLogin=savedInstanceState.getChar(TAG_FOR_LOGIN);
		}

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_login, null);

		etLogin = (EditText) view.findViewById(R.id.etLogin);
		etPassword = (EditText) view.findViewById(R.id.etPassword);

		btnLogin = (Button) view.findViewById(R.id.btnLogin);

		Button.OnClickListener clickListener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Singleton.getInstance().chekInUsers(
						etLogin.getText().toString(),
						etPassword.getText().toString())) {
					Intent room = new Intent(getActivity(), ActivityRoom.class);
					startActivity(room);
					getActivity().finish();
				} else {
					Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT)
							.show();
				}

			}
		};

		btnLogin.setOnClickListener(clickListener);
		return view;
	}
}
