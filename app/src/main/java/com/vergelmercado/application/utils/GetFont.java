package com.vergelmercado.application.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.FragmentActivity;

/**
 * Created by vergel.mercado on 6/17/2015.
 */
public class GetFont {


    public static Typeface normalfont;
    public static Typeface boldfont;
    Context c;

    public GetFont(Context _c) {
        this.c = _c;
    }

    public static int GetFontSize(FragmentActivity activity){

        int FontDIP = 0;

        if (Build.VERSION.SDK_INT >= 19) {
            FontDIP = 16;
        } else {
            FontDIP = (int) (12 * activity.getResources()
                    .getDisplayMetrics().density + 0.5f);
        }
        return FontDIP;
    }


    public static Typeface NormalFont(Context c) {

        normalfont = Typeface.createFromAsset(c.getAssets(),
                "fonts/HelveticaNeue.ttf");

        return normalfont;
    }

    public static Typeface BoldFont(Context c) {

        boldfont = Typeface.createFromAsset(c.getAssets(),
                "fonts/HelveticaNeue.ttf");

        return boldfont;
    }

}
