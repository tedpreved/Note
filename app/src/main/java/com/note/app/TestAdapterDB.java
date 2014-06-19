package com.note.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by student on 6/16/14.
 */
public class TestAdapterDB extends CursorAdapter {

    public static final String USER_COLUMN = "user";
    public static final String TITLE_COLUMN = "title";
    public static final String NOTE_COLUM = "note";


    public TestAdapterDB(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        Holder holder;
        View view=View.inflate(context,R.layout.cursor_item,parent);

        holder = new Holder();
        holder.tvTitle=(TextView)view.findViewById(R.id.text1);
        holder.tvDescription=(TextView)view.findViewById(R.id.text2);
        holder.btnDel=(ImageButton)view.findViewById(R.id.imgBtn);
        view.setTag(holder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
       Holder holder;
       holder=(Holder)view.getTag();

            holder.tvTitle.setText(cursor.getString(cursor.getColumnIndex(TITLE_COLUMN)));
            holder.tvDescription.setText(cursor.getString(cursor.getColumnIndex(NOTE_COLUM)));


    }

    private static class Holder{
        public TextView tvTitle;
        public TextView tvDescription;
        public ImageButton btnDel;

    }
}


