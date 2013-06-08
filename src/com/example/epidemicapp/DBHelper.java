package com.example.epidemicapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;

class DBHelper extends SQLiteOpenHelper { 
	public static int DB_VERSION = 1;
	public static String DB_NAME = "epidemic.db";
	
	public static final String USER_TABLE = "user";
	public static final String USER_ID = "_id";
	public static final String USER_LAST_LAT = "latitude";
	public static final String USER_LAST_LON = "longitude";
//        private static final String USER_TITLE2 = "title";
	
	public static final String DISEASE_TABLE = "disease";
	public static final String DISEASE_NAME = "name";
	
	public static final String USER_TABLE_CREATION = "create table " + USER_TABLE + " (" + USER_ID + " integer primary key autoincrement, " + USER_LAST_LAT + " integer not null);";
    public static final String DISEASE_TABLE_CREATION = "table2 create statement";
 
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(USER_TABLE_CREATION);
		db.execSQL(DISEASE_TABLE_CREATION);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int paramInt1, int paramInt2) {
		db.execSQL("DROP TABLE " + USER_TABLE_CREATION + ";");
		db.execSQL("DROP TABLE " + DISEASE_TABLE_CREATION + ";");
		onCreate(db);
	}
	
	public User createUser(Location loc) {
		User user = new User(loc);
		
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(USER_LAST_LAT, user.getLatitude()); // User Latitude
	    values.put(USER_LAST_LON, user.getLongitude()); // User Longitude
	 
	    // Inserting Row
	    db.insert(USER_TABLE, null, values);
	    return user;
	}
	
	public int updateUser(User user) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(USER_LAST_LAT, user.getLatitude()); // User Latitude
	    values.put(USER_LAST_LON, user.getLongitude()); // User Longitude
	 
	    // updating row
	    return db.update(USER_TABLE, values, USER_ID + " = ?",
	            new String[] { String.valueOf(user.getID()) });
	}
	
	public void deleteUser(User user) {
		//TODO: delete user and the relationships within the database~~
		
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    // deleting row
	    db.delete(USER_TABLE, USER_ID + " = ?",
	            new String[] { String.valueOf(user.getID()) });
	}
	
	public Disease createDisease(String name) {
		Disease disease = new Disease(name);
		
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(DISEASE_NAME, disease.getName()); // User Latitude
	 
	    // Inserting Row
	    db.insert(DISEASE_TABLE, null, values);
		return disease;
	}
}
