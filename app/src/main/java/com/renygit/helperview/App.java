package com.renygit.helperview;

import android.app.Application;
import android.content.Context;

import com.renygit.multistateview.MultiStateConfig;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

/**
 * Created by admin on 2017/7/21.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MultiStateConfig.getInstance().setConfig(
                new MultiStateConfig.Build()
                        .setTipEmpty("没有相关数据，点击重试")
                        .setTipError("加载失败，点击重试")
                        .setTipNoNetwork("没有网络，点击重试")
                        .setIndicatorName("BallSpinFadeLoaderIndicator")
                        .setIndicatorColor(R.color.colorAccent)
        );


        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //指定Header
                return new MaterialHeader(context);
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定Footer
                return new BallPulseFooter(context);
            }
        });
    }
}
