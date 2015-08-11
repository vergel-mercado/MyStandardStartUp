package com.vergelmercado.application.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class StoreData {

    private SharedPreferences sharedPrefs;
    private Editor sharedEditor;

    private static final String storedata = StoreData.class.getSimpleName();

    public static final String sessionId = "sessionId";
    public static final String username = "username";


    public StoreData(Context c) {
        this.sharedPrefs = c.getSharedPreferences(storedata,
                Activity.MODE_PRIVATE);
        this.sharedEditor = sharedPrefs.edit();
    }

    public String getSessionId(){
        return sharedPrefs.getString(sessionId,"");
    }

    public void setSessionId(String s){
        sharedEditor.putString(sessionId,s);
        sharedEditor.commit();
    }

    public boolean isUserLogin(){
        return sharedPrefs.getString(sessionId,"").contains(sessionId);
    }

    public boolean userLogout(){
        return sharedPrefs.edit().clear().commit();
    }


    public String getUsername(){
        return sharedPrefs.getString(username, "");
    }

    public void setUsername(String s){
        sharedEditor.putString(username,s);
        sharedEditor.commit();
    }


	/*
	 * 
	 * END
	 */

}
