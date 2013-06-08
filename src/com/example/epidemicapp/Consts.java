package com.example.epidemicapp;

public final class Consts {
	public static String DB_NAME = "epidemic.sqlite";
	
	public static final String USER_TABLE = "user";
	public static final String USER_ID = "_id";
	public static final String USER_LAST_LAT = "latitude";
	public static final String USER_LAST_LON = "longitude";
	public static final String USER_HOW_SICK = "how_sick";
	public static final String USER_CONT_COUNT = "contaminate_count";

	public static final String DISEASE_TABLE = "disease";
	public static final String DISEASE_ID = "_id";
	public static final String DISEASE_NAME = "name";
	public static final String DISEASE_FIRST_CARRIER = "first_carrier";
	public static final String DISEASE_BREAKOUT_DATE = "breakout_date";
	
	public static final String NEWS_TABLE = "news";
	public static final String NEWS_ID = "_id";
	public static final String NEWS_DATE = "date";
	public static final String NEWS_CONTEXT = "context";
	
	public static final String USER_DISEASE_TABLE = "user_disease";
	public static final String USER_DISEASE_ID = "_id";
	public static final String USER_DISEASE_USER_ID = "user_id";
	public static final String USER_DISEASE_DISEASE_ID = "disease_id";
	public static final String USER_DISEASE_DATE = "date";
	public static final String USER_DISEASE_INFECTED_LATITUDE = "latitude";
	public static final String USER_DISEASE_INFECTED_LONGITUDE = "longitude";
	

}
