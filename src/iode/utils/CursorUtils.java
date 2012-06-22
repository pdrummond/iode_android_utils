package iode.utils;

import android.database.Cursor;

public class CursorUtils {
	public static String getString(Cursor c, String columnName) {
		return c.getString(c.getColumnIndex(columnName));
	}

	public static int getInt(Cursor c, String columnName) {
		return c.getInt(c.getColumnIndex(columnName));
	}

	public static double getDouble(Cursor c, String columnName) {
		return c.getDouble(c.getColumnIndex(columnName));
	}

	public static boolean getBoolean(Cursor c, String columnName) {
		return c.getInt(c.getColumnIndex(columnName))>0;
	}

	public static long getLong(Cursor c, String columnName) {
		return c.getLong(c.getColumnIndex(columnName));
	}

}
