package backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import backend.conexion.UConectar;
import backend.dto.EmpleadoDTO;

public class EmpleadoDAO {
	// ==================
	// Atributos
	// ==================

	public static String BD_ID = "id";

	public static String BD_NOMBRE = "nombre";

	public static String BD_APELLIDO = "apellido";

	public static String BD_DIRECCION = "direccion";

	public static String BD_TABLA = "empleado";

	private Connection conexion = null;

	private PreparedStatement pstm = null;

	private ResultSet rs = null;

	// ==================
	// Atributos
	// ==================

	public Collection<EmpleadoDTO> buscarTodosEmpleados() {
		try {
			// establece la conexion
			conexion = UConectar.darConexion();
			// define un query
			String sql = "";
			sql += "select " + BD_ID + ", " + BD_NOMBRE + ", " + BD_APELLIDO + ", " + BD_DIRECCION + " ";
			sql += "from " + BD_TABLA;

			// prepara el query a ejecutar
			pstm = conexion.prepareStatement(sql);

			// ejecuta el query y guarda el resultado en rs
			rs = pstm.executeQuery();

			// crea una lista de empleados
			Vector<EmpleadoDTO> ret = new Vector<EmpleadoDTO>();
			EmpleadoDTO eDTO = null;

			// recorre los resultados
			while (rs.next()) {
				// contruye un empleado
				eDTO = new EmpleadoDTO();
				eDTO.setId(rs.getInt(BD_ID));
				eDTO.setNombre(rs.getString(BD_NOMBRE));
				eDTO.setApellido(rs.getString(BD_APELLIDO));
				eDTO.setDireccion(rs.getString(BD_DIRECCION));

				// agrega el empleado a la lista
				ret.add(eDTO);

			}
			// al finalizar retorna la lista
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		finally {
			try {
				// cierra todos los recursos en orden inverso en que fueron
				// adquiridos
				if (rs != null)
					rs.close();

				if (pstm != null)
					pstm.close();

			} catch (Exception e2) {

				e2.printStackTrace();
				throw new RuntimeException(e2);

			}
		}
	}
}
