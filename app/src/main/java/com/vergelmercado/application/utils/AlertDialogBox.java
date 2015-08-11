package com.vergelmercado.application.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v4.app.FragmentActivity;

/**
 * Created by vergel.mercado on 6/17/2015.
 */
public class AlertDialogBox  {

    public static void AlertMe(FragmentActivity activity, String message){ // for fragment use
        AlertDialog.Builder a = new AlertDialog.Builder(activity);
        a.setMessage(message);
        a.setPositiveButton("OK",null);
        a.create().show();
    }

    public static void AlertLogin(Activity activity, String message){ // for normal activity use
        AlertDialog.Builder a = new AlertDialog.Builder(activity);
        a.setMessage(message);
        a.setPositiveButton("OK",null);
        a.create().show();
    }
}
