package com.vergelmercado.application.utils;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Created by vergel.mercado on 6/24/2015.
 */
public class ToastMe {

    public static void FragmentView(FragmentActivity activity, String msg){
        Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show();
    }

    public static void ActivityView(Activity activity, String msg){
        Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show();
    }

}
