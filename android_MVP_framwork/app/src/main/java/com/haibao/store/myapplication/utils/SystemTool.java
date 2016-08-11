/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.haibao.store.myapplication.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;

import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class SystemTool {
	private static final String TAG = "SystemTool";

	public static String getDataTime(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(new Date());
	}

	public static String getDataTime() {
		return getDataTime("HH:mm");
	}

	public static String getPhoneIMEI(Context cxt) {
		TelephonyManager tm = (TelephonyManager) cxt.getSystemService("phone");
		return tm.getDeviceId();
	}

	public static int getSDKVersion() {
		return Build.VERSION.SDK_INT;

	}

	public static String getSystemVersion() {
		return Build.VERSION.RELEASE;
	}

	public static void sendSMS(Context cxt, String smsBody) {
		Uri smsToUri = Uri.parse("smsto:");
		Intent intent = new Intent("android.intent.action.SENDTO", smsToUri);
		intent.putExtra("sms_body", smsBody);
		cxt.startActivity(intent);
	}

	public static boolean checkNet(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService("connectivity");
		NetworkInfo info = cm.getActiveNetworkInfo();
		return (info != null);
	}

	public static boolean isWiFi(Context cxt) {
		ConnectivityManager cm = (ConnectivityManager) cxt
				.getSystemService("connectivity");

		NetworkInfo.State state = cm.getNetworkInfo(1).getState();
		return (NetworkInfo.State.CONNECTED == state);
	}

	public static void hideKeyBoard(Activity aty) {
		((InputMethodManager) aty.getSystemService("input_method"))
				.hideSoftInputFromWindow(
						aty.getCurrentFocus().getWindowToken(), 2);
	}


	public static boolean isSleeping(Context context) {
		KeyguardManager kgMgr = (KeyguardManager) context
				.getSystemService("keyguard");
		boolean isSleeping = kgMgr.inKeyguardRestrictedInputMode();
		return isSleeping;
	}

	public static void installApk(Context context, File file) {
		Intent intent = new Intent();
		intent.setAction("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.setType("application/vnd.android.package-archive");
		intent.setData(Uri.fromFile(file));
		intent.setDataAndType(Uri.fromFile(file),
				"application/vnd.android.package-archive");
		intent.setFlags(268435456);
		context.startActivity(intent);
	}


	public static void goHome(Context context) {
		Intent mHomeIntent = new Intent("android.intent.action.MAIN");
		mHomeIntent.addCategory("android.intent.category.HOME");
		mHomeIntent.addFlags(270532608);
		context.startActivity(mHomeIntent);
	}


	private static String hexdigest(byte[] paramArrayOfByte) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(paramArrayOfByte);
			byte[] arrayOfByte = localMessageDigest.digest();
			char[] arrayOfChar = new char[32];
			int i = 0;
			int j = 0;
			if (i >= 16)
				return new String(arrayOfChar);
			int k = arrayOfByte[i];
			arrayOfChar[j] = hexDigits[(0xF & k >>> 4)];
			arrayOfChar[(++j)] = hexDigits[(k & 0xF)];

			++i;
			++j;
		} catch (Exception localException) {
		}

		return "";
	}

	public static int getDeviceUsableMemory(Context cxt) {
		ActivityManager am = (ActivityManager) cxt.getSystemService("activity");
		ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
		am.getMemoryInfo(mi);

		return (int) (mi.availMem / 1048576L);
	}

}