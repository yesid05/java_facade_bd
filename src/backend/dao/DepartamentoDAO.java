package backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import backend.conexion.UConectar;
import backend.dto.DepartamentoDTO;

public class DepartamentoDAO {
	// =====================
	// Atributos
	// =====================

	public static String BD_ID = "id";

	public static String BD_NOMBRE = "nombre";

	public static String BD_LOC = "loc";

	public static String BD_TABLA = "departamento";

	private Connection conexion = null;

	private PreparedStatement pstm = null;

	private ResultSet rs = null;

	// =====================
	// Metodos
	// =====================

	/**
	 * Metodo que retorna todos los departamentos
	 * 
	 * @return ret de tipo <b>Vector</b>
	 */
	public Collection<DepartamentoDTO> buscarTodosDepartamentos() {
		try {
			// establece la conexion
			conexion = UConectar.darConexion();
			// define un query
			String sql = "";
			sql += "select " + BD_ID + ", " + BD_NOMBRE + ", " + BD_LOC + " ";
			sql += "from " + BD_TABLA;

			// prepara el query a ejecutar
			pstm = conexion.prepareStatement(sql);

			// ejecuta el query y guarda el resultado en rs
			rs = pstm.executeQuery();

			// crea una lista de departamentos
			Vector<DepartamentoDTO> ret = new Vector<DepartamentoDTO>();
			DepartamentoDTO dDTO = null;

			// recorre los resultados
			while (rs.next()) {
				// contruye un departamento
				dDTO = new DepartamentoDTO();
				dDTO.setId(rs.getInt(BD_ID));
				dDTO.setNombre(rs.getString(BD_NOMBRE));
				dDTO.setLoc(rs.getString(BD_LOC));

				// agrega el departamento a la lista
				ret.add(dDTO);

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
