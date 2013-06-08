package com.example.epidemicapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class NonCarrierActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_non_carrier);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.non_carrier, menu);
		return true;
	}
	
	public void clickedOkayButton(View view) {
		findViewById(R.id.noncarrierokaybutton).setBackgroundResource(R.drawable.first_view2_select_04);
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
