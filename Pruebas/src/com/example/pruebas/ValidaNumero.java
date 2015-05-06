package com.example.pruebas;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import basededatos.DataBaseManager;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ValidaNumero extends Activity {
private DataBaseManager Manager;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validanumero);
        Manager = new DataBaseManager(this); 
     
        final EditText   numero = (EditText) findViewById(R.id.nombre);
    Button  btn = (Button) findViewById(R.id.button1);
    
    String  imeiBD="";
   

	Cursor CursorUsuario=Manager.BuscarNumero();

if (CursorUsuario.moveToFirst()) {
	Manager.BuscarNumero();
			do {
				String	 numeroBD= CursorUsuario.getString(1);
				  imeiBD= CursorUsuario.getString(2);
//Toast.makeText(getBaseContext(), numeroBD, Toast.LENGTH_LONG).show();
//Toast.makeText(getBaseContext(), imeiBD, Toast.LENGTH_LONG).show();
			} while (CursorUsuario.moveToNext());
}



TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
String imei= tm.getDeviceId();


if(imeiBD.equals(imei) ){
	Intent i = new Intent (ValidaNumero.this,Inicio.class);
	startActivity(i);
}  
    
    
    
  
    btn.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			
    		       
        String num = numero.getText().toString();
     Pattern patron = Pattern.compile("[^A-Za-z-@w./*;]");
     Matcher encaja = patron.matcher(num);
     String resultado=encaja.replaceAll("");
        if(resultado!="") { 
        	
        	 Toast.makeText(getBaseContext(), "Numero mal ingresado", Toast.LENGTH_LONG).show();
        }else if(num.startsWith("+569") && num.length() == 12){
//        		  Toast.makeText(getBaseContext(), num, Toast.LENGTH_LONG).show();
        		  TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        		  String imei= tm.getDeviceId();
        	Manager.Insertar(num,imei,null,null);
        	Intent i = new Intent (ValidaNumero.this,Inicio.class);
        	startActivity(i);
        }else{
        			Toast.makeText(getBaseContext(), "mal", Toast.LENGTH_LONG).show();
        		}
          }
    });
 
	}



 
	}
    
