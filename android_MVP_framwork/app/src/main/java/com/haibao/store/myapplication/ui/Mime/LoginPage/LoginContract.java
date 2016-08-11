package com.haibao.store.myapplication.ui.Mime.LoginPage;

import com.haibao.store.myapplication.base.BasePresenter;
import com.haibao.store.myapplication.base.BaseView;

/**
 * Created by baixiaokang on 16/4/29.
 */
public interface LoginContract {
    interface View extends BaseView {
        void loginSuccess();
    }

    interface Presenter extends BasePresenter {
        void login();
    }
}
