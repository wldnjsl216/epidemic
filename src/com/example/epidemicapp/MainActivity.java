package com.example.epidemicapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;

public class MainActivity extends Activity {
	public static DBUtil DB = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        DB = new DBUtil(getApplicationContext(),1);
        configureStatus();
        
        configureUserdiseaseList();
    }
    
    private void configureStatus() {
    	ImageView view = (ImageView) findViewById(R.id.statusImgView);
    	
    	int sick = 0; //TODO: set it to how sick
    	if (sick == 0) view.setImageResource(R.drawable.hlevel_0);
    	else if (sick == 1) view.setImageResource(R.drawable.hlevel_1);
    	else if (sick == 2) view.setImageResource(R.drawable.hlevel_2);
    	else view.setImageResource(R.drawable.hlevel_3);
    }
    
    private void configureUserdiseaseList() {
		Cursor disCursor = DB.getUserDiseases(DB.myUser.getID());
		TextView discount = (TextView) findViewById(R.id.statusDiseaseCount);
//		discount.setText(disCursor.getCount()); //set disease count
		Log.v("DEBUG","count = "+disCursor.getCount());
		
		
	}



	/** Called when the user clicks the Open News button */
    public void openNews(View view) {
    	((Button) findViewById(R.id.openNewsButton)).setBackgroundResource(R.drawable.main_view_vector_select_04_04);
    	
    	Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
    
    /** Called when the user clicks the Open Disease Dictionary button */
    public void openDiseaseList(View view) {
    	((Button) findViewById(R.id.openDiseaseListButton)).setBackgroundResource(R.drawable.main_view_vector_select_06);
    	
    	Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
	
}
