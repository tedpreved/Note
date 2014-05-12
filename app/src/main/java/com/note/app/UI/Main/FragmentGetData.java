package com.note.app.UI.Main;

import android.app.Fragment;

import com.note.app.LoadingInterfase;
import com.note.app.RequetEnter;

/**
 * Created by student on 5/12/14.
 */
public class FragmentGetData extends Fragment {

    MyAsyncTask myAsyncTask;

    public FragmentGetData(){
setRetainInstance(true);
    }

    public void setLoadingInterface(LoadingInterfase loadingInterface){
        if(myAsyncTask != null) {
            myAsyncTask.loadingInterfase = loadingInterface;
        }
    }

    public void Login(String login, String pass, LoadingInterfase loadingInterface){
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.loadingInterfase = loadingInterface;
        myAsyncTask.execute(new RequetEnter(login,pass));
    }

}
