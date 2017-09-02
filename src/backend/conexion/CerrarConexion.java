package backend.conexion;

import java.sql.Connection;

public class CerrarConexion extends Thread {
	//justo antes de finalizar el programa jvm invocara
	//este metodo donde podemos cerrar la conexion
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			Connection con = UConectar.darConexion();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
