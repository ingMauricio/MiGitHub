package basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DataBaseManager {
	
	private SQLiteDatabase db;
	private DBHelper helper;

	public DataBaseManager(Context context) {
		helper = new DBHelper(context);
		db = helper.getWritableDatabase();
	}

	public void open() {
		db = helper.getWritableDatabase();
	}

	public void close() {
		helper.close();
	}


/**************Creacion de la tabla donde se almacena los usuarios Reservas************************/
	public static final String TABLA_USUARIO ="USUARIO";
	public static final String C_ID = "_id";
	public static final String C_NUMERO = "numero";
    public static final String C_IMEI = "imei";
    public static final String C_LALITUDE="Latitude";
    public static final String C_LONGITUDE="Longitude";
/***************Tabla Amigos*********************************************************/
    public static final String TABLA_AMIGOS ="AMIGOS";
	public static final String C_ID_A = "_id";
	public static final String C_NUMERO_A = "numero";
	public static final String C_DETALLE_A= "detalle";
 
	/************************************************************/
	public static final String CREATE_USUARIO = "create table " + TABLA_USUARIO
			+ " (" + C_ID + " integer primary key, "
			+   C_NUMERO + " text, "
			+ C_IMEI + " text, "
			+ C_LALITUDE + " text,"
			+ C_LONGITUDE + " text );";

	
	public static final String CREATE_AMIGOS = "create table " + TABLA_AMIGOS
			+ " (" + C_ID_A+ " integer primary key, "
			+   C_NUMERO_A + " text, "
			+ C_DETALLE_A + " text);";
	
	/************************************************************/
	public void Insertar(String numero,String imei,String Latitude,String Longitude) {

		ContentValues valores = new ContentValues();
		valores.put(C_NUMERO, numero);
		valores.put(C_IMEI, imei);
		valores.put(C_LALITUDE, Latitude);
		valores.put(C_LONGITUDE, Longitude);
	
			db.insert(TABLA_USUARIO, null, valores);
	}
	

	public void InsertarAmigo(String numero,String detalle) {

		ContentValues valores = new ContentValues();
		valores.put(C_NUMERO_A, numero);
		valores.put(C_DETALLE_A, detalle);
		db.insert(TABLA_AMIGOS, null, valores);
	}
	/****************************************/
	public void ActualizarConexion(String Latitude,String Longitude,String imei) {
		ContentValues valores = new ContentValues();
		valores.put(C_LALITUDE, Latitude);
		valores.put(C_LONGITUDE, Longitude);
		valores.put(C_IMEI, imei);

		db.update(TABLA_USUARIO, valores, C_IMEI + "=" + "3", null);
	}
	

/*******Muestra los datos con la lista checkBox*************/
	public Cursor BuscarNumero() {
		Cursor c = db.rawQuery("SELECT * From USUARIO", null);
		return c;
	}
	
	public Cursor BuscarRelacion(String detalle) {
		Cursor c = db.rawQuery("SELECT * From AMIGOS WHERE detalle='"+detalle+"' ", null);
		return c;
	}


	/**********************Borrar Tabla********************/
	 public void deleteUsuariosSi(){
		  db.delete(TABLA_USUARIO," _id < 100 ",  null);
		 }

}