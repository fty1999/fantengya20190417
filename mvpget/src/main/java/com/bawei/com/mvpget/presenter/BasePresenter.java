package com.bawei.com.mvpget.presenter;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/16 20:28:07
 * @Description:
 */
public class BasePresenter <V>{
    public V view;

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }
    public void detachView(){
        this.view = null;
    }
}
