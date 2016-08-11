package com.haibao.store.myapplication.api;


import android.database.Observable;

import com.haibao.store.myapplication.RequestParamete.LoginParams;
import com.haibao.store.myapplication.reponse.Login;


/**
 *  Api类的包装
 */
public class ApiWrapper extends Api {

    public Observable<Login> getUerInfo(LoginParams mLoginParams) {
        return applySchedulers(getService().getPersonalInfo(mLoginParams));
    }


}
