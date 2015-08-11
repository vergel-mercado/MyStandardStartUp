package com.vergelmercado.application.webservices;

import android.content.Context;
import android.os.AsyncTask;


import com.vergelmercado.application.interfaces.ExecuteAsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by vergel.mercado on 6/15/2015.
 */
@SuppressWarnings("ALL")
public class CallHttpPost extends AsyncTask<String, String, String> {

    Context c;
    List<NameValuePair> parameters;
    String url,title;
    public ExecuteAsyncTask listener;
    boolean error = false;


    public CallHttpPost(Context c,ExecuteAsyncTask listener, List<NameValuePair> parameters,String url, String title){
        this.c = c;
        this.parameters = parameters;
        this.url = url;
        this.listener = listener;
        this.title = title;
    }

    @Override
    protected String doInBackground(String... params) {

        String result = "";
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = null;
        try {
                HttpPost post = new HttpPost(url);
                if (parameters != null) {
                    post.setEntity(new UrlEncodedFormEntity(parameters));
                }
                response = client.execute(post);
                InputStream content = response.getEntity().getContent();

                BufferedReader buffer = new BufferedReader(
                        new InputStreamReader(content));

                String s = "";

                while ((s = buffer.readLine()) != null) {
                    result += s;
                }
            error= false;

        } catch (IOException ex) {
            ex.printStackTrace();
            error = true;
        }

        return result;
    }

    @Override
    protected  void onPostExecute(String result){
        super.onPostExecute(result);
        listener.getJsonResult(result,title,error, null);
    }
}
