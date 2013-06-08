package com.example.epidemicapp;

import com.skp.Tmap.TMapView;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TMapView tmapview = null;
	private RelativeLayout mapRelativeLayout = null;
	private double lat;
	private double lon;
	
//	TMapGpsManager gps;// = new TMapGpsManager(MainActivity.this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        APIRequest.setAppKey("68fd1c9f-3a66-30bb-8934-990e8beb01f6");
        
        RelativeLayout mapRelativeLayout = (RelativeLayout)findViewById(R.id.mapRelativeLayout);
        
        tmapview = new TMapView(this);
        mapRelativeLayout.addView(tmapview);
        configureTMapView();
        
        this._getLocation();
        Context context = getApplicationContext();
        CharSequence text = "lat: " + lat + ", lon: " + lon;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        
//        gps = new TMapGpsManager(this);
//		gps.setMinTime(1000);
//		gps.setMinDistance(5);
//		gps.setProvider(gps.GPS_PROVIDER);
//		gps.OpenGps();
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
	
	/*private void _getLocation() {
	    // Get the location manager
	    LocationManager locationManager = (LocationManager) 
	            getSystemService(LOCATION_SERVICE);
	    Criteria criteria = new Criteria();
	    String bestProvider = locationManager.getBestProvider(criteria, false);
	    Location location = locationManager.getLastKnownLocation(bestProvider);
	    try {
	        lat = location.getLatitude();
	        lon = location.getLongitude();
	    } catch (NullPointerException e) {
	        lat = -1.0;
	        lon = -1.0;
	    }
	}*/
	private void _getLocation() {
	    // Get the location manager
	    LocationManager locationManager = (LocationManager) 
	            getSystemService(LOCATION_SERVICE);
	    Criteria criteria = new Criteria();
	    String bestProvider = locationManager.getBestProvider(criteria, false);
	    Location location = locationManager.getLastKnownLocation(bestProvider);
	    LocationListener loc_listener = new LocationListener() {

	        public void onLocationChanged(Location l) {}

	        public void onProviderEnabled(String p) {}

	        public void onProviderDisabled(String p) {}

	        public void onStatusChanged(String p, int status, Bundle extras) {}
	    };
	    locationManager
	            .requestLocationUpdates(bestProvider, 0, 0, loc_listener);
	    location = locationManager.getLastKnownLocation(bestProvider);
	    try {
	        lat = location.getLatitude();
	        lon = location.getLongitude();
	    } catch (NullPointerException e) {
	        lat = -1.0;
	        lon = -1.0;
	    }
	}
	
//	public void onLocationChange(android.location.Location location){
//		double lat = location.getLatitude();
//		double lon = location.getLongitude();
//	}
}
