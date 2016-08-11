package com.haibao.store.myapplication.widget.popwindow;

/**
 * popwindow 的管理者
 */
public class PopupWindowManager {
	private static PopupWindowManager instance;
	private PopupWindowManager(){  
	} 
	public static   PopupWindowManager getInstance(){
		if(instance == null){
			instance = new PopupWindowManager();
		}
		return instance;
	}

	/**
	 * 显示 选择类型的popwindow
	 */
//	public PopupWindow ShowTypeSelectionPopupWindow(Activity mActivity, String[] types, View parentView, int select_position, AdapterView.OnItemClickListener mOnItemClickListener){
//		TypeSelectionPopupWindow popWin = new TypeSelectionPopupWindow(mActivity, types,select_position,mOnItemClickListener);
//		popWin.showPopupWindow(parentView);
//		return popWin;
//	}
//	public PopupWindow showPicturePopupWindow(Activity mActivity, View parentView, String path){
//		PicturePopupWindow popWin = new PicturePopupWindow(mActivity);
//		popWin.setPhonePath(path);
//		popWin.showPopupWindow(parentView);
//		return popWin;
//	}




}
