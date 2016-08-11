package com.haibao.store.myapplication.utils;

import android.util.Log;

/**
 * Log 日志工具类
 * @author weijiang.Zeng
 *
 */
public class LogUtil {

	//当前Debug模式
	public static boolean DE_BUG = true;

	public static void e(String tag, String text) {
		if (DE_BUG) {
			Log.e(tag, text);
		}
	}

	public static void d(String tag, String text) {
		if (DE_BUG) {
			Log.d(tag, text);
		}
	}

	public static void i(String tag, String text) {
		if (DE_BUG) {
			Log.i(tag, text);
		}
	}

	public static void w(String tag, String text) {
		if (DE_BUG) {
			Log.w(tag, text);
		}
	}
	
	public static void v(String tag, String text) {
		if (DE_BUG) {
			Log.v(tag, text);
		}
	}
	
	private static final String LOG_FORMAT = "%1$s\n%2$s";
	
	public static void d(String tag, Object... args) {
		log(Log.DEBUG, null, tag, args);
	}

	public static void i(String tag, Object... args) {
		log(Log.INFO, null, tag, args);
	}

	public static void w(String tag, Object... args) {
		log(Log.WARN, null, tag, args);
	}

	public static void e(Throwable ex) {
		log(Log.ERROR, ex, null);
	}

	public static void e(String tag, Object... args) {
		log(Log.ERROR, null, tag, args);
	}

	public static void e(Throwable ex, String tag, Object... args) {
		log(Log.ERROR, ex, tag, args);
	}

	private static void log(int priority, Throwable ex, String tag, Object... args) {
		
		if (LogUtil.DE_BUG == false) return;
		
		String log = "";
		if (ex == null) {
			if(args != null && args.length > 0){
				for(Object obj : args){
					log += String.valueOf(obj);
				}
			}
		} else {
			String logMessage = ex.getMessage();
			String logBody = Log.getStackTraceString(ex);
			log = String.format(LOG_FORMAT, logMessage, logBody);
		}
		Log.println(priority, tag, log);
	}

	public static boolean isDebug() {
		return DE_BUG;
	}

	public static void setDebug(boolean isDebug) {
		LogUtil.DE_BUG = isDebug;
	}
	
}
