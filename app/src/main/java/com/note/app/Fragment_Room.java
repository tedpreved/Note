package com.note.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

/**
 * Created by Monstr on 30.03.2014.
 */
public class Fragment_Room extends Fragment {

    HashMap<String, Object> hm;

    private static final String TITLE = "name";
    private static final String DESCRIPTION = "description";
	
	
	ListView listView;

    public static String[] mass={"First","Second","Third"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_room,null);



        listView =(ListView) view.findViewById(R.id.listViewRoom);

       // ArrayAdapter listViewAdapter= new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,mass);
        SimpleAdapter listViewAdapter=new SimpleAdapter(getActivity(),Singleton.Notes,R.layout.list_item,new String[]{TITLE,DESCRIPTION},new int[]{R.id.text1,R.id.text2});
        listView.setAdapter(listViewAdapter);
        return view;
    }
}
