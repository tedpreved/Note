package com.note.app.UI.ChangePass;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.note.app.R;

public class Fragment_ChangePass extends Fragment {

	Button btnCancel;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_change_pass, null);

		btnCancel = (Button) view.findViewById(R.id.btnCancel);

		OnClickListener btnListener = new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Intent Room=new Intent(getActivity(),ActivityRoom.class);
				// Room.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// startActivity(Room);
				getActivity().finish();
				// getActivity().finish();

			}
		};

		btnCancel.setOnClickListener(btnListener);

		return view;
	}
}
