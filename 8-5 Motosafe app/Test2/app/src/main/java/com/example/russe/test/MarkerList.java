package com.example.russe.test;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class MarkerList extends Activity {

    private FusedLocationProviderClient mFusedLocationClient;

    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;

    public static final ArrayList<Marker> locData = new ArrayList<Marker>();

    public ArrayList<Marker> getList() {
        return locData;
    }


    public void getLocation() {

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        final double[] latti = {0.0};
        final double[] longi = {0.0};


        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        latti[0] = location.getLatitude();
                        longi[0] = location.getLongitude();
                        if (location != null) {
                            // Logic to handle location object
                        }
                    }
                });

        Marker newMarker = new Marker(latti[0], longi[0]);
        locData.add(newMarker);
    }

    //@Override
   /* public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode)
        {
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/
}
