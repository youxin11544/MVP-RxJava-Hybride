package com.haibao.store.myapplication.reponse;

import java.io.Serializable;

public class Login  implements Serializable {
    private String user_id;
    private String token;
    private int ttl;
    private String continue_url;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getContinue_url() {
        return continue_url;
    }

    public void setContinue_url(String continue_url) {
        this.continue_url = continue_url;
    }

    @Override
    public String toString() {
        return "Login{" +
                "user_id='" + user_id + '\'' +
                ", token='" + token + '\'' +
                ", ttl=" + ttl +
                ", continue_url='" + continue_url + '\'' +
                '}';
    }
}
