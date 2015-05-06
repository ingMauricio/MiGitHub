package com.example.pruebas;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Configuracion extends Activity{
	private TextView textoCronometro;
	private GoogleMap mMap ;
	private Object str;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.config);
	    ImageView img = (ImageView)this.findViewById(R.id.imageView1);
	   	    Switch Ubicacion=(Switch) findViewById(R.id.switch2);
	    ImageButton  btnconfig = (ImageButton ) findViewById(R.id.config);
	    ImageButton   btnmapa = (ImageButton ) findViewById(R.id.mapa);
	    ImageButton   btninicio = (ImageButton ) findViewById(R.id.incio);
	     final TextView textestado =(TextView) findViewById(R.id.Estado);	   
	   
	    
	    /***Recibir Switch**/  
	

	    Ubicacion.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	    	 
	    	   @Override
	    	   public void onCheckedChanged(CompoundButton buttonView,
	    	     boolean isChecked) {
	    	 
	    	    if(isChecked){
	    	  Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();
	    		iniciar();
	    	    }else{
	    	    	  Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
	    	    	  parar();
	    	    }
	    	 
	    	   }
	    	  }); 
	    
	    
	    
	    
/***Recibir checkbox**/
	    final CheckBox cd= (CheckBox)findViewById(R.id.checkBox1);
	  	
	  cd.setOnCheckedChangeListener (
			  new CheckBox.OnCheckedChangeListener(){ 
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					if(isChecked){
						 Toast.makeText(getBaseContext(), "compartir ubicacion", Toast.LENGTH_LONG).show();

					}else{
						  Toast.makeText(getBaseContext(), "No compartir ubicacion", Toast.LENGTH_LONG).show(); 
						
						
					}
				}

			  });

	  
	  /**Botones menu**/
	  btnconfig.setOnClickListener(new View.OnClickListener() {
		  public void onClick(View v) {
		  		  vibrar();
		  		  startActivity (new Intent (Configuracion.this,Configuracion.class));
		        }
		  });

		  btnmapa.setOnClickListener(new View.OnClickListener() {
		  public void onClick(View v) {
		  		  vibrar();
		  		  startActivity (new Intent (Configuracion.this,Mapa.class));
		        }
		  });
		  btninicio.setOnClickListener(new View.OnClickListener() {
			  public void onClick(View v) {
			  		  vibrar();
			  		  startActivity (new Intent (Configuracion.this,Inicio.class));
			        }
			  });
		  
		  LocationManager locManager = (LocationManager)getSystemService(LOCATION_SERVICE);
		  if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			    Toast.makeText(getApplicationContext(), "desactivado", Toast.LENGTH_LONG).show();

				 
				 String texto ="";
				 texto = "Desactivado";
				 textestado.setText(texto);
		
			}else{
				   Toast.makeText(getApplicationContext(), "Activado", Toast.LENGTH_LONG).show();
				   
					 String texto ="";
					 texto = "Activado";
					 textestado.setText(texto);
			}
	
	}
	
	
	
	@Override
	protected void onDestroy() {
		// Antes de cerrar la aplicacion se para el servicio (el cronometro)
	
		super.onDestroy();
	}
	private void iniciar() {
		Intent service = new Intent(this, Servicio_Posicion.class);
		startService(service);
	}
	private void parar() {
		Intent service = new Intent(this, Servicio_Posicion.class);
		stopService(service);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus)
	{
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {	
			if (hasFocus) {
				getWindow().getDecorView().setSystemUiVisibility(
						View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
						| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_FULLSCREEN
						| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
				}
		}
	}
	public void vibrar(){
		Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		v.vibrate(100);
	}
	

	     

	
	
}
