package com.example.epidemicapp;

import com.skp.Tmap.TMapCircle;
import com.skp.Tmap.TMapMarkerItem;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapView;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TMapView tmapview = null;
	private RelativeLayout mapRelativeLayout = null;
	private double lat;
	private double lon;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RelativeLayout mapRelativeLayout = (RelativeLayout)findViewById(R.id.mapRelativeLayout);
        
        tmapview = new TMapView(this);
        
        this._getLocation();
        
        Context context = getApplicationContext();
        CharSequence text = "lat: " + lat + ", lon: " + lon;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        
        TMapCircle tcircle = new TMapCircle();
        tcircle.setCenterPoint(new TMapPoint(lat, lon));
        tcircle.setRadius(10000);
        tcircle.setAreaColor(Color.RED);
        tcircle.setLineColor(Color.RED);
        tcircle.setAreaAlpha(50);
        tcircle.setRadiusVisible(true);
        
        TMapMarkerItem titem = new TMapMarkerItem();
        titem.setTMapPoint(new TMapPoint(lat, lon));
        titem.setName("point1");
        titem.setPosition(0.5f, 1.0f);
        titem.setVisible(titem.VISIBLE);
        
        TMapMarkerItem titem2 = new TMapMarkerItem();
        titem2.setTMapPoint(new TMapPoint(37.518644,126.969153));
        titem2.setName("point2");
        titem2.setPosition(0.5f, 1.0f);
        titem2.setVisible(titem.VISIBLE);
        
        tmapview.setLocationPoint(lon, lat);
        mapRelativeLayout.addView(tmapview);
        tmapview.addTMapCircle("test circle", tcircle);
        tmapview.addMarkerItem("test marker 1", titem);
        tmapview.addMarkerItem("test marker 2", titem2);
        configureTMapView();
        
        //remove
//        DBUtil util = new DBUtil(getApplicationContext(),0);
//        CharSequence usertext = "id: " + util.myUser.getID() + ", user_lat: " + util.myUser.getLatitude();
//        toast = Toast.makeText(context, usertext, duration);
//        toast.show();
        
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
	
}
