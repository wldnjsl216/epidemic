package com.example.epidemicapp;

public class Disease {
	private static int DISEASE_ID_COUNTER = 0;
	
	private int mID = -1;
	private String mName = null;
	
	public Disease(String name) {
		mID = createDiseaseID();
		mName = name;
	}
	
	private int createDiseaseID() {
		int newUserID = Disease.DISEASE_ID_COUNTER;
		Disease.DISEASE_ID_COUNTER++;
		return newUserID;
	}
	
	public int getID(){
		return mID;
	}
	
	public String getName(){
		return mName;
	}
}
