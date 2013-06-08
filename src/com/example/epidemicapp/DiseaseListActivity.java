package com.example.epidemicapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DiseaseListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_disease_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.disease_list, menu);
		return true;
	}

}
