package com.ysn.test0410.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Test0410
 * 创建人：fulin
 * 创建时间：2023/4/10 22:50
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class Data {
    public List<App> getAppsList() {
        return mAppsList;
    }

    public void setAppsList(List<App> mAppsList) {
        this.mAppsList = mAppsList;
    }

    private List<App> mAppsList = new ArrayList<>();

    private static Data instance = new Data();

    private Data() {

    }

    public static Data getInstance() {
        return instance;
    }
}
