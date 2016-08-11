package com.haibao.store.myapplication.HybridModer;

import java.io.Serializable;

/**
 * Created by anzhuo002 on 2016/6/28.
 */

public class BaseHyrid implements Serializable {
    //处理事件的名字
    public String evenName;
    //具体处理事件的内容，此字段不使用，只是打印
    public String msg;

    public String getEvenName() {
        return evenName;
    }

    public void setEvenName(String evenName) {
        this.evenName = evenName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
