# MultiStateView
推荐一下我的一个库https://github.com/renygit/MVPLib （一个简单好用的框架，代码量很少，一会儿就看完了，belive me） 其中也用到了当前库，因为使用了databinding，所以有看不懂的请自行百度。这么简单的库，如果您要给个star我也不嫌弃→_→。

引用
===========================
```Java
maven { url "https://jitpack.io" }
```
```Java
dependencies {
	compile 'com.github.renygit:MultiStateView:0.0.2' //包含 compile 'com.wang.avi:library:2.1.3'//loading库
}
```

使用
===========================
```xml
<com.renygit.multistateview.MultiStateView
     android:id="@+id/msv"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     app:msv_indicatorName="BallSpinFadeLoaderIndicator"
     app:msv_xxx="xxx"
     app:msv_xxx="这里可以设置各种状态属性">
            <com.scwang.smartrefresh.layout.SmartRefreshLayout
                android:id="@+id/srl"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:presenter="@{presenter}">//（databinding:demo中如果这里看不懂，请跳过,可以不用设置这个）

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
	    .setImgError(R.mipmap.ic_error)
	    .setxxx(其它属性)
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

说明
=================================
msv_indicatorName: loading的样式，使用的库https://github.com/81813780/AVLoadingIndicatorView <br>
msv_indicatorColor: loading的颜色 <br>
msv_bgColor: 状态View的背景色 <br>
msv_textColor: 提示文字的颜色 <br>
msv_tipError: 如果发生加载错误时的提示文字 <br>
msv_tipNoNetwork: 如果发生网络错误时的提示文字 <br>
msv_tipEmpty: 如果数据为空时的提示文字 <br>
msv_imgError: 如果发生加载错误时的提示图片 <br>
msv_imgNoNetwork: 如果发生网络错误时的提示图片 <br>
msv_imgEmpty: 如果数据为空时的提示图片 <br>


设置状态
=================================
```Java
MultiStateView msv = (MultiStateView)findViewById(R.id.msv);
msv.showLoading();
msv.showError();
msv.showNoNetwork();
msv.showEmpty();
msv.showContent();

//也可以这样
msv.showViewByStatus(MultiStateView.STATE_LOADING);
msv.showViewByStatus(MultiStateView.STATE_ERROR);
msv.showViewByStatus(MultiStateView.STATE_NO_NETWORK);
msv.showViewByStatus(MultiStateView.STATE_EMPTY);
msv.showViewByStatus(MultiStateView.STATE_CONTENT);


//点击重试  非loading状态都具备 点击全屏 重试
msv.setOnRetryListener(new MultiStateView.OnRetryListener() {
            @Override
            public void onRetry() {
                if(msv.getViewState() == MultiStateView.STATE_ERROR){//如果非loading状态点击都是一样的逻辑就不用判断了
			doSomething();
		}
            }
        });
 ```

如果想java代码设置请自行修改源码，我没用到过，xml中没有设置局部属性，会自动使用全局属性，没有设置全局属性，会自动使用默认属性，所以，随便想怎么写都行。
 
