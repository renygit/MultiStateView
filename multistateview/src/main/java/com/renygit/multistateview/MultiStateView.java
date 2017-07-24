package com.renygit.multistateview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by admin on 2017/7/21.
 */

public class MultiStateView extends FrameLayout {

    public static final int STATE_LOADING       = 0x00;
    public static final int STATE_ERROR         = 0x01;
    public static final int STATE_NO_NETWORK    = 0x02;
    public static final int STATE_EMPTY         = 0x03;
    public static final int STATE_CONTENT       = 0x04;

    private MultiStateConfig config;

    private String indicatorName;
    private int indicatorColor;
    private int bgColor;
    private int textColor;
    private String tipError;
    private String tipNoNetwork;
    private String tipEmpty;
    private Drawable imgError;
    private Drawable imgNoNetwork;
    private Drawable imgEmpty;


    private View stateView;
    private AVLoadingIndicatorView pb_loading;
    private View ll_tip;
    private ImageView iv_tip;
    private TextView tv_tip;

    private int mViewState = -1;

    private OnRetryListener onRetryListener;

    public void setOnRetryListener(OnRetryListener onRetryListener) {
        this.onRetryListener = onRetryListener;
    }

    public MultiStateView(@NonNull Context context) {
        this(context, null);
    }

    public MultiStateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiStateView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        config = MultiStateConfig.getInstance();

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MultiStateView);
        indicatorName = ta.getString(R.styleable.MultiStateView_msv_indicatorName);
        indicatorColor = ta.getColor(R.styleable.MultiStateView_msv_indicatorColor, ContextCompat.getColor(context, config.getIndicatorColor()));
        bgColor = ta.getColor(R.styleable.MultiStateView_msv_bgColor, ContextCompat.getColor(context, config.getBgColor()));
        textColor = ta.getColor(R.styleable.MultiStateView_msv_textColor, ContextCompat.getColor(context, config.getTextColor()));
        tipError = ta.getString(R.styleable.MultiStateView_msv_tipError);
        tipNoNetwork = ta.getString(R.styleable.MultiStateView_msv_tipNoNetwork);
        tipEmpty = ta.getString(R.styleable.MultiStateView_msv_tipEmpty);
        imgError = ta.getDrawable(R.styleable.MultiStateView_msv_imgError);
        imgNoNetwork = ta.getDrawable(R.styleable.MultiStateView_msv_imgNoNetwork);
        imgEmpty = ta.getDrawable(R.styleable.MultiStateView_msv_imgEmpty);
        ta.recycle();

        if(TextUtils.isEmpty(indicatorName)){
            indicatorName = config.getIndicatorName();
        }

        if(TextUtils.isEmpty(tipError)){
            tipError = config.getTipError();
        }

        if(TextUtils.isEmpty(tipNoNetwork)){
            tipNoNetwork = config.getTipNoNetwork();
        }

        if(TextUtils.isEmpty(tipEmpty)){
            tipEmpty = config.getTipEmpty();
        }

        if(null == imgError){
            imgError = ContextCompat.getDrawable(context, config.getImgError());
        }
        if(null == imgNoNetwork){
            imgNoNetwork = ContextCompat.getDrawable(context, config.getImgNoNetwork());
        }
        if(null == imgEmpty){
            imgEmpty = ContextCompat.getDrawable(context, config.getImgEmpty());
        }


        stateView = LayoutInflater.from(context).inflate(R.layout.view_wrapper, null);
        stateView.setOnClickListener(null);

        pb_loading = (AVLoadingIndicatorView) stateView.findViewById(R.id.pb_loading);
        ll_tip = stateView.findViewById(R.id.ll_tip);
        iv_tip = (ImageView) stateView.findViewById(R.id.iv_tip);
        tv_tip = (TextView) stateView.findViewById(R.id.tv_tip);

        stateView.setBackgroundColor(bgColor);
        pb_loading.setIndicator(indicatorName);
        pb_loading.setIndicatorColor(indicatorColor);
        tv_tip.setTextColor(textColor);

        addView(stateView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        showLoading();
    }

    //直接用MultiStateConfig.getInstance().setConfig(build); 单例的
    /*public void setConfig(MultiStateConfig.Build build){
        config.setConfig(build);
    }*/

    public int getViewState() {
        return mViewState;
    }

    public void showLoading(){
        showViewByStatus(STATE_LOADING);
    }

    public void showError(){
        showViewByStatus(STATE_ERROR);
    }

    public void showNoNetwork(){
        showViewByStatus(STATE_NO_NETWORK);
    }

    public void showEmpty(){
        showViewByStatus(STATE_EMPTY);
    }

    public void showContent(){
        showViewByStatus(STATE_CONTENT);
    }

    public void showViewByStatus(int viewState) {
        if(getViewState() == viewState){
            return;
        }
        mViewState = viewState;

        if(viewState == STATE_CONTENT){
            //显示内容
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = getChildAt(i);
                view.setVisibility(R.id.ll_state == view.getId() ? View.GONE : View.VISIBLE);
            }
        }else {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = getChildAt(i);
                view.setVisibility(R.id.ll_state == view.getId() ? View.VISIBLE : View.GONE);
            }

            pb_loading.setVisibility(viewState == STATE_LOADING ? VISIBLE : GONE);
            ll_tip.setVisibility(viewState == STATE_LOADING ? GONE : VISIBLE);

            if(viewState == STATE_LOADING){
                stateView.setOnClickListener(null);
            }else {
                stateView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(null != onRetryListener){
                            onRetryListener.onRetry();
                            showLoading();
                        }
                    }
                });
            }

            switch (viewState) {
                case STATE_ERROR:
                    if(null != imgError) {
                        iv_tip.setImageDrawable(imgError);
                    }
                    tv_tip.setText(tipError);
                    break;
                case STATE_NO_NETWORK:
                    if(null != imgNoNetwork) {
                        iv_tip.setImageDrawable(imgNoNetwork);
                    }
                    tv_tip.setText(tipNoNetwork);
                    break;
                case STATE_EMPTY:
                    if(null != imgEmpty) {
                        iv_tip.setImageDrawable(imgEmpty);
                    }
                    tv_tip.setText(tipEmpty);
                    break;
            }
        }
    }

    public interface OnRetryListener{
        void onRetry();
    }

}
