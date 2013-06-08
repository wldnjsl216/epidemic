package com.example.epidemicapp;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);        
        //remove
//        Context context = getApplicationContext();
//        int duration = Toast.LENGTH_LONG;
//        DBUtil util = new DBUtil(getApplicationContext(),0);
//
// 		assert (util != null);x
// 		assert (util.myUser != null);
//        CharSequence usertext = "id: " + util.myUser.getID() + ", user_lat: " + util.myUser.getLatitude();
//        toast = Toast.makeText(context, usertext, duration);
//        toast.show();
    }
    
    /** Called when the user clicks the Open News button */
    public void openNews(View view) {
    	Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
	
}
