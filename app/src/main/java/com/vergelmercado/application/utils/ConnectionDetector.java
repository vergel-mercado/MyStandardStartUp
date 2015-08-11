package com.vergelmercado.application.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {

    Context c;

    public ConnectionDetector(Context _c) {
        this.c = _c;
    }

    public boolean isConnectingToInternet() {

        ConnectivityManager connection = (ConnectivityManager) c
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connection != null) {
            NetworkInfo[] info = connection.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState().equals(NetworkInfo.State.CONNECTED)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
