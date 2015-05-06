package com.example.pruebas;


import java.io.File;
import java.util.Locale;


import basededatos.DataBaseManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Camara extends Activity {
   //Necesitamos un Boton y un imageView
   private Button bt_hacerfoto;  
   private ImageView img; 
 private DataBaseManager Manager;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.camara);
      

      
 
      //Relacionamos con el XML
      Button  btnmapa = (Button) findViewById(R.id.mapa);
      img = (ImageView)this.findViewById(R.id.imageView1);
      bt_hacerfoto = (Button) this.findViewById(R.id.button1);
      //Añadimos el Listener Boton
      bt_hacerfoto.setOnClickListener(new View.OnClickListener() {
          	  
    	  @Override
      public void onClick(View v) {
         //Creamos el Intent para llamar a la Camara
         Intent cameraIntent = new Intent(
            android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
         //Creamos una carpeta en la memeria del terminal
         File imagesFolder = new File(
            Environment.getExternalStorageDirectory(), "Tutorialeshtml5");
         imagesFolder.mkdirs();   
         //añadimos el nombre de la imagen
         File image = new File(imagesFolder, "foto.jpg"); 
         Uri uriSavedImage = Uri.fromFile(image);
         //Le decimos al Intent que queremos grabar la imagen
         cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
         //Lanzamos la aplicacion de la camara con retorno (forResult)
         startActivityForResult(cameraIntent, 1);
         }});
      
      
      
      
   
   }

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
         //Comprovamos que la foto se a realizado
         if (requestCode == 1 && resultCode == RESULT_OK) {  
  //Creamos un bitmap con la imagen recientemente 
         //almacenada en la memoria
            Bitmap bMap = BitmapFactory.decodeFile(
              Environment.getExternalStorageDirectory()+
                 "/Tutorialeshtml5/"+"foto.jpg");
            //Añadimos el bitmap al imageView para 
            //mostrarlo por pantalla
            img.setImageBitmap(bMap);        
 } 
    }
   public void m(){
	     Manager = new DataBaseManager(this);  
	      
	   	Cursor CursorUsuario=Manager.BuscarNumero();

	     if (CursorUsuario.moveToFirst()) {
	 		Manager.BuscarNumero();
	 				do {
	 					 String	 num= CursorUsuario.getString(1);
//	 	Toast.makeText(getBaseContext(), num, Toast.LENGTH_LONG).show();
	 	} while (CursorUsuario.moveToNext());
	 }  
   }
}