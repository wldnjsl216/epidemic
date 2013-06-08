package com.example.epidemicapp;

import java.util.LinkedList;
import java.util.List;

import com.skp.Tmap.TMapMarkerItem;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapView;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.Window;
import android.widget.RelativeLayout;

public class DiseaseDetailActivity extends Activity {
	private TMapView tmapview = null;
	private LinkedList<TMapMarkerItem> markers = new LinkedList<TMapMarkerItem>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_disease_detail);

        RelativeLayout mapRelativeLayout = (RelativeLayout)findViewById(R.id.mapRelativeLayout);
        
        tmapview = new TMapView(this);
        
        this._getLocation();
        
        tmapview.setLocationPoint(SplashScreenActivity.DB.myUser.getLongitude(), SplashScreenActivity.DB.myUser.getLatitude());
        mapRelativeLayout.addView(tmapview);
        
        String selectQuery = "SELECT * FROM " + Consts.USER_TABLE;
        SQLiteDatabase db = SplashScreenActivity.DB.myDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
        	//TODO: display on map
        	int howsick = Integer.parseInt(cursor.getString(cursor.getColumnIndex(Consts.USER_HOW_SICK)));
        	if (howsick > 0) {
	        	double lat = Double.parseDouble(cursor.getString(cursor.getColumnIndex(Consts.USER_LAST_LAT)));
	            double lon = Double.parseDouble(cursor.getString(cursor.getColumnIndex(Consts.USER_LAST_LON)));
	            markers.addFirst(new TMapMarkerItem());
	            markers.getFirst().setTMapPoint(new TMapPoint(lat, lon));
	            markers.getFirst().setName(lat+","+"lon");
	            markers.getFirst().setPosition(0.5f, 1.0f);
	            markers.getFirst().setVisible(markers.getFirst().VISIBLE);
	            tmapview.addMarkerItem(lat+","+lon, markers.getFirst());
        	}
        	cursor.moveToNext();
        }
        
        configureTMapView();
        
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
	    LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
	    Criteria criteria = new Criteria();
	    String bestProvider = locationManager.getBestProvider(criteria, false);
	    Location location = locationManager.getLastKnownLocation(bestProvider);
	    LocationListener loc_listener = new LocationListener() {

	        public void onLocationChanged(Location l) {}

	        public void onProviderEnabled(String p) {}

	        public void onProviderDisabled(String p) {}

	        public void onStatusChanged(String p, int status, Bundle extras) {}
	    };
	    locationManager.requestLocationUpdates(bestProvider, 0, 0, loc_listener);
	    location = locationManager.getLastKnownLocation(bestProvider);
	    try {
	        SplashScreenActivity.DB.myUser.setLatitude(location.getLatitude());
	        SplashScreenActivity.DB.myUser.setLongitude(location.getLongitude());
	    } catch (NullPointerException e) {
	    	SplashScreenActivity.DB.myUser.setLatitude(location.getLatitude());
	        SplashScreenActivity.DB.myUser.setLongitude(location.getLongitude());
	    }
	}

}
