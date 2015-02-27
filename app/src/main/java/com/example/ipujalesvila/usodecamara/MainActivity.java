package com.example.ipujalesvila.usodecamara;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button miGPS = (Button) findViewById(R.id.button_GPS);
        miGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationManager milocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                LocationListener milocListener = new MiLocationListener();
                milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, milocListener);
            }
        });
    }

    public class MiLocationListener implements LocationListener {

        public void onLocationChanged(Location loc) {
            TextView latitude = (TextView)findViewById(R.id.textView_Latitude);
            TextView lonxitude = (TextView)findViewById(R.id.textView_Lonxitude);
            loc.getLatitude();
            loc.getLongitude();
            latitude.setText("Latitude: "+loc.getLatitude());
            lonxitude.setText("Lonxitude: "+loc.getLongitude());
          //  String coordenadas = "Mis coordenadas son: " + "Latitud = " + loc.getLatitude() + "Longitud = " + loc.getLongitude();
          //  Toast.makeText(getApplicationContext(), coordenadas, Toast.LENGTH_LONG).show();
        }

        public void onProviderDisabled(String provider) {
            Toast.makeText(getApplicationContext(), "Gps Desactivado", Toast.LENGTH_SHORT).show();
        }

        public void onProviderEnabled(String provider) {
            Toast.makeText(getApplicationContext(), "Gps Activado", Toast.LENGTH_SHORT).show();
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
