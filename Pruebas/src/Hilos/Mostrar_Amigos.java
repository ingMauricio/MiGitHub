package Hilos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import org.xmlpull.v1.XmlPullParserException;


import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.ImageView;



public class Mostrar_Amigos  extends AsyncTask<Void, Void, Void> {

		String UID = "";
		String EstadoUID = "";
		String IdFuncionario = "";
		String Nombres = "";
		String Apellidos = "";
		String NombreEmpresa = "";
		String IdEmpresa = "";
		String Autorizacion = "";
		String Certificacion = "";
		String AutorizacionConductor = "";
		String Ost = "";
		String TipoPase = "";
		String Lote = "";
		String CCosto = "";
		String Mensaje = "";
		String FIniPase = "";
		String FFinPase = "";
		String Idsync = "";
		int ContadorMax = 0;
		int ContadorErrores;
		String _Respuesta;
		JSONObject _RespuestaJson;
		Exception _Exception = null;
		String Restantes = "";

//		String Rut, Id, METHOD_NAME, SOAP_ACTION, NAMESPACE, URL, UsuarioWs,
//				Division, ContraseniaWs, Autentificacion, EstadoSync, TipoSync,
//				TipoSincronizacion, Idioma, Toast1, Toast2, Toast3, Toast4, Toast5,
//				Toast6, Toast7, Toast8, Toast9, Toast10;
//
//		MetodosGenerales util;
//		private DataBaseManager Manager;
//		Context c;
//		String tipo_Conexion3gWIFI;
//		ImageView img;

//		public Persona(Context contexto, ImageView imagenFoto) {
//			img = imagenFoto;
//			c = contexto;
//			util = new MetodosGenerales();
//			Manager = new DataBaseManager(c);
//			Cursor CursorTipoConexion = Manager.CursorTipoConexion();
//			if (CursorTipoConexion.moveToFirst()) {
//				tipo_Conexion3gWIFI = CursorTipoConexion.getString(0);
//			}
//
//			if (tipo_Conexion3gWIFI.equalsIgnoreCase("INTERNET")) {
//				Cursor CursorWs = Manager.CursorConfig();
//
//				if (CursorWs.moveToFirst()) {
//					do {
//						NAMESPACE = CursorWs.getString(1);
//						URL = CursorWs.getString(2);
//						UsuarioWs = CursorWs.getString(3); // desarrollo
//						ContraseniaWs = CursorWs.getString(4); // Desa1.
//						Autentificacion = CursorWs.getString(5);
//						Division = CursorWs.getString(7);
//					} while (CursorWs.moveToNext());
//
//				}
//			} else {
//				Cursor CursorWs = Manager.CursorConfigIntranet();
//
//				if (CursorWs.moveToFirst()) {
//					do {
//						NAMESPACE = CursorWs.getString(1);
//						URL = CursorWs.getString(2);
//						UsuarioWs = CursorWs.getString(3); // desarrollo
//						ContraseniaWs = CursorWs.getString(4); // Desa1.
//						Autentificacion = CursorWs.getString(5);
//						Cursor c = Manager.CursorConfig();
//						if (c.moveToFirst()) {
//							Division = c.getString(7);
//						}
//					} while (CursorWs.moveToNext());
//
//				}
//			}
//
//		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			// super.onPreExecute();
//			Cursor VerColorFoto = Manager.CursorCambiarFoto();
//			if (VerColorFoto.moveToFirst()) {
//
//				Manager.ActualizarColorFoto("azul");
//
//			} else {
//				Manager.InsertarColorFoto("azul");
//			}
//
//			if (tipo_Conexion3gWIFI.equalsIgnoreCase("INTERNET")) {
//				Cursor CursorSincronizacion = Manager.CursorSincronizacionPersona();
//
//				if (CursorSincronizacion.moveToFirst()) {
//					do {
//						Id = CursorSincronizacion.getString(1);
//						ContadorErrores = CursorSincronizacion.getInt(2);
//
//					} while (CursorSincronizacion.moveToNext());
//
//				}
//			} else {
//				Cursor CursorSincronizacion = Manager
//						.CursorSincronizacionPersonaIntranet();
//
//				if (CursorSincronizacion.moveToFirst()) {
//					do {
//						Id = CursorSincronizacion.getString(1);
//						ContadorErrores = CursorSincronizacion.getInt(2);
//
//					} while (CursorSincronizacion.moveToNext());
//
//				}
//
//			}
//			
//			Cursor contador = Manager.CursorValorContador();
//			if(!contador.moveToFirst()){
//				Manager.InsertarValorContador("0");
//			}else{
//				ContadorMax =  contador.getInt(0);
//			}
//
		}

		@Override
		protected Void doInBackground(Void... params) {
			return null;
			// TODO Auto-generated method stub
//			METHOD_NAME = "WSSincronizarPersona";
//			SOAP_ACTION = NAMESPACE + "WSSincronizarPersona";
//			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
//
//			request.addProperty("idsincronizacion", Id);
//			request.addProperty("imei", util.getIMEI(c));
//			request.addProperty("Division", Division);
//
//			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//					SoapEnvelope.VER11); // la version de WS 1.1
//			envelope.dotNet = true; // estamos utilizando .net
//			envelope.setOutputSoapObject(request);
//			HttpTransportSE transporte = new HttpTransportSE(URL);
//
//			try {
//				if (Autentificacion.equals("SI")) {
//					// *****
//					List<HeaderProperty> headerList = new ArrayList<HeaderProperty>();
//					String Conexion = UsuarioWs + ":" + ContraseniaWs;
//					headerList.add(new HeaderProperty("Authorization",
//							"Basic "
//									+ org.kobjects.base64.Base64.encode(Conexion
//											.getBytes())));
//					transporte.call(SOAP_ACTION, envelope, headerList);
//					// /*****
//				} else {
//					transporte.call(SOAP_ACTION, envelope);
//				}
//
//				SoapPrimitive resultado = (SoapPrimitive) envelope.getResponse();
//
//				_Respuesta = resultado.toString();
//				_RespuestaJson = new JSONObject(_Respuesta);
//
//				UID = _RespuestaJson.getString("UID");
//				EstadoUID = _RespuestaJson.getString("EstadoUID");
//				IdFuncionario = _RespuestaJson.getString("IdFuncionario"); // 081493251
//				Nombres = _RespuestaJson.getString("Nombres"); // MIGUEL ANTONIO
//				Apellidos = _RespuestaJson.getString("Apellidos");
//				NombreEmpresa = _RespuestaJson.getString("NombreEmpresa");
//				IdEmpresa = _RespuestaJson.getString("IdEmpresa");
//				Autorizacion = _RespuestaJson.getString("AutorizacionPase");
//				AutorizacionConductor = _RespuestaJson
//						.getString("AutorizacionConductor");
//				Certificacion = _RespuestaJson.getString("Certificacion");
//				Mensaje = _RespuestaJson.getString("Mensaje");
//				Ost = _RespuestaJson.getString("Ost");
//				TipoPase = _RespuestaJson.getString("TipoPase");
//				Lote = _RespuestaJson.getString("Lote");
//				FIniPase = _RespuestaJson.getString("FIniPase");
//				FFinPase = _RespuestaJson.getString("FFinPase");
//				CCosto = _RespuestaJson.getString("CCosto");
//				Idsync = _RespuestaJson.getString("IdSincronizacion");
//				Restantes = _RespuestaJson.getString("Restantes");
//
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				_Exception = e;
//				// e.printStackTrace();
//			} catch (XmlPullParserException e) {
//				// TODO Auto-generated catch block
//				_Exception = e;
//				// e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				_Exception = e;
//			}
//			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub

//			if (!Restantes.equals("null")) {
//
//				int datosrestantes = (Integer.parseInt(Restantes));
//
//				if (_Exception == null) {
//
//					if (Integer.parseInt(Idsync) != 0) {
//
//						Manager.ActualizarSincronizacionPersona(IdFuncionario,
//								Idsync, 0, "ON", "INICIAL");
//
//						Cursor CursorFuncionario = Manager
//								.BuscarFuncionarioId(IdFuncionario,Lote);
//						if (CursorFuncionario.moveToFirst()) {
//							int id = Manager.devolveridFuncionario(IdFuncionario);
//							Manager.ActualizarDataFuncionario(UID, EstadoUID,
//									IdFuncionario, Nombres, Apellidos,
//									NombreEmpresa, IdEmpresa, Autorizacion,
//									AutorizacionConductor, Certificacion, Mensaje,
//									Ost, TipoPase, Lote, FIniPase, FFinPase,
//									CCosto,Idsync, id);
//							
//							Manager.InsertarDatosLog(IdFuncionario, "Funcionario Actualizado", util.getFecha(), util.getHora());
//
//						} else {
//							Manager.InsertarDatosFuncionario(UID, EstadoUID,
//									IdFuncionario, Nombres, Apellidos,
//									NombreEmpresa, IdEmpresa, Autorizacion,
//									AutorizacionConductor, Certificacion, Mensaje,
//									Ost, TipoPase, Lote, FIniPase, FFinPase, CCosto,Idsync);
//							
//							ContadorMax++;
//							Manager.ActualizarValorContador(String.valueOf(ContadorMax));
//							
//							Manager.InsertarDatosLog(IdFuncionario, "Funcionario Guardado", util.getFecha(), util.getHora());
//						}
//
//					} else {
//						if (!Idsync.equals("0")) {
//							Manager.ActualizarSincronizacionPersona(IdFuncionario,
//									Idsync, 0, "OFF", "INICIAL");
//						}
//
//					}
//					
//					if (ContadorMax < 150) {
//						new Persona(c, img).execute();
//						//ContadorMax=0;
//					}else{
//						
//						new Persona(c, img).cancel(true);
//						Manager.ActualizarValorContador("0");
//
//						new Vehiculos(c, img).execute();
//					}
//					
//				} else {
//					if (ContadorErrores >= 5) {
//
//						Manager.ActualizarContadorSincronizacion(0, "OFF",
//								"INICIAL");
//
//					} else {
//
//						Manager.ActualizarContadorSincronizacion(
//								(ContadorErrores + 1), "ON", "INICIAL");
//
//						new Persona(c, img).execute();
//					}
//				}
//			} else {
//
//				new Vehiculos(c, img).execute();
//
//			}
//
		}

	}