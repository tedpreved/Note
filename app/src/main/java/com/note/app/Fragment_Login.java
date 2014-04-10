package com.note.app;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Home on 3/29/14.
 */

public class Fragment_Login extends Fragment {

	private static String TAG = "myTag";

	private static String TAG_FOR_LOGIN = "Login";
	private static String TAG_FOR_PASS = "Password";

	final private String testLogin = "Admin";
	final private String testPassword = "Admin123";

	EditText etLogin, etPassword;
	Button btnLogin;

	private String mBufferLogin;
	private String mBufferPassword;

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

				Log.d(TAG, "Input:" + mBufferLogin + "__" + mBufferPassword);
				Log.d(TAG, "Const;" + testLogin + "__" + testPassword);
				mBufferPassword = etPassword.getText().toString();
				mBufferLogin = etLogin.getText().toString();

				if ((mBufferLogin.equals(Singleton.testLogin))
						&& (mBufferPassword.equals(Singleton.testPass))) {
					Intent room = new Intent(getActivity(), ActivityRoom.class);
					startActivity(room);
					getActivity().finish();
				} else {
					if (mBufferPassword == testPassword) {
						Toast.makeText(getActivity(), "Cannot find pass",
								Toast.LENGTH_SHORT).show();
					}
					;
					if (mBufferLogin != Singleton.testLogin) {
						Toast.makeText(getActivity(), "Error",
								Toast.LENGTH_SHORT).show();
					}
				}
			}
		};

		// etLogin.setText(mBufferLogin);

		btnLogin.setOnClickListener(clickListener);
		return view;
	}

}
