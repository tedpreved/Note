package com.note.app.UI.Main;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.note.app.R;
import com.note.app.UI.Room.ActivityRoom;

/**
 * Created by Home on 3/29/14.
 */

public class Fragment_Login extends Fragment {

    private static String TAG_FOR_LOGIN = "Login";
    private static String TAG_FOR_PASS = "Password";


    EditText etLogin, etPassword;
    static Button btnLogin;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // mBufferLogin=savedInstanceState.getChar(TAG_FOR_LOGIN);
        }


    }


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
               // Bundle params = new Bundle();
               // params.putString("LOGIN", etLogin.getText().toString());
               // params.putString("PASSWORD", etPassword.getText().toString());
               // Toast.makeText(getActivity(), "restart loader", Toast.LENGTH_SHORT).show();

                executeLoginLoader(etLogin.getText().toString(), etPassword.getText().toString());

            }
        };

        btnLogin.setOnClickListener(clickListener);
        return view;
    }

    public static class LoginRequest {
        String login;
    }

    public static class LoginResponse {
        String status;
    }

    public interface LoadingHandler<T> {
        void onStartLoading();
        void onStopLoading();
        void onLoadingResult(T result);
    }





        private void initLoginLoader() {
            final Loader<?> loader = getLoaderManager().getLoader(R.id.loader_login);
            if(loader != null && loader.isStarted()) {
                mLoginLoadingHandler.onStartLoading();
                getLoaderManager().initLoader(R.id.loader_login, null, mLoginLoaderCallback);
            } else {
                mLoginLoadingHandler.onStopLoading();
            }
        }

        private void executeLoginLoader(String login, String password) {
            mLoginLoadingHandler.onStartLoading();
            final Bundle args = new Bundle();
            args.putString(ARG_LOGIN, login);
            args.putString(ARG_PASSWORD, password);
            getLoaderManager().restartLoader(R.id.loader_login, args, mLoginLoaderCallback);
        }




        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Log.d("test", "PlaceholderFragment.onViewCreated");
            super.onViewCreated(view, savedInstanceState);

            // init loaders
            initLoginLoader();
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            Log.d("test", "PlaceholderFragment.onSaveInstanceState");
            super.onSaveInstanceState(outState);
        }



        @Override
        public void onDestroy() {
            Log.d("test", "PlaceholderFragment.onDestroy");
            super.onDestroy();
        }

        @Override
        public void onResume() {
            Log.d("test", "PlaceholderFragment.onResume");
            super.onResume();
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.d("test", "PlaceholderFragment.onPause");
        }

        // loading handler

        private final LoadingHandler<LoginResponse> mLoginLoadingHandler = new LoadingHandler<LoginResponse>() {
            @Override
            public void onStartLoading() {
                btnLogin.setEnabled(false);
            }

            @Override
            public void onStopLoading() {
                btnLogin.setEnabled(true);
            }

            @Override
            public void onLoadingResult(LoginResponse result) {
                Toast.makeText(getActivity(), result.status, Toast.LENGTH_SHORT).show();
               // if(result.status)
                startActivity(new Intent(getActivity(),ActivityRoom.class));
            }
        };

        // loader callback

        private final String ARG_LOGIN = "login";
        private final String ARG_PASSWORD = "password";

        private final LoaderManager.LoaderCallbacks<LoginResponse> mLoginLoaderCallback = new LoaderManager.LoaderCallbacks<LoginResponse>() {
            @Override
            public Loader<LoginResponse> onCreateLoader(int id, Bundle args) {
                Log.d("test", String.format("LoaderCallbacks.onCreateLoader %d, %s", id, args));
                switch (id) {
                    case R.id.loader_login: {
                        String login = args.getString(ARG_LOGIN);
                        String pass = args.getString(ARG_PASSWORD);
                        return new LoginLoader(getActivity(), login ,pass);
                    }
                }
                throw new RuntimeException("logic mistake");
            }

            @Override
            public void onLoadFinished(Loader<LoginResponse> loader, LoginResponse data) {
                Log.d("test", String.format("LoaderCallbacks.onLoadFinished %d, %s", loader.getId(), data));
                switch(loader.getId()) {
                    case R.id.loader_login: {
                        mLoginLoadingHandler.onStopLoading();
                        mLoginLoadingHandler.onLoadingResult(data);
                        getLoaderManager().destroyLoader(loader.getId());
                        return;
                    }
                }
                throw new RuntimeException("logic mistake");
            }

            @Override
            public void onLoaderReset(Loader<LoginResponse> loader) {
                Log.d("test", String.format("LoaderCallbacks.onLoaderReset"));
                switch(loader.getId()) {
                    case R.id.loader_login: {
                        mLoginLoadingHandler.onStopLoading();
                        return;
                    }
                }
                throw new RuntimeException("logic mistake");
            }
        };

        // login loader

        public static class LoginLoader extends AsyncTaskLoader<LoginResponse> {

            public LoginResponse mResponse;

            private String mLogin;
            private String mPassword;

            public LoginLoader(Context context, String login, String pass) {
                super(context);
                mLogin = login;
                mPassword  = pass;
            }

            @Override
            public LoginResponse loadInBackground() {
                Log.d("test", String.format("LoginLoader.loadInBackground"));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(isReset()) {
                    return null;
                } else {
                    mResponse = new LoginResponse();
                    mResponse.status = mLogin;
                    return mResponse;
                }
            }

            @Override
            protected void onStartLoading() {
                Log.d("test", String.format("LoginLoader.onStartLoading"));
                super.onStartLoading();
                if(mResponse == null) {
                    forceLoad();
                } else {
                    deliverResult(mResponse);
                }
            }

            @Override
            protected void onStopLoading() {
                Log.d("test", String.format("LoginLoader.onStopLoading"));
                super.onStopLoading();
            }

            @Override
            protected void onReset() {
                Log.d("test", String.format("LoginLoader.onReset"));
                super.onReset();
                mResponse = null;
            }
        }







}
