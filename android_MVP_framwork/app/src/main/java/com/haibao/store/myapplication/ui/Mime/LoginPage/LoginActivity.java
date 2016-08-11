package com.haibao.store.myapplication.ui.Mime.LoginPage;

import android.os.Bundle;
import android.view.View;

import com.haibao.store.myapplication.R;
import com.haibao.store.myapplication.base.BaseActivity;

/**
 * Created by Administrator on 2016/1/14.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test);

        // 发送请求在Acivityt中，不需要采用Acivity+frament的情况------情况1
        //初始化 api
        // initApi();


        // Acivity+frament 发送请求在fragment中，不需要采用mvp 模式的，需要始化api  ------情况2
//        initApi();
//        LoginFragment mLoginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
//        if (mLoginFragment == null) {
//            mLoginFragment = LoginFragment.newInstance();
//            addFragmentToActivity(mLoginFragment, R.id.contentFrame);
//        }


        //采用mvp 模式 在这里添加fragment 到activity 另外 创建 Presenter 不需要初始化api  ------情况3
        LoginFragment mLoginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mLoginFragment == null) {
            mLoginFragment = LoginFragment.newInstance();
            addFragmentToActivity(mLoginFragment, R.id.contentFrame);
        }
        //创建 Presenter 如果不采用mvp 就不要创建
        mLoginFragment.createPresenter(new LoginPresenter(mLoginFragment));




    }

    @Override
    public void initView() {

    }

    @Override
    public void bindEvent() {

    }

    @Override
    public void onClick(View view) {

    }
}
