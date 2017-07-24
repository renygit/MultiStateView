package com.renygit.multistateview;

/**
 * Created by admin on 2017/6/29.
 */

public class MultiStateConfig {

    private MultiStateConfig(){}

    private static class SingletonHolder {
        private static final MultiStateConfig INSTANCE = new MultiStateConfig.Build().build();
    }

    public static MultiStateConfig getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private String indicatorName;
    private int indicatorColor;
    private int bgColor;
    private int textColor;
    private String tipError;
    private String tipNoNetwork;
    private String tipEmpty;
    private int imgError;
    private int imgNoNetwork;
    private int imgEmpty;


    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public int getIndicatorColor() {
        return indicatorColor;
    }

    public void setIndicatorColor(int indicatorColor) {
        this.indicatorColor = indicatorColor;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public String getTipError() {
        return tipError;
    }

    public void setTipError(String tipError) {
        this.tipError = tipError;
    }

    public String getTipNoNetwork() {
        return tipNoNetwork;
    }

    public void setTipNoNetwork(String tipNoNetwork) {
        this.tipNoNetwork = tipNoNetwork;
    }

    public String getTipEmpty() {
        return tipEmpty;
    }

    public void setTipEmpty(String tipEmpty) {
        this.tipEmpty = tipEmpty;
    }

    public int getImgError() {
        return imgError;
    }

    public void setImgError(int imgError) {
        this.imgError = imgError;
    }

    public int getImgNoNetwork() {
        return imgNoNetwork;
    }

    public void setImgNoNetwork(int imgNoNetwork) {
        this.imgNoNetwork = imgNoNetwork;
    }

    public int getImgEmpty() {
        return imgEmpty;
    }

    public void setImgEmpty(int imgEmpty) {
        this.imgEmpty = imgEmpty;
    }

    public MultiStateConfig(Build build) {
        setConfig(build);
    }

    public void setConfig(Build build) {
        this.indicatorName = build.indicatorName;
        this.indicatorColor = build.indicatorColor;
        this.bgColor = build.bgColor;
        this.textColor = build.textColor;
        this.tipError = build.tipError;
        this.tipNoNetwork = build.tipNoNetwork;
        this.tipEmpty = build.tipEmpty;
        this.imgError = build.imgError;
        this.imgNoNetwork = build.imgNoNetwork;
        this.imgEmpty = build.imgEmpty;
    }

    public static class Build{
        //赋上默认值
        //https://github.com/81813780/AVLoadingIndicatorView
        private String indicatorName = "BallSpinFadeLoaderIndicator";
        private int indicatorColor = R.color.tip_color;
        private int bgColor = android.R.color.transparent;
        private int textColor = R.color.tip_color;
        private String tipError = "加载失败，点击重试";
        private String tipNoNetwork = "没有网络，点击重试";
        private String tipEmpty = "没有相关数据，点击重试";
        private int imgError = R.mipmap.ic_error;
        private int imgNoNetwork = R.mipmap.ic_no_network;
        private int imgEmpty = R.mipmap.ic_empty;

        public Build setIndicatorName(String indicatorName) {
            this.indicatorName = indicatorName;
            return this;
        }

        public Build setIndicatorColor(int indicatorColor) {
            this.indicatorColor = indicatorColor;
            return this;
        }

        public Build setBgColor(int bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public Build setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Build setTipError(String tipError) {
            this.tipError = tipError;
            return this;
        }

        public Build setTipNoNetwork(String tipNoNetwork) {
            this.tipNoNetwork = tipNoNetwork;
            return this;
        }

        public Build setTipEmpty(String tipEmpty) {
            this.tipEmpty = tipEmpty;
            return this;
        }

        public Build setImgError(int imgError) {
            this.imgError = imgError;
            return this;
        }

        public Build setImgNoNetwork(int imgNoNetwork) {
            this.imgNoNetwork = imgNoNetwork;
            return this;
        }

        public Build setImgEmpty(int imgEmpty) {
            this.imgEmpty = imgEmpty;
            return this;
        }

        public MultiStateConfig build(){
            return new MultiStateConfig(this);
        }
    }

}
