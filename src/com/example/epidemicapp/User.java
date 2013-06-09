package com.example.epidemicapp;

import android.location.Location;

public class User {
	private static int USER_ID_COUNTER = 0;
	
	private int mID = -1;
	private Location mLoc = null;
	private int mHowSick = 0, mContCount = 0;
	private double mLatitude = 0, mLongitude = 0;
	
	public User(int id,Location loc) {
		mID = id;
		mLoc = loc;
		mHowSick = 0;
		mContCount = 0;
	}
	
	public User(int id,double lat, double lon, int howsick, int contcount) {
		mID = id;
		mLatitude = lat;
		mLongitude = lon;
		mHowSick = howsick;
		mContCount = contcount;
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
		if (mLoc != null) return mLoc.getLatitude();
		else return mLatitude;
	}
	
	public double getLongitude() {
		if (mLoc != null) return mLoc.getLongitude();
		else return mLongitude;
	}
	
	public void setLatitude(double lat) {
		//mLoc.setLatitude(lat);
		mLatitude = lat;
	}
	
	public void setLongitude(double lon) {
		//mLoc.setLongitude(lon);
		mLongitude = lon;
	}
	
	public int getHowSick() {
		return mHowSick;
	}
}
