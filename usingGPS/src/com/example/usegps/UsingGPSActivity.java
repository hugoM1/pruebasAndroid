package com.example.usegps;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;

public class UsingGPSActivity extends Activity {
	
	private LocationManager lm;
	private LocationListener locListenD;
	private TextView tvLatitude;
	private TextView tvLongitude;
	Location loc;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tvLatitude = (TextView)findViewById(R.id.tvLatitude);
        tvLongitude = (TextView)findViewById(R.id.tvLongitude);
        
        //get handle for LocationManger
        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        
        //Connect to the GPS LocationService
         loc = lm.getLastKnownLocation("gps");
         
         //Fill the TextViews
         tvLatitude.setText(Double.toString(loc.getLatitude()));
         tvLongitude.setText(Double.toString(loc.getLongitude()));
         
         //Ask the LocationManager to send us Location updates
         locListenD = new DispLocListener();
         lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000L, 10.0f, locListenD);
    }
    
    private class DispLocListener implements LocationListener{

		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			//Update TextViews
			tvLatitude.setText(Double.toString(location.getLatitude()));
			tvLongitude.setText(Double.toString(location.getLongitude()));
			
		}

		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}