package iode.utils;

import android.database.Cursor;


public class WithCursor {
	public static final int CONTINUE = 0;
	public static final int DONE = 1;

	public static void each(Cursor c, CursorFn fn) {

		try {
			c.moveToFirst();
			while(!c.isAfterLast()) {
				fn.execute(c);				
				c.moveToNext();
			}
		} finally {
			c.close();
		}
	}

	public static void each2(Cursor c, CursorEachFn fn) {

		try {
			c.moveToFirst();
			while(!c.isAfterLast()) {
				int result = fn.execute(c);
				if(result == DONE) {
					break;
				}
				c.moveToNext();
			}
		} finally {
			c.close();
		}
	}

	public static void first(Cursor c, CursorFn fn) {
		try {
			c.moveToFirst();
			if(!c.isAfterLast()) {
				fn.execute(c);			
			}
		} finally {
			c.close();
		}
	}
}
