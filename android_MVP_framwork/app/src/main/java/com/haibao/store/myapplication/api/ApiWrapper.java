package com.haibao.store.myapplication.api;


import com.haibao.store.myapplication.RequestParamete.LoginParams;
import com.haibao.store.myapplication.reponse.Login;

import rx.Observable;

/**
 *  Api类的包装
 */
public class ApiWrapper extends Api {

    public Observable<Login> getUerInfo(LoginParams mLoginParams) {
        return applySchedulers(getService().getPersonalInfo(mLoginParams));
    }


}
