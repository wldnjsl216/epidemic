package com.example.epidemicapp;

import android.location.Location;

public class User {
	private static int USER_ID_COUNTER = 0;
	
	private int mID = -1;
	private Location mLoc;
	private int mLevel = 0;
	
	public User(Location loc) {
		mID = createUserID();
		mLoc = loc;
		mLevel = 0;
	}
	
	private int createUserID() {
		int newUserID = User.USER_ID_COUNTER;
		User.USER_ID_COUNTER++;
		return newUserID;
	}
	
	public int getID() {
		return mID;
	}
	
	public double getLatitude() {
		return mLoc.getLatitude();
	}
	
	public double getLongitude() {
		return mLoc.getLongitude();
	}
	
	public void setLatitude(double lat) {
		mLoc.setLatitude(lat);
	}
	
	public void setLongitude(double lon) {
		mLoc.setLongitude(lon);
	}
}
