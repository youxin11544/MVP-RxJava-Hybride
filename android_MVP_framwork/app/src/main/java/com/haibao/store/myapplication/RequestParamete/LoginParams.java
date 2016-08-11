package com.haibao.store.myapplication.RequestParamete;

/**
 * 登录请求参数
 * Created by Android on 2015-12-23 023.
 */
public class LoginParams  {

    public String account;
    public String password;

    public LoginParams(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
