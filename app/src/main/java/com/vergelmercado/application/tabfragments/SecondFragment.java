package com.vergelmercado.application.tabfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by vergel.mercado on 7/24/2015.
 */
public class SecondFragment extends Fragment {

    public static  final SecondFragment newInstance(String title){
        SecondFragment bb = new SecondFragment();

        Bundle b = new Bundle();
        b.putString("bString", title);
        bb.setArguments(b);

        return bb;
    }

}
