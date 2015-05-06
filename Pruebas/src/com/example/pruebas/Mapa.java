package com.example.pruebas;



import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



import Metodos.Metodos;
import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;


public class Mapa extends android.support.v4.app.FragmentActivity {
	   private GoogleMap mMap ;
	   private Object str;
	   private Metodos util;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
      requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		 WindowManager.LayoutParams.FLAG_FULLSCREEN);
         setContentView(R.layout.mapa);

   ubicacion();
   marker();

    ImageButton  btnsearch = (ImageButton ) findViewById(R.id.search);
    ImageButton   btnmapa = (ImageButton ) findViewById(R.id.mapa);
    ImageButton   btninicio = (ImageButton ) findViewById(R.id.incio);
   btninicio.setOnClickListener(new OnClickListener() {
	   public void onClick(View v) {
		 vibrar();
		startActivity (new Intent (Mapa.this,Inicio.class));
	 }
  });
   
   btnsearch.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
		  vibrar();
		  startActivity (new Intent (Mapa.this,Buscar.class));
      }
  });

   btnmapa.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
		  vibrar();
		  startActivity (new Intent (Mapa.this,Mapa.class));
      }
  });
  }
//@Override
//public void onWindowFocusChanged(boolean hasFocus)
//{
//	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {	
//		if (hasFocus) {
//			getWindow().getDecorView().setSystemUiVisibility(
//					View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//					| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//					| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//					| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//					| View.SYSTEM_UI_FLAG_FULLSCREEN
//					| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//			}
//	}
//}




private void ubicacion()
{
  if (this.mMap == null)
  {
    this.mMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
    if (this.mMap != null)
      setUpMap();
  }
}
private void setUpMap(){
//	Toast.makeText(getBaseContext(),util.getDateTime(), Toast.LENGTH_LONG).show();
  this.mMap.setMyLocationEnabled(true);
  LocationManager localLocationManager = (LocationManager)getSystemService("location");
  Location localLocation = localLocationManager.getLastKnownLocation(localLocationManager.getBestProvider(new Criteria(), true));
  this.mMap.setMapType(1);
  try{
	  double d1 = localLocation.getLatitude();
	  double d2 = localLocation.getLongitude();
	  String Latitude = String.valueOf(d1); 
	  String Longitude = String.valueOf(d2); 
	 Toast.makeText(getApplicationContext(), Latitude, Toast.LENGTH_LONG).show();
	 Toast.makeText(getApplicationContext(), Longitude, Toast.LENGTH_LONG).show();
	  LatLng localLatLng = new LatLng(d1, d2);
	  this.mMap.moveCamera(CameraUpdateFactory.newLatLng(localLatLng));
	  this.mMap.animateCamera(CameraUpdateFactory.zoomTo(11.0F));
	  String srt="hola";
	  this.str=str;
	  this.mMap.addMarker(new MarkerOptions().position(new LatLng(d1, d2)).title(srt));
  }catch(RuntimeException ex){
	  Toast.makeText(getApplicationContext(), "error Ubicacion ", Toast.LENGTH_LONG).show();
  }
 
  
////De double a String 
//cadena = String.valueOf(valor); 
//
////De String a double 
//otroValor = Double.parseDouble(cadena); 

}


public void marker()
{
  this.mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener()
  {
    public void onInfoWindowClick(Marker paramAnonymousMarker)
    {
      paramAnonymousMarker.getTitle();
      str = paramAnonymousMarker.getTitle();
      if (str.equals("hola"))
      {
    	  Toast.makeText(getBaseContext(), "Prueba", Toast.LENGTH_LONG).show();
      
        return;
      }
      
    }
  });
}
	


public void posicion1(){
    mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();//Instanciamos el objeto mMap a partir del MapFragment definido bajo el Id "map"
    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);// se eligue el tipo de mapa que se mostrara
    final LatLng CAM = new LatLng(-33.491675, -70.624875);//informacion ndel market sacada de la web de google map
    Marker cam = mMap.addMarker(new MarkerOptions()//se agrega una nueva posicion 
                              .position(CAM)// posicion que se encuentra en ciu 
                              .title("N 1412")// titulo de el market 
                              .snippet("San joaquin - Puente alto")//comentarios 
    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); //Color del marcador
    
}

private void setUpMapIfNeeded() {
	   mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	   	if (mMap == null) {
	      mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	      if (mMap != null) {
	        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	        mMap.setMyLocationEnabled(true);
	      }
	   }
	}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    return true;
}
public void vibrar(){
	Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
	v.vibrate(100);
}



}