package com.renygit.helperview.presenter.itempresenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.github.markzhai.recyclerview.BaseViewAdapter;
import com.renygit.helperview.entity.Bean;

/**
 * Created by admin on 2017/7/24.
 */

public class MainItemPresenter implements BaseViewAdapter.Presenter{

    private Context context;

    public MainItemPresenter(Context context){
        this.context = context;
    }

    public void onItemClick(Bean bean){
        Log.e("bean", bean.getTitle());
        Toast.makeText(context, bean.getTitle(), Toast.LENGTH_SHORT).show();
    }

}
