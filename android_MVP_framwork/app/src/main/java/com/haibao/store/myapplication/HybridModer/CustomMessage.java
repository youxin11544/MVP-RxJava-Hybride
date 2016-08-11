package com.haibao.store.myapplication.HybridModer;

/**
 * Created by anzhuo002 on 2016/6/28.
 */

public class CustomMessage extends BaseHyrid{
    private String content;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
