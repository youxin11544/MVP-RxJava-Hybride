package com.haibao.store.myapplication.HybridModer;


public class AlertMessage extends BaseHyrid{
    private String cancel_callback;
    private String cancel_title;
    private String confirm_callback;
    private String confirm_title;
    private String content;
    private String title;

    public String getCancel_callback() {
        return cancel_callback;
    }

    public void setCancel_callback(String cancel_callback) {
        this.cancel_callback = cancel_callback;
    }

    public String getCancel_title() {
        return cancel_title;
    }

    public void setCancel_title(String cancel_title) {
        this.cancel_title = cancel_title;
    }

    public String getConfirm_callback() {
        return confirm_callback;
    }

    public void setConfirm_callback(String confirm_callback) {
        this.confirm_callback = confirm_callback;
    }

    public String getConfirm_title() {
        return confirm_title;
    }

    public void setConfirm_title(String confirm_title) {
        this.confirm_title = confirm_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
