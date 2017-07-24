package com.renygit.helperview.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.renygit.helperview.R;
import com.renygit.helperview.presenter.MainPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by reny on 2017/1/5.
 */

public class BindingEvent {

    @BindingAdapter("adapter")
    public static void setAdapter(final RecyclerView rv, RecyclerView.Adapter adapter){
        if(null != adapter) {
            rv.setAdapter(adapter);
        }
    }
    @BindingAdapter("layoutManager")
    public static void setLayoutManager(final RecyclerView rv, RecyclerView.LayoutManager layoutManager){
        if(null == layoutManager)layoutManager = new LinearLayoutManager(rv.getContext());
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
    }

    @BindingAdapter("presenter")
    public static void setRefreshPresenter(SmartRefreshLayout srl, final MainPresenter presenter){
        srl.setEnableAutoLoadmore(true);//开启自动加载功能（非必须）
        srl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                ((View) refreshlayout).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.loadData(true);
                        refreshlayout.finishRefresh();
                    }
                }, 2000);
            }
        });
        srl.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                presenter.loadData(false);
                ((View) refreshlayout).postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        refreshlayout.finishLoadmore();
                        /*if (mAdapter.getItemCount() > 60) {
                            Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                            refreshlayout.setLoadmoreFinished(true);//将不会再次触发加载更多事件
                        }*/
                    }
                }, 2000);
            }
        });

        //触发自动刷新
        //srl.autoRefresh();
    }

}
