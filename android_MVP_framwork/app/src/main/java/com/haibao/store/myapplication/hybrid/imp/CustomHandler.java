package com.haibao.store.myapplication.hybrid.imp;

import com.haibao.store.myapplication.hybrid.HybridConstans;
import com.haibao.store.myapplication.hybrid.HybridHandler;
import com.haibao.store.myapplication.ui.Hybrid.WebActivity;

/**
 * Created by anzhuo002 on 2016/6/28.
 */

public class CustomHandler implements HybridHandler {
    private WebActivity activity;
//    private CustomMessage mCustomMessage;
//    private CustomDialog mDialog;

    public CustomHandler(WebActivity activity) {
        this.activity = activity;
    }

    @Override
    public String getHandlerName() {
        return HybridConstans.CUSTOM_MESSAGE_TASK;
    }

    @Override
    public boolean handerTask(WebActivity mActivity, String string) {
//        mCustomMessage = new Gson().fromJson(string, CustomMessage.class);
//        if (mCustomMessage != null) return false;
//        LayoutInflater inflater = LayoutInflater.from(activity);
//        // 判断显示哪一种 自定义对话框
//        mDialog = DialogManager.getCustomDialog(mActivity);
//        switch (mCustomMessage.getType()) {
//            case 0:
//                // 0 表示显示 loading 加载动画
//                View loading = inflater.inflate(R.layout.my_loading_dialog, null);
//                mDialog.setDialogContentView(loading);
//                mDialog.show();
//                break;
//            case 1:
//                // 1 表示显示 文字
//                View view = inflater.inflate(R.layout.show_text_dialog, null);
//                TextView textView = (TextView) view.findViewById(R.id.dialog_text);
//                textView.setText(mCustomMessage.getContent());
//                mDialog.setDialogContentView(view);
//                mDialog.show();
//                break;
//        }
        return true;
    }


}
