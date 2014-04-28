package com.note.app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.note.app.Data.Singleton;

/**
 * Created by student on 4/28/14.
 */
public class MyAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return Singleton.getInstance().getNotes().size();
    }

    @Override
    public Object getItem(int position) {
        return Singleton.getInstance().getNotes().get(position);
    }

    @Override
    public long getItemId(int position) {
        return Singleton.getInstance().getNotes();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view =(R.layout.list_item,null);

        ImageButton imgbtn;
        TextView tvTitle,tv;



        imgbtn=(ImageButton)view.findViewById(R.id.imgBtn);

        return view;
    }
}
