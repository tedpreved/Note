package com.note.app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.note.app.Data.Singleton;
import com.note.app.NoteObj.NoteItem;

/**
 * Created by student on 4/28/14.
 */
public class MyAdapter extends BaseAdapter {

    OnDeleteItemListner listner;



    @Override
    public int getCount() {
        return Singleton.getInstance().getNotes().size();
    }

    @Override
    public NoteItem getItem(int position) {
        return Singleton.getInstance().getNotes().get(position);
    }

    @Override
    public long getItemId(int position) {
        return Singleton.getInstance().getNotes().get(position).getID();
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView==null){
            convertView=View.inflate(parent.getContext(),R.layout.list_item,null);
            holder = new Holder();
            holder.tvTitle=(TextView)convertView.findViewById(R.id.text1);
            holder.tvDescription=(TextView)convertView.findViewById(R.id.text2);
            holder.btnDel=(ImageButton)convertView.findViewById(R.id.imgBtn);
            convertView.setTag(holder);
        } else{
           holder=(Holder)convertView.getTag();

        }


        holder.tvTitle.setText(getItem(position).getTitle());
        holder.tvDescription.setText(getItem(position).getText());
        if(listner!=null){
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listner!=null){
                listner.onItemDeleteClick(position);}
            }
        });}


       return convertView;
    }

    private static class Holder{
       public TextView tvTitle;
       public TextView tvDescription;
       public ImageButton btnDel;

    }

    public void setOnDeleteClickListener(OnDeleteItemListner listener){
        this.listner=listener;

    }
    
    public static interface OnDeleteItemListner{

        void onItemDeleteClick(int position);


    }

}
