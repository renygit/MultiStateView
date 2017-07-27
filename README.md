# MultiStateView
源码过于简单，不想介绍
使用
===========================
```xml
<com.renygit.multistateview.MultiStateView
            android:id="@+id/msv"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:msv_indicatorName="BallSpinFadeLoaderIndicator">

            <com.scwang.smartrefresh.layout.SmartRefreshLayout
                android:id="@+id/srl"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:presenter="@{presenter}">

                <android.support.v7.widget.RecyclerView
                    android:id="@+id/rv"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:overScrollMode="never"
                    app:adapter="@{viewModel.adapter}"
                    app:layoutManager="@{null}"
                    />
            </com.scwang.smartrefresh.layout.SmartRefreshLayout>

        </com.renygit.multistateview.MultiStateView>
```

全局设置（建议在application中设置）
============================
```Java
MultiStateConfig.getInstance().setConfig(
                new MultiStateConfig.Build()
                        .setTipEmpty("没有相关数据，点击重试")
                        .setTipError("加载失败，点击重试")
                        .setTipNoNetwork("没有网络，点击重试")
                        .setIndicatorName("BallSpinFadeLoaderIndicator")
                        .setIndicatorColor(R.color.colorAccent)
        );
        
       ```
 
 可以设置的全部属性
 ============================
 ```xml
 <attr name="msv_indicatorName" format="string" />
        <attr name="msv_indicatorColor" format="color" />
        <attr name="msv_bgColor" format="color" />
        <attr name="msv_textColor" format="color" />
        <attr name="msv_tipError" format="string" />
        <attr name="msv_tipNoNetwork" format="string" />
        <attr name="msv_tipEmpty" format="string" />
        <attr name="msv_imgError" format="reference|color" />
        <attr name="msv_imgNoNetwork" format="reference|color" />
        <attr name="msv_imgEmpty" format="reference|color" />
        ```
 
 如果想java代码设置请自行修改源码，我没用到过，xml中没有设置局部属性，会自动使用全局属性，没有设置全局属性，会自动使用默认属性，所以，随便想怎么写都行。
 
