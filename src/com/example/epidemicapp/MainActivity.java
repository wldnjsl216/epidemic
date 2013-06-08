package com.example.epidemicapp;

import android.os.Bundle;
import android.view.Window;
import android.app.Activity;

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
// 		assert (util != null);
// 		assert (util.myUser != null);
//        CharSequence usertext = "id: " + util.myUser.getID() + ", user_lat: " + util.myUser.getLatitude();
//        toast = Toast.makeText(context, usertext, duration);
//        toast.show();
    }
	
}
