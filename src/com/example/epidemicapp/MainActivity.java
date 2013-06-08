package com.example.epidemicapp;

import com.skp.Tmap.TMapGpsManager;
import com.skp.Tmap.TMapView;
import com.skp.openplatform.android.sdk.api.APIRequest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private TMapView tmapview = null;
	private RelativeLayout mapRelativeLayout = null;
	
	TMapGpsManager gps = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        APIRequest.setAppKey("68fd1c9f-3a66-30bb-8934-990e8beb01f6");
        
        RelativeLayout mapRelativeLayout = (RelativeLayout)findViewById(R.id.mapRelativeLayout);
        
        tmapview = new TMapView(this);
        mapRelativeLayout.addView(tmapview);
        configureTMapView();
        
        gps = new TMapGpsManager(MainActivity.this);
		gps.setMinTime(1000);
		gps.setMinDistance(5);
		
		gps.setProvider(gps.NETWORK_PROVIDER);
		gps.OpenGps();
    }

    private void configureTMapView() {
    	new Thread() {
			@Override
			public void run() {
				tmapview.setSKPMapApiKey("68fd1c9f-3a66-30bb-8934-990e8beb01f6"); //TODO: check if this is valid APIkey
		        tmapview.setLanguage(tmapview.LANGUAGE_KOREAN);
		        tmapview.setIconVisibility(true);
		        tmapview.setZoomLevel(10);
		        tmapview.setMapType(tmapview.MAPTYPE_STANDARD);
		        tmapview.setCompassMode(true);
		        tmapview.setTrackingMode(true);
			}
		}.start();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
	
	public void onLocationChange(android.location.Location location){
		double lat = location.getLatitude();
		double lon = location.getLongitude();
		
		
	}
}
