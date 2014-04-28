package com.note.app.UI;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.note.app.Data.Singleton;
import com.note.app.R;

/**
 * Created by student on 4/28/14.
 */
public class TestAdapter extends SimpleAdapter {


    /**
     * Constructor
     *
     * @param context  The context where the View associated with this SimpleAdapter is running
     */
    public TestAdapter(Context context) {
        super(context, Singleton.getInstance().getNotes(), R.layout.list_item, new String[]{"name","description"},new int[] { R.id.text1,
                R.id.text2 });
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        ImageButton imgbtn;
        TextView tvTitle,tv;



        imgbtn=(ImageButton)view.findViewById(R.id.imgBtn);

        return view;
    }
}
