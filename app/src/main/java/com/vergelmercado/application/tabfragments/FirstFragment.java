package com.vergelmercado.application.tabfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by vergel.mercado on 7/24/2015.
 */
public class FirstFragment extends Fragment {

    public static  final FirstFragment newInstance(String title){
        FirstFragment bb = new FirstFragment();

        Bundle b = new Bundle();
        b.putString("bString", title);
        bb.setArguments(b);

        return bb;
    }

}
