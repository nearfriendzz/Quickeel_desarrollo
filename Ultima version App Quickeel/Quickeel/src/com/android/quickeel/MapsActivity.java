package com.android.quickeel;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;

public class MapsActivity extends MapActivity {


	LinearLayout searchPanel;
	    Button searchButton;
	    EditText searchText;
	    MapView mapView;
	    MapController mc;
	    Geocoder geoCoder;
	    private List<Overlay> mOverlays;
	    private MyLocationOverlay mOverlayLocation;
	    private MyItemizedOverlay itemizedOverlay;
	    
		 @Override
			protected void onPause() {
				// TODO Auto-generated method stub
				super.onPause();
			}


			@Override
			protected void onResume() {
				// TODO Auto-generated method stub
			
				super.onResume();
			}
	    
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState)
	    {
	    	setTheme(R.style.Holo_Theme_Sherlock_Light_NoActionBar);
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mapview);

	        searchPanel = (LinearLayout) findViewById(R.id.searchPanel);
	        searchPanel.setVisibility(View.VISIBLE);
	        searchButton = (Button) findViewById(R.id.searchButton);
	        searchText = (EditText) findViewById(R.id.searchText);
	      
	        mapView = (MapView) findViewById(R.id.mapView);
	        mapView.setBuiltInZoomControls(true);
	    
	    
	    mc = mapView.getController();
        geoCoder = new Geocoder(getBaseContext(), Locale.getDefault());
        mOverlayLocation = new MyLocationOverlay(this, mapView);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String searchFor = searchText.getText().toString();

                try {
                    List<Address> addresses =
                           geoCoder.getFromLocationName(searchFor, 5);
                    if (addresses.size() > 0) {
                        GeoPoint point = new GeoPoint(
                                (int) (addresses.get(0).getLatitude() * 1E6),
                                (int) (addresses.get(0).getLongitude() * 1E6)
                        );
                        mc.setCenter(point);
                        mc.setZoom(14);

                        // fetch the drawable - the pin that will be displayed on the map
                        Drawable drawable = getResources().getDrawable(R.drawable.new_location);

                        // create and add an OverlayItem to the MyItemizedOverlay list
                        OverlayItem overlayItem = new OverlayItem(point, "", "");

                        itemizedOverlay = new MyItemizedOverlay(drawable,this);
                        itemizedOverlay.addOverlay(overlayItem);

                        // add the overlays to the map
                        mapView.getOverlays().add(itemizedOverlay);

                       // mapView.invalidate();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
	    }
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
    
}
