package com.haibao.store.myapplication.widget.dialog;

/**
 * dialog的管理类 门面模式
 */

public class DialogManager {
	private static DialogManager instance;
	private DialogManager(){
	}  
	public static  DialogManager  getInstance(){
		if(instance ==null){
			instance = new DialogManager();
		}
		return instance;
	}
	/**
	 *  show 分享的对话框
     */
//	public static Dialog showShareDialog(Context context,ShareDialog.ShareInterface mShareInterface) {
//		ShareDialog mShareDialog = new ShareDialog(context,R.style.BaseDialogTheme,mShareInterface);
//		mShareDialog.show();
//		return mShareDialog;
//	}

	/**
	 * 显示 AlertMessage的对话框
     */
//	public static Dialog showAlertDialog(Context context, AlertMessage mAlertMessage, AlertDialog.AlertButtonClick mAlertButtonClick) {
//		AlertDialog mAlertDialog = new AlertDialog(context,R.style.BaseDialogTheme,mAlertMessage,mAlertButtonClick);
//		mAlertDialog.show();
//		return mAlertDialog;
//	}



}
