/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.haibao.store.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;

public final class MyFileUtils {
	public static boolean checkSDcard() {
		return "mounted".equals(Environment.getExternalStorageState());
	}

	public static void debugFile(Context mContext, String str) throws Exception {
		File file = MyFileUtils.getSaveFile(mContext.getPackageName()
						+ File.separator + "debug",
				SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss") + ".log");
		BufferedWriter bw=new BufferedWriter(new FileWriter(file));
		bw.write(str);
		bw.flush();
		bw.close();


	}


	public static void saveFileCache(byte[] fileData, String folderPath,
			String fileName) {
		File folder = new File(folderPath);
		folder.mkdirs();
		File file = new File(folderPath, fileName);
		ByteArrayInputStream is = new ByteArrayInputStream(fileData);
		OutputStream os = null;
		if (file.exists())
			return;
		try {
			file.createNewFile();
			os = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			while (-1 != (len = is.read(buffer))) {
				os.write(buffer, 0, len);
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeIO(new Closeable[] { is, os });
		}
	}

	public static File getSaveFile(String folderPath, String fileNmae) {
		File file = new File(getSavePath(folderPath) + File.separator
				+ fileNmae);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static String getSavePath(String folderName) {
		return getSaveFolder(folderName).getAbsolutePath();
	}

	public static File getSaveFolder(String folderName) {
		File file = new File(Environment.getExternalStorageDirectory()
				.getAbsoluteFile()
				+ File.separator
				+ folderName
				+ File.separator);
		file.mkdirs();
		return file;
	}

	public static final byte[] input2byte(InputStream inStream) {
		if (inStream == null)
			return null;
		byte[] in2b = null;
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		try {
			while ((rc = inStream.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc);
			}
			in2b = swapStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeIO(new Closeable[] { swapStream });
		}
		return in2b;
	}

	public static File uri2File(Activity aty, Uri uri) {
		if (SystemTool.getSDKVersion() < 11) {
			String[] proj = { "_data" };

			Cursor actualimagecursor = aty.managedQuery(uri, proj, null, null,
					null);
			int actual_image_column_index = actualimagecursor
					.getColumnIndexOrThrow("_data");
			actualimagecursor.moveToFirst();
			String img_path = actualimagecursor
					.getString(actual_image_column_index);
			return new File(img_path);
		}

		String[] projection = { "_data" };
		CursorLoader loader = new CursorLoader(aty, uri, projection, null,
				null, null);
		Cursor cursor = loader.loadInBackground();
		int column_index = cursor.getColumnIndexOrThrow("_data");
		cursor.moveToFirst();
		return new File(cursor.getString(column_index));
	}

	public static void copyFile(File from, File to) {
		if ((from == null) || (!(from.exists())))
			return;
		if (to == null)
			return;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			is = new FileInputStream(from);
			if (!(to.exists())) {
				to.createNewFile();
			}
			os = new FileOutputStream(to);
			copyFileFast(is, os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeIO(new Closeable[] { is, os });
		}
	}

	public static void copyFileFast(FileInputStream is, FileOutputStream os)
			throws IOException {
		FileChannel in = is.getChannel();
		FileChannel out = os.getChannel();
		in.transferTo(0L, in.size(), out);
	}

	public static void closeIO(Closeable[] closeables) {
		if ((closeables == null) || (closeables.length <= 0))
			return;
		for (Closeable cb : closeables)
			try {
				if (cb != null) {
					cb.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static boolean bitmapToFile(Bitmap bitmap, String filePath) {
		boolean isSuccess = false;
		if (bitmap == null)
			return isSuccess;
		OutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(filePath), 8192);
			isSuccess = bitmap.compress(Bitmap.CompressFormat.PNG, 70, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeIO(new Closeable[] { out });
		}
		return isSuccess;
	}

	public static String readFile(String filePath) {
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
		} catch (Exception e) {
			e.printStackTrace();
//			throw new KJException(FileUtils.class.getName() + "readFile---->"
//					+ filePath + " not found");
		}
		return inputStream2String(is);
	}

	public static String readFileFromAssets(Context context, String name) {
		InputStream is = null;
		try {
			is = context.getResources().getAssets().open(name);
		} catch (Exception e) {
			e.printStackTrace();
//			throw new KJException(FileUtils.class.getName()
//					+ ".readFileFromAssets---->" + name + " not found");
		}
		return inputStream2String(is);
	}

	public static String inputStream2String(InputStream is) {
		if (is == null)
			return null;
		StringBuilder resultSb = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			resultSb = new StringBuilder();
			String len;
			while ((len = br.readLine()) != null) {
				resultSb.append(len);
			}
		} catch (Exception localException) {
		} finally {
			closeIO(new Closeable[] { is });
		}
		return ((resultSb == null) ? null : resultSb.toString());
	}

	public static String getMimeType(String fileUrl) throws IOException,
			MalformedURLException {
		String type = null;
		URL u = new URL(fileUrl);
		URLConnection uc = null;
		uc = u.openConnection();
		type = uc.getContentType();
		return type;
	}
}