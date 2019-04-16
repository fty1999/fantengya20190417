package com.bawei.com.mvpget.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.com.mvpget.R;
import com.bawei.com.mvpget.model.ShopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/16 20:33:51
 * @Description:
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {

    private Context context;
    private List<ShopBean.ResultBean> list = new ArrayList<>();

    public ShopAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<ShopBean.ResultBean> mList){
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(list.get(i).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}