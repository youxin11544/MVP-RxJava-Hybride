package com.haibao.store.myapplication.hybrid;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.haibao.store.myapplication.ui.Hybrid.WebActivity;

/**
 * Created by anzhuo002 on 2016/6/28.
 */

public class HybridChromeClient extends WebChromeClient {
    private WebActivity act;
    public HybridChromeClient(WebActivity act) {
        this.act = act;
    }
    @Override
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);
    }

    @Override
    public void onProgressChanged(final WebView view, int newProgress) {
        //与精度相关的业务逻辑可以在这里做
        super.onProgressChanged(view, newProgress);
    }




















}
