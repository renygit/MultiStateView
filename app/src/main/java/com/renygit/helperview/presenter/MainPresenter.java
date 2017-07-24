package com.renygit.helperview.presenter;

import com.renygit.helperview.entity.Bean;
import com.renygit.helperview.presenter.vm.MainViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/7/24.
 */

public class MainPresenter {

    private MainViewModel viewModel;

    public void setViewModel(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void loadData(boolean isRefresh){
        List<Bean> beanList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            beanList.add(new Bean(0, "标题"+i, "副标题"+i));
        }

        viewModel.setData(beanList, isRefresh);

    }

}
