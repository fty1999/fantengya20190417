package com.bawei.com.mvpget.model;

import android.os.Handler;
import android.os.Message;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.com.mvpget.application.MyApp;
import com.google.gson.Gson;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/16 19:42:42
 * @Description:
 */
public class HttpVolley <T>{
    private static HttpVolley httpVolley;

    //懒汉式
    public static synchronized HttpVolley getInstance(){
        if (httpVolley == null){
            httpVolley = new HttpVolley();
        }
        return httpVolley;
    }

    //get
    private VolleyCallBack mCallBack;
    public void VolleyHttpGet(String url, final Class<T> tClass , final VolleyCallBack callBack){
        this.mCallBack = callBack;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Message message = handler.obtainMessage();
                message.what = 1;
                Gson gson = new Gson();
                T t = gson.fromJson(response,tClass);
                message.obj = t;
                handler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Message message = handler.obtainMessage();
                message.what = 0;
                message.obj = error.getMessage();
                handler.sendMessage(message);
            }
        });
        stringRequest.setTag("Get");
        MyApp.requestQueue().add(stringRequest);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                T t = (T) msg.obj;
                mCallBack.onSuccess(t);
            }else {
                String err = (String) msg.obj;
                mCallBack.onFail(err);
            }
        }
    };


    public interface VolleyCallBack<D>{
        void onSuccess(D d);
        void onFail(String error);
    }
}
