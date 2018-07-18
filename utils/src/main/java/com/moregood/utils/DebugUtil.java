package com.moregood.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.FileWriter;


/**
 *
 * 
 * @author yexifeng
 * 
 */
public class DebugUtil {
	public static final String TAG = "Moregood";
	private static final boolean debugMode = true;


	public static void debug(String format, Object... args) {
		debug(TAG,format,args);
	}
	public static void debug(String tag,String format, Object... args) {
		if (!debugMode || format == null) return;
		try {
			String strMsg = String.format(format, args);
			Log.d(tag, strMsg);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}

	public static void error(String format, Object... args) {
		error(TAG,format,args);
	}
	public static void error(String tag,String format, Object... args) {
		if (!debugMode || format == null) return;
		try {
			String strMsg = String.format(format, args);
			Log.e(tag, strMsg);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}

	/**
	 * print out warning message
	 * 
	 * @param format
	 *            message format
	 * @param args
	 *            message format parameters
	 */
	public static void warning(String format, Object... args) {
		warning(TAG,format,args);
	}
	public static void warning(String tag,String format, Object... args) {
		if (!debugMode || format == null) return;
		try {
			String strMsg = String.format(format, args);
			Log.w(tag, strMsg);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}

	public static void toast(Context context, String msg){
		if(true) {
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 追加文件：使用FileWriter
	 * @param fileName
	 * @param content
	 */
	private static boolean fileAppend(String fileName,String content){
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public static boolean logPoint(String tag,String time,String where){
		String fileName = "sdcard/logPoint.log";
		String content = String.format("%s   %s   %s called",time,tag,where);
		return fileAppend(fileName,content);
	}


}
