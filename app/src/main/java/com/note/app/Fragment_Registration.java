package com.note.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Home on 3/29/14.
 */
public class Fragment_Registration extends Fragment {
	
	

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_registration,null);


        return view;
    }
}
