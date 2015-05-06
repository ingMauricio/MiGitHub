package basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	private static final String DB_NAME = "DatosWS.sqlite";
	private static final int DB_SCHEME_VERSION = 1;

	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_SCHEME_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		

		db.execSQL(DataBaseManager.CREATE_USUARIO);
		db.execSQL(DataBaseManager.CREATE_AMIGOS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("delete table if exists " + DataBaseManager.TABLA_USUARIO);
		onCreate(db);

	}
}

	
