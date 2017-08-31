package frontend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import backend.UConectar;

public class Main {

	public static void main(String[] args) {
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		UConectar conexion = new UConectar();
		con = conexion.darConexion();
		
		String sql = "select * from departamento";
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println("Nombre: "+rs.getString("nombre"));
				System.out.println("Local: "+rs.getString("loc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
