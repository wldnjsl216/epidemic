package com.example.epidemicapp;

import java.io.IOException;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBUtil {
	public DataBaseHelper myDbHelper = null;
	public User myUser = null;
    
	public DBUtil(Context cxt, int userid) {
	    myDbHelper = new DataBaseHelper(cxt);
	    try {
	    	 
        	myDbHelper.createDataBase();
 
	 	} catch (IOException ioe) {
	 
	 		throw new Error("Unable to create database");
	 
	 	}
	 
	 	try {
	 
	 		myDbHelper.openDataBase();
	 
	 	}catch(SQLException sqle){
	 
	 		throw sqle;
	 
	 	}
	 	
	 	myUser = getUser(userid);


 		Log.v("DEBUG","within DBUtil, after getUser!!");
   }
	
	private User getUser(int userid) {
		String selectQuery = "SELECT * FROM " + Consts.USER_TABLE + " WHERE " +Consts.USER_ID + "="+userid;
		SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        
        double lat = 0, lon = 0;
        int id = 0, howsick = 0, contcount = 0;
        if (null != cursor && cursor.moveToFirst()) {
        	id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(Consts.USER_ID)));
            lat = Double.parseDouble(cursor.getString(cursor.getColumnIndex(Consts.USER_LAST_LAT)));
            lon = Double.parseDouble(cursor.getString(cursor.getColumnIndex(Consts.USER_LAST_LON)));
            howsick = Integer.parseInt(cursor.getString(cursor.getColumnIndex(Consts.USER_HOW_SICK)));
            contcount = Integer.parseInt(cursor.getString(cursor.getColumnIndex(Consts.USER_CONT_COUNT)));
        }
        
		User myself = new User(id,lat,lon,howsick,contcount);		
		return myself;
	}
	
	public Cursor getUserDiseases(int userid) {
		String selectQuery = "SELECT * FROM " + Consts.USER_DISEASE_TABLE + " WHERE " +Consts.USER_DISEASE_USER_ID + "="+userid;
		SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
		return cursor;
	}
	
	public Cursor getNews() {
		String selectQuery = "SELECT * FROM " + Consts.USER_DISEASE_TABLE;
		SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
		return cursor;
	}
	
//	public User createUser(Location loc) {
//	User user = new User(loc);
//	
//	SQLiteDatabase db = this.getWritableDatabase();
//	 
//    ContentValues values = new ContentValues();
//    values.put(USER_LAST_LAT, user.getLatitude()); // User Latitude
//    values.put(USER_LAST_LON, user.getLongitude()); // User Longitude
// 
//    // Inserting Row
//    db.insert(USER_TABLE, null, values);
//    return user;
//}

//public int updateUser(User user) {
//    SQLiteDatabase db = this.getWritableDatabase();
// 
//    ContentValues values = new ContentValues();
//    values.put(USER_LAST_LAT, user.getLatitude()); // User Latitude
//    values.put(USER_LAST_LON, user.getLongitude()); // User Longitude
// 
//    // updating row
//    return db.update(USER_TABLE, values, USER_ID + " = ?",
//            new String[] { String.valueOf(user.getID()) });
//}
//
//public void deleteUser(User user) {
//	//TODO: delete user and the relationships within the database~~
//	
//    SQLiteDatabase db = this.getWritableDatabase();
// 
//    // deleting row
//    db.delete(USER_TABLE, USER_ID + " = ?",
//            new String[] { String.valueOf(user.getID()) });
//}
//
//public Disease createDisease(String name) {
//	Disease disease = new Disease(name);
//	
//	SQLiteDatabase db = this.getWritableDatabase();
//	 
//    ContentValues values = new ContentValues();
//    values.put(DISEASE_NAME, disease.getName()); // User Latitude
// 
//    // Inserting Row
//    db.insert(DISEASE_TABLE, null, values);
//	return disease;
//}
}
