package com.bawei.com.mvpget.view.interfaces;

import com.bawei.com.mvpget.model.ShopBean;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/16 20:29:04
 * @Description:
 */
public interface IBaseView {
    void CallBackSuccess(ShopBean shopBean);
    void CallBackFail(String errMsg);
}
