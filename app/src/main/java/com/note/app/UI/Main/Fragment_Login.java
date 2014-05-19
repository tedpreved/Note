package com.note.app.UI.Main;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.note.app.Data.Singleton;
import com.note.app.Data.UserExceptions;
import com.note.app.R;

/**
 * Created by Home on 3/29/14.
 */

public class Fragment_Login extends Fragment {

    private static String TAG_FOR_LOGIN = "Login";
    private static String TAG_FOR_PASS = "Password";


    EditText etLogin, etPassword;
    Button btnLogin;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // mBufferLogin=savedInstanceState.getChar(TAG_FOR_LOGIN);
        }

        Loader loader = getLoaderManager().getLoader(R.id.loader_login);
        if(loader == null || (loader != null && loader.isStarted())) {
            getLoaderManager().initLoader(R.id.loader_login, null, mLoaderCallback);
         }
    }

    private final LoaderManager.LoaderCallbacks<ResponseLogin> mLoaderCallback = new LoaderManager.LoaderCallbacks<ResponseLogin>() {

        @Override
        public Loader<ResponseLogin> onCreateLoader(int id, Bundle args) {
            LoginLoader loader = new LoginLoader(getActivity());
            if(args != null) {
                String login = args.getString("LOGIN");
                String pass = args.getString("PASSWORD");
                loader.setLoginAndPasswrod(login, pass);
            }
            return loader;
        }

        @Override
        public void onLoadFinished(Loader<ResponseLogin> loader, ResponseLogin data) {
            if (data.isSuccess()) {
                Toast.makeText(getActivity(), ((LoginLoader) loader).mLogin, Toast.LENGTH_SHORT).show();
                // startActivity(new Intent(getActivity(), ActivityRoom.class));
            } else {
                Toast.makeText(getActivity(), data.getError().toString(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onLoaderReset(Loader<ResponseLogin> loader) {
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, null);

        etLogin = (EditText) view.findViewById(R.id.etLogin);
        etPassword = (EditText) view.findViewById(R.id.etPassword);

        btnLogin = (Button) view.findViewById(R.id.btnLogin);

        Button.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle params = new Bundle();
                params.putString("LOGIN", etLogin.getText().toString());
                params.putString("PASSWORD", etPassword.getText().toString());
                Toast.makeText(getActivity(), "restart loader", Toast.LENGTH_SHORT).show();
                getLoaderManager().restartLoader(R.id.loader_login, params, mLoaderCallback);
            }
        };

        btnLogin.setOnClickListener(clickListener);
        return view;
    }

    public static class ResponseLogin {

        public boolean Success = true;
        public UserExceptions.Error error = null;

        public ResponseLogin(boolean Ans, UserExceptions.Error stuff) {
            this.Success = Ans;
            this.error = stuff;
        }

        public UserExceptions.Error getError() {
            return error;
        }

        public boolean isSuccess() {
            return Success;
        }
    }

    public static class LoginLoader extends AsyncTaskLoader<ResponseLogin> {

        private String mLogin;
        private String mPassword;

        public void setLoginAndPasswrod(String login, String password) {
            mLogin = login;
            mPassword = password;
        }

        public LoginLoader(Context context) {
            super(context);
        }

        @Override
        public ResponseLogin loadInBackground() {
            try {
                Singleton.getInstance().login(mLogin, mPassword);
            } catch (UserExceptions e) {
                return new ResponseLogin(false, e.getError());
            }
            return new ResponseLogin(true, null);
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            if(mLogin == null || mPassword == null) {
                return;
            } else {
                forceLoad();
            }
        }
    }
}
