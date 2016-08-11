package com.haibao.store.myapplication.hybrid;

import com.haibao.store.myapplication.hybrid.imp.CustomHandler;
import com.haibao.store.myapplication.hybrid.imp.UrlHnadler;
import com.haibao.store.myapplication.ui.Hybrid.WebActivity;

/**
 *   HybridHandler 对象工厂类
 */

public class HybridHandlerManager {
    private WebActivity activity;

    public HybridHandlerManager(WebActivity activity) {
        this.activity = activity;
    }

    public HybridHandler createHybridHandler(String str) {
        // 先从 集合中取 如果没有去创建对象
        HybridHandler mHybridHandler = activity.getmHybridHandlerMap().get(str);
        if (mHybridHandler != null) {
            return mHybridHandler;
        }

        //创建 url处理对象
        if (str.equals(HybridConstans.URL_TASK)) {
            UrlHnadler mUrlHnadler = new UrlHnadler();
            activity.addHybridHandler(mUrlHnadler.getHandlerName(),mUrlHnadler);
            return mUrlHnadler;
        }
        //创建 自定义消息处理对象
        if (str.equals(HybridConstans.URL_TASK)) {
            CustomHandler mCustomHandler = new CustomHandler(activity);
            activity.addHybridHandler(mCustomHandler.getHandlerName(),mCustomHandler);
            return mCustomHandler;
        }

        return null;
    }




}
