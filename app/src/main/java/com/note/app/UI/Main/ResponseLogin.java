package com.note.app.UI.Main;

import com.note.app.Data.UserExceptions;

/**
 * Created by student on 5/12/14.
 */
public class ResponseLogin {

    public boolean Success=true;
    public UserExceptions.Error error=null;

    public ResponseLogin(boolean Ans, UserExceptions.Error stuff){
       this.Success=Ans;
       this.error=stuff;
    }

    public UserExceptions.Error getError() {
        return error;
    }
     public boolean isSuccess(){
         return Success;
     }
}
