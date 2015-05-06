package com.example.pruebas;

import java.util.Timer;
import java.util.TimerTask;

import basededatos.DataBaseManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Service;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class Servicio_Posicion extends Service  {
DataBaseManager Manager;

	

 
	@Override
	public void onCreate() {
		super.onCreate();
		Manager=new DataBaseManager(this);
//		iniciarCronometro();
		setUpMap();

	}
 
	@Override
	public void onDestroy() {
		pararCronometro();
		super.onDestroy();
	}
 
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
 
	private void iniciarCronometro() {
		
	}
 
	private void pararCronometro() {

	}
	private void setUpMap(){
//		Toast.makeText(getBaseContext(),util.getDateTime(), Toast.LENGTH_LONG).show();
	
	  LocationManager localLocationManager = (LocationManager)getSystemService("location");
	  Location localLocation = localLocationManager.getLastKnownLocation(localLocationManager.getBestProvider(new Criteria(), true));
	  
	  try{
		  double d1 = localLocation.getLatitude();
		  double d2 = localLocation.getLongitude();
		  String Latitude = String.valueOf(d1); 
		  String Longitude = String.valueOf(d2); 
		  TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
		  String imei= tm.getDeviceId();
		  Manager.ActualizarConexion(Latitude, Longitude, imei);
		 Toast.makeText(getApplicationContext(), Latitude, Toast.LENGTH_LONG).show();
		 Toast.makeText(getApplicationContext(), Longitude, Toast.LENGTH_LONG).show();

	  }catch(RuntimeException ex){
		  Toast.makeText(getApplicationContext(), "error Ubicacion ", Toast.LENGTH_LONG).show();
	  }
	 
	  


	}
 
}