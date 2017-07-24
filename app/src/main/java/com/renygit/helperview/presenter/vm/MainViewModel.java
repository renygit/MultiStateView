package com.renygit.helperview.presenter.vm;

import android.databinding.BaseObservable;

import com.github.markzhai.recyclerview.MultiTypeAdapter;
import com.renygit.helperview.App;
import com.renygit.helperview.R;
import com.renygit.helperview.entity.Bean;
import com.renygit.helperview.presenter.itempresenter.MainItemPresenter;

import java.util.List;

/**
 * Created by admin on 2017/7/24.
 */

public class MainViewModel extends BaseObservable{


    public MultiTypeAdapter adapter = new MultiTypeAdapter(App.getContext());
    private boolean isFirst = true;

    private int TYPE_ONE = 0;


    public void setData(List<Bean> beanList, boolean isRefresh){
        if(isFirst) {
            adapter.addViewTypeToLayoutMap(TYPE_ONE, R.layout.item_bean);
            adapter.setPresenter(new MainItemPresenter(App.getContext()));
        }
        if(isRefresh){
            adapter.set(beanList, TYPE_ONE);
        }else {
            adapter.addAll(beanList, TYPE_ONE);
        }
    }



}
