package com.haibao.store.myapplication.ui.Mime.LoginPage;

import com.haibao.store.myapplication.RequestParamete.LoginParams;
import com.haibao.store.myapplication.api.SimpleMyCallBack;
import com.haibao.store.myapplication.base.BaseCommonPresenter;
import com.haibao.store.myapplication.reponse.HttpExceptionBean;
import com.haibao.store.myapplication.reponse.Login;
import com.haibao.store.myapplication.utils.ToastUtils;

import rx.Subscription;

/**
 * Created by baixiaokang on 16/4/29.
 */
public class LoginPresenter extends BaseCommonPresenter<LoginContract.View> implements LoginContract.Presenter{

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void login() {
        LoginParams mLoginParams = new LoginParams("18576400302", "123456a");
        Subscription subscription =  mApiWrapper.getUerInfo(mLoginParams)
                .subscribe(newMySubscriber(new SimpleMyCallBack<Login>() {
                    // 这个方法根据需要重写 之前已经toast了，如果toast了还要做其他的事情，就重写这个方法
                    @Override
                    public void onError(HttpExceptionBean mHttpExceptionBean) {
                        super.onError(mHttpExceptionBean);
                        ToastUtils.showShort("yoxin");
                    }
                    @Override
                    public void onNext(Login mLogin) {
                        ToastUtils.showShort("登录成功"+mLogin.toString());
                        view.loginSuccess();
                    }
                }));
        mCompositeSubscription.add(subscription);
    }
}
