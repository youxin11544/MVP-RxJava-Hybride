package com.haibao.store.myapplication.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;


public class DialogLoading extends Dialog {

    private TextView loadingLabel;

    public DialogLoading(Context context) {
        super(context);

    }

    public void setDialogLabel(String label) {
        loadingLabel.setText(label);
    }

}
