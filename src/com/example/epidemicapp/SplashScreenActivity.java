package com.example.epidemicapp;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class SplashScreenActivity extends Activity {
	
	public static DBUtil DB = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash_screen);

//	    final DBUtil util = new DBUtil(getApplicationContext(),0);
//		assert (util != null);
//		assert (util.myUser != null);
		DB = new DBUtil(getApplicationContext(),1);
		
		final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // TODO: Your application init goes here.
                if (DB.myUser.getHowSick() == 0) {
	            	Intent mInHome = new Intent(SplashScreenActivity.this, NonCarrierActivity.class);
	                SplashScreenActivity.this.startActivity(mInHome);
	                SplashScreenActivity.this.finish();
                }
                else {
                	Intent mInHome = new Intent(SplashScreenActivity.this, FirstCarrierActivity.class);
	                SplashScreenActivity.this.startActivity(mInHome);
	                SplashScreenActivity.this.finish();
                }
            }
        }, 3000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}
	
	

}
