package com.example.pruebas;



import basededatos.DataBaseManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.SearchView.OnQueryTextListener;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SearchView.OnQueryTextListener;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;


public class Buscar extends Activity{

DataBaseManager Manager;
String dato =null;
String tele=null;
	SearchView search;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        Manager=new DataBaseManager(this);
        
        search=(SearchView) findViewById(R.id.searchView1);
        search.setQueryHint("SearchView");
        
        //*** setOnQueryTextFocusChangeListener ***
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
		
		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
				
			Toast.makeText(getBaseContext(), String.valueOf(hasFocus),
				Toast.LENGTH_SHORT).show();
		}
	});
        
        //*** setOnQueryTextListener ***
        search.setOnQueryTextListener(new OnQueryTextListener() {
			
		@Override
		public boolean onQueryTextSubmit(String query) {
			// TODO Auto-generated method stub
				
		
			
			
			Cursor CursorUsuario=Manager.BuscarRelacion(query);

			if (CursorUsuario.moveToFirst()) {
				Manager.BuscarNumero();
						
						do {
							 tele= CursorUsuario.getString(1);
							} while (CursorUsuario.moveToNext());	
			}
			
			dato=tele;
			if(dato!=null){
				Toast.makeText(getBaseContext(), dato, Toast.LENGTH_SHORT).show();
			
			}else{
				Toast.makeText(getBaseContext(), "no hay registro", Toast.LENGTH_SHORT).show();
			}
			return false;
		}
		
		@Override
		public boolean onQueryTextChange(String newText) {
			// TODO Auto-generated method stub
				
//			Toast.makeText(getBaseContext(), newText,
//				Toast.LENGTH_SHORT).show();
			return false;
		}
	});
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }    
} 