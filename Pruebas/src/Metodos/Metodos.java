package Metodos;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.pruebas.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

public class Metodos  {

	
	

	public String getFecha() {
		String FechaHora = getDateTime();
		String Fecha = FechaHora.substring(0, 10);
		String Hora = FechaHora.substring(11, FechaHora.length());
	
		Fecha = Fecha.replace("/", "");
		return Fecha;
	}
	public String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		return dateFormat.format(date);

	}
	


	

}
