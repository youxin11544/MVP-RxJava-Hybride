/*
    ShengDao Android Client, ActivityPageManager
    Copyright (c) 2014 ShengDao Tech Company Limited
 */

package com.haibao.store.myapplication.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.Stack;

public class ActivityPageManager {

	private static Stack<Activity> activityStack;
	private static ActivityPageManager instance;
	
	/**
	 * constructor
	 */
	private ActivityPageManager() {
		
	}

	/**
	 * get the AppManager instance, the AppManager is singleton.
	 */
	public static ActivityPageManager getInstance() {
		if (instance == null) {
			instance = new ActivityPageManager();
		}
		return instance;
	}

	/**
	 * add Activity to Stack
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	
	/**
	 *  remove Activity from Stack
	 */
	public void removeActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.remove(activity);
	}
	
	/**
	 * get current activity from Stack
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	public void finishActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	public void finishAllActivity() {
		for (Activity activity : activityStack) {
			if (null != activity) {
				activity.finish();
			}
		}
		activityStack.clear();
		//杀死该应用进程
//		android.os.Process.killProcess(android.os.Process.myPid());

	}

	public static void unbindReferences(View view) {
		try {
			if (view != null) {
				view.destroyDrawingCache();
				unbindViewReferences(view);
				if (view instanceof ViewGroup){
					unbindViewGroupReferences((ViewGroup) view);
				}
			}
		} catch (Throwable e) {

		}
	}

	private static void unbindViewGroupReferences(ViewGroup viewGroup) {
		int nrOfChildren = viewGroup.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = viewGroup.getChildAt(i);
			unbindViewReferences(view);
			if (view instanceof ViewGroup)
				unbindViewGroupReferences((ViewGroup) view);
		}
		try {
			viewGroup.removeAllViews();
		} catch (Throwable mayHappen) {
			// AdapterViews, ListViews and potentially other ViewGroups don't
			// support the removeAllViews operation
		}
	}

	@SuppressWarnings("deprecation")
	private static void unbindViewReferences(View view) {
		// set all listeners to null (not every view and not every API level
		// supports the methods)
		try {
		    view.setOnClickListener(null);
			view.setOnCreateContextMenuListener(null);
			view.setOnFocusChangeListener(null);
			view.setOnKeyListener(null);
			view.setOnLongClickListener(null);
			view.setOnClickListener(null);
		} catch (Throwable mayHappen) {
			//todo
		}

		// set background to null
		Drawable d = view.getBackground();
		if (d != null){
			d.setCallback(null);
		}
		
		if (view instanceof ImageView) {
			ImageView imageView = (ImageView) view;
			d = imageView.getDrawable();
			if (d != null){
				d.setCallback(null);
			}
			imageView.setImageDrawable(null);
			imageView.setBackgroundDrawable(null);
		}

		// destroy WebView
		if (view instanceof WebView) {
			WebView webview = (WebView) view;
			webview.stopLoading();
			webview.clearFormData();
			webview.clearDisappearingChildren();
			webview.setWebChromeClient(null);
			webview.setWebViewClient(null);
			webview.destroyDrawingCache();
			webview.destroy();
			webview = null;
		}

		if (view instanceof ListView) {
			ListView listView = (ListView) view;
			try {
				listView.removeAllViewsInLayout();
			} catch (Throwable mayHappen) {
			}
			((ListView) view).destroyDrawingCache();
		}
	}
	
	/**
	 * exit System
	 * @param context
	 */
	public void exit(Context context) {
		exit(context, true);
	}
	
	/**
	 * exit System
	 * @param context
	 * @param isClearCache
	 */
	@SuppressWarnings("deprecation")
	public void exit(Context context, boolean isClearCache) {
		try {
			finishAllActivity();
			/*if(context != null){
				ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
				activityMgr.restartPackage(context.getPackageName());
			}*/
			/*if(isClearCache){
				LruCacheManager.getInstance().evictAll();
				CacheManager.clearAll();
			}*/
//			System.exit(0);
//			android.os.Process.killProcess(android.os.Process.myPid());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
