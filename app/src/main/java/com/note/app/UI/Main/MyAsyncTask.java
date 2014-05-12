package com.note.app.UI.Main;

import android.os.AsyncTask;

import com.note.app.Data.Singleton;
import com.note.app.Data.UserExceptions;
import com.note.app.LoadingInterfase;
import com.note.app.RequetEnter;

/**
 * Created by student on 5/12/14.
 */
public class MyAsyncTask extends AsyncTask<RequetEnter,Void,ResponseLogin> {

    public LoadingInterfase loadingInterfase;


    @Override
    protected ResponseLogin doInBackground(RequetEnter... params) {
        try {
            Singleton.getInstance().login(params[0].getLogin(),params[0].getPassword());
        } catch (UserExceptions e){
            ResponseLogin responseLogin=new ResponseLogin(false, e.getError());
            return responseLogin;
            }
        return new ResponseLogin(true,null);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loadingInterfase.setViewIsLoading(true);
    }

    @Override
    protected void onCancelled(ResponseLogin responseLogin) {
        super.onCancelled(responseLogin);
        loadingInterfase.setViewIsLoading(false);
    }

    @Override
    protected void onPostExecute(ResponseLogin responseLogin) {
        super.onPostExecute(responseLogin);
        loadingInterfase.setViewIsLoading(false);
    }
}
