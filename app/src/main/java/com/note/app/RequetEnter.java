package com.note.app;

/**
 * Created by student on 5/12/14.
 */
public class RequetEnter {

    private String mLogin;
    private String mPassword;

    public RequetEnter(String Login, String Password){
        this.mLogin=Login;
        this.mPassword=Password;
    }

    public String getLogin(){
        return this.mLogin;
    }

    public String getPassword(){
        return this.mPassword;
    }
}
