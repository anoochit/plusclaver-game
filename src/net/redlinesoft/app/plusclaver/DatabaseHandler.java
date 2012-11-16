package net.redlinesoft.app.plusclaver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

	public DatabaseHandler(Context context) {
		super(context, context.getExternalFilesDir(null).getAbsolutePath().toString() + "/" + "plusclever.db", null, 1);
	} 
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS item (id INTEGER PRIMARY KEY AUTOINCREMENT, title STRING,score INTEGER)");
		Log.d("DB", "Create Table Successfully.");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
	
	 
	public long InsertItem(Integer itemId,String strTitle, Integer intScore) {
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase(); // Write Data
 
			ContentValues Val = new ContentValues();
			Val.put("id", itemId);			
			Val.put("title", strTitle);
			Val.put("score", intScore); 
			
			long rows = db.insert("item", null, Val);

			db.close();
			return rows; // return rows inserted.

		} catch (Exception e) {
			return -1;
		}

	}

	// Select All Data
	public String[][] SelectAllData() {
		// TODO Auto-generated method stub

		try {
			String arrData[][] = null;
			SQLiteDatabase db;
			db = this.getReadableDatabase(); // Read Data

			String strSQL = "SELECT * FROM item ";
			Cursor cursor = db.rawQuery(strSQL, null);
			Log.d("DB", "SELECT * FROM item to make list view");
			if (cursor != null) {
				if (cursor.moveToFirst()) {
					arrData = new String[cursor.getCount()][cursor
							.getColumnCount()];

					int i = 0;
					do {
						arrData[i][0] = cursor.getString(0);
						arrData[i][1] = cursor.getString(1);
						arrData[i][2] = cursor.getString(2);
						arrData[i][3] = cursor.getString(3);
						i++;
					} while (cursor.moveToNext());

				}
			}
			cursor.close();

			return arrData;

		} catch (Exception e) {
			return null;
		}

	}

	/*
	public Cursor SelectAllData() {
		// TODO Auto-generated method stub
		try {
		 
			SQLiteDatabase db;
			db = this.getReadableDatabase(); // Read Data

			String strSQL = "SELECT id As _id , * FROM item ";
			Cursor cursor = db.rawQuery(strSQL, null);
			return cursor;

		} catch (Exception e) {
			return null;
		}

	}
	*/

	public Integer getTotalRow() {
		// TODO Auto-generated method stub
		try {
			SQLiteDatabase db;
			db = this.getReadableDatabase(); // Read Data
			Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM item", null);
			Log.d("DB", "SELECT count FROM item");
			cursor.moveToFirst();
			int count = cursor.getInt(0);
			cursor.close();
			return count;
		} catch (Exception e) {
			return 0;
		}
	}
	
	/*
	
	public Integer isItemExist(String videoId) {
		// TODO Auto-generated method stub
		try {
			SQLiteDatabase db;
			db = this.getReadableDatabase(); // Read Data
			Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM item WHERE videoid='"+videoId+"'",null);
			cursor.moveToFirst();
			int count = cursor.getInt(0);
			cursor.close();
			return count;
		} catch (Exception e) {
			return 0;
		}
	}
	
	*/
	
	public void deleteTableData() {
		// TODO Auto-generated method stub
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase(); // Read Data	 
			db.delete("item", null, null);			 
			db.close();
			Log.d("DB", "Delete table data");
		} catch (Exception e) {
			
		}
	}
	

}
