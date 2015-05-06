package com.example.pruebas;


import basededatos.DataBaseManager;

import Adapter.Adapter;
import Adapter.Warter;
import Metodos.Metodos;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class Inicio extends Activity{
private DataBaseManager Manager;
Metodos util;

private ListView listView1;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.inicio);

	
	

		
        
        Warter weather_data[] = new Warter[]
        { 
            new Warter(R.drawable.ic_launcher, "Amigo 0"),
        	new Warter(R.drawable.ic_launcher, "Amigo 1"),
            new Warter(R.drawable.ic_launcher, "Amigo 2"),
            new Warter(R.drawable.ic_launcher, "Amigo 3"),
            new Warter(R.drawable.ic_launcher, "Amigo 4"),
            new Warter(R.drawable.ic_launcher, "Amigo 5")
        };
         Adapter adapter = new Adapter(this,R.layout.listview_item_row, weather_data);
        listView1 = (ListView)findViewById(R.id.listView1);
        View header = (View)getLayoutInflater().inflate(R.layout.listview_item_row, null);
        listView1.addHeaderView(header);
        listView1.setAdapter(adapter);
 
Manager=new DataBaseManager(this);
util=new Metodos();

String imeiBD = null;
ImageButton  btnconfig = (ImageButton ) findViewById(R.id.config);
ImageButton   btnmapa = (ImageButton ) findViewById(R.id.mapa);
ImageButton   btninicio = (ImageButton ) findViewById(R.id.incio);


	Cursor CursorUsuario=Manager.BuscarNumero();

if (CursorUsuario.moveToFirst()) {
	Manager.BuscarNumero();
			do {
				String	 numeroBD= CursorUsuario.getString(1);
				  imeiBD= CursorUsuario.getString(2);
			} while (CursorUsuario.moveToNext());
}
//Manager.InsertarAmigo("+56955555555","trabajo");
//Manager.InsertarAmigo("+56944444444","ropa");
TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
String imei= tm.getDeviceId();

if(imeiBD==null ){
	Intent i = new Intent (Inicio.this,ValidaNumero.class);
	startActivity(i);
}
/**botones**/
btnmapa.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			vibrar();
			startActivity (new Intent (Inicio.this,Mapa.class));
		}
  });

btnconfig.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
		  vibrar();
		  startActivity (new Intent (Inicio.this,Configuracion.class));
      }
});
btninicio.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
		  vibrar();
		  startActivity (new Intent (Inicio.this,Inicio.class));
      }
});
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
