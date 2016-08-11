package com.haibao.store.myapplication.reponse;

/**
 * Created by anzhuo002 on 2016/7/5.
 */

public class HttpExceptionBean {

    /**
     * code : AccountNotExist
     * message : 账户名不存在
     * body :
     */

    private String code;
    private String message;
    private String body;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
