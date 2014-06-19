package com.note.app.UI.Room;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.note.app.Data.Singleton;
import com.note.app.MyAdapter;
import com.note.app.NoteObj.NoteItem;
import com.note.app.R;
import com.note.app.TestAdapterDB;
import com.note.app.UI.NewNote.ActivityNewNote;

import java.util.HashMap;

/**
 * Created by Monstr on 30.03.2014.
 */
public class Fragment_Room extends Fragment {

	HashMap<String, Object> hm;

	private static final String TITLE = "name";
	private static final String DESCRIPTION = "description";
	private static final String ID = "ID";
	private static final String TEXT1 = "TEXT1";
	private static final String TEXT2 = "TEXT2";

	AlertDialog.Builder ad;
	Context context;

	ListView listView;

	public static String[] mass = { "First", "Second", "Third" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_room, null);

		listView = (ListView) view.findViewById(R.id.listViewRoom);
//		SimpleAdapter listViewAdapter = new SimpleAdapter(getActivity(),
//				Singleton.getInstance().getNotes(), R.layout.list_item,
//				new String[] { TITLE, DESCRIPTION }, new int[] { R.id.text1,
//						R.id.text2 });

        //MyAdapter listViewAdapter= new MyAdapter();
        TestAdapterDB listViewAdapter=new TestAdapterDB(getActivity());
    //   listViewAdapter.setOnDeleteClickListener(new MyAdapter.OnDeleteItemListner() {
    //       @Override
    //       public void onItemDeleteClick(int position) {
    //           Singleton.getInstance().removeNote(position);
    //          if (listView.getAdapter() instanceof BaseAdapter) {
    //              ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
    //          }
    //      }
    //  });
		listView.setAdapter(listViewAdapter);

		OnItemClickListener listAction = new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent Edit = new Intent(getActivity(), ActivityNewNote.class);
				Edit.putExtra(ID, arg2);
				NoteItem obj = (NoteItem) listView
						.getAdapter().getItem(arg2);
				Edit.putExtra(TEXT1, obj.getTitle());
				Edit.putExtra(TEXT2, obj.getText());
				startActivity(Edit);
			}

		};

		OnItemLongClickListener listItemLongAction = new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, long id) {

				context = getActivity();
				ad = new AlertDialog.Builder(context);
				ad.setTitle(R.string.allert_title);
				ad.setMessage(R.string.allert_message);
				ad.setNegativeButton(R.string.allert_decline,
						new OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});
				ad.setPositiveButton(R.string.allert_accept,
						new OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Singleton.getInstance().removeNote(position);
								if (listView.getAdapter() instanceof BaseAdapter) {
									((BaseAdapter) listView.getAdapter())
											.notifyDataSetChanged();
								}

							}
						});
				ad.setCancelable(false);
				ad.show();
				return false;
			}
		};
		listView.setOnItemClickListener(listAction);
		listView.setOnItemLongClickListener(listItemLongAction);
		return view;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		if (listView.getAdapter() instanceof BaseAdapter) {
			((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
		}
		super.onResume();
	}

}
