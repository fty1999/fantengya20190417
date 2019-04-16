package com.bawei.com.mvpget.presenter;

import com.bawei.com.mvpget.application.Contract;
import com.bawei.com.mvpget.model.HttpVolley;
import com.bawei.com.mvpget.model.ShopBean;
import com.bawei.com.mvpget.view.interfaces.IMainView;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/16 20:30:27
 * @Description:
 */
public class MainPresenter extends BasePresenter<IMainView<ShopBean>>{

    private final HttpVolley httpVolley;

    public MainPresenter(){
        httpVolley = HttpVolley.getInstance();
    }

    public void LoadNetDataNet(){
        httpVolley.VolleyHttpGet(Contract.LIST_URL, ShopBean.class, new HttpVolley.VolleyCallBack<ShopBean>() {

            @Override
            public void onSuccess(ShopBean shopBean) {
                getView().CallBackSuccess(shopBean);
            }

            @Override
            public void onFail(String error) {
                getView().CallBackFail(error);
            }
        });
    }
}
