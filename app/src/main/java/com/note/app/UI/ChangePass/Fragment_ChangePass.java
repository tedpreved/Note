package com.note.app.UI.ChangePass;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.note.app.R;
import com.note.app.Data.Singleton;

public class Fragment_ChangePass extends Fragment {

	Button btnCancel, btnChange;
	EditText tvOldPass, tvNewPass, tvNewPassRepeat;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_change_pass, null);

		btnCancel = (Button) view.findViewById(R.id.btnCancel);
		btnChange = (Button) view.findViewById(R.id.btnChange);
		tvOldPass = (EditText) view.findViewById(R.id.tvOldPass);
		tvNewPass = (EditText) view.findViewById(R.id.tvNewPass);
		tvNewPassRepeat = (EditText) view.findViewById(R.id.NewPassRepeat);

		OnClickListener btnListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.btnCancel:
					getActivity().finish();
					break;
				case R.id.btnChange:
					Singleton.getInstance().setPassword(
							Singleton.getInstance().UserInSystem,
							tvOldPass.getText().toString(),
							tvNewPass.getText().toString(),
							tvNewPass.getText().toString());
					getActivity().finish();
					break;
				}

			}
		};

		btnCancel.setOnClickListener(btnListener);
		btnChange.setOnClickListener(btnListener);
		return view;
	}
}
