package com.renygit.helperview.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.renygit.helperview.R;
import com.renygit.helperview.databinding.ActivityMainBinding;
import com.renygit.helperview.presenter.MainPresenter;
import com.renygit.helperview.presenter.vm.MainViewModel;
import com.renygit.multistateview.MultiStateView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private MainPresenter presenter;
    private MainViewModel viewModel;

    //int rand = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        presenter = new MainPresenter();
        viewModel = new MainViewModel();

        binding.setPresenter(presenter);
        binding.setViewModel(viewModel);

        presenter.setViewModel(viewModel);

        binding.msv.showContent();

        binding.msv.setOnRetryListener(new MultiStateView.OnRetryListener() {
            @Override
            public void onRetry() {
                Log.e("onRetry", "onRetry.......");
            }
        });

        presenter.loadData(true);





        /*CountDownTimer cdt = new CountDownTimer(1000000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(rand == 0){
                    binding.msv.showContent();
                }else if(rand == 1){
                    binding.msv.showLoading();
                }
                else if(rand == 2){
                    binding.msv.showError();
                }
                else if(rand == 3){
                    binding.msv.showNoNetwork();
                }
                else if(rand == 4){
                    binding.msv.showEmpty();
                }
                rand = (rand + 1) % 5;
            }
            @Override
            public void onFinish() {

            }
        };

        cdt.start();*/
    }
}
