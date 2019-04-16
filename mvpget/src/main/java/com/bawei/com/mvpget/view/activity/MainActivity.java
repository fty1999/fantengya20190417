package com.bawei.com.mvpget.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.com.mvpget.R;
import com.bawei.com.mvpget.model.ShopBean;
import com.bawei.com.mvpget.presenter.MainPresenter;
import com.bawei.com.mvpget.view.adapter.ShopAdapter;
import com.bawei.com.mvpget.view.interfaces.IMainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {

    private RecyclerView recyclerView;
    private ShopAdapter shopAdapter;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);
        shopAdapter = new ShopAdapter(this);
        recyclerView.setAdapter(shopAdapter);
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
        mainPresenter.LoadNetDataNet();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void CallBackSuccess(ShopBean shopBean) {
        List<ShopBean.ResultBean> data = shopBean.getResult();
        shopAdapter.setData(data);
    }

    @Override
    public void CallBackFail(String errMsg) {

    }
}
