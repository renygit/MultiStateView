package com.renygit.helperview.entity;

/**
 * Created by admin on 2017/7/24.
 */

public class Bean {

    private int type;
    private String title;
    private String subTitle;

    public Bean(int type, String title, String subTitle) {
        this.type = type;
        this.title = title;
        this.subTitle = subTitle;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

}
