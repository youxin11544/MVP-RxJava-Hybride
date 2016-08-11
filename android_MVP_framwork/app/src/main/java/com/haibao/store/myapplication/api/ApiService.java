package com.haibao.store.myapplication.api;


import com.haibao.store.myapplication.RequestParamete.LoginParams;
import com.haibao.store.myapplication.reponse.Login;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


/**
 * Created by Sunflower on 2015/11/4.
 */
public interface ApiService {


    /**
     * 获取个人信息
     */
    @POST("account/v1/login")
    Observable<Login> getPersonalInfo(@Body LoginParams mLoginParams);


}
