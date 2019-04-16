package com.bawei.com.mvpget.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/16 20:02:02
 * @Description:
 */
public class MyApp extends Application {

    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue requestQueue(){
        return queue;
    }
}
