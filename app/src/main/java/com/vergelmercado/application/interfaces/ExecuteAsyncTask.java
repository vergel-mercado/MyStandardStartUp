package com.vergelmercado.application.interfaces;

import android.widget.TextView;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by vergel.mercado on 6/15/2015.
 */
public interface ExecuteAsyncTask {


    List<NameValuePair> Parameters(String title);

    void getJsonResult(String result, String title, boolean IsError, TextView txtview);

}
