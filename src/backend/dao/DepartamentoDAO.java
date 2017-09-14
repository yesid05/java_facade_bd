package backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
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

	/**
	 * Metodo para insertar un departamento
	 * 
	 * @param unDepDTO
	 *            departamento que se desea insertar
	 * @return <b>0</b> Si no se pudo insertar, <b>1</b> Si se pudo insertar
	 * @throws SQLException
	 *             Si ocurre un error al acceder a la base de datos
	 * @throws SQLTimeoutException
	 *             Cuando el tiempo de espera se ha superado
	 */
	public int insertarDepartamento(DepartamentoDTO unDepDTO) throws SQLException, SQLTimeoutException {
		// respuesta por defecto 0 filas afectadas
		int respuesta = 0;
		try {
			// establece la conexion
			conexion = UConectar.darConexion();
			// define un query
			String sql = "";
			sql += "insert into " + BD_TABLA + " (" + BD_NOMBRE + ", " + BD_LOC + ") ";
			sql += "values(?,?)";

			// prepara el query a ejecutar
			pstm = conexion.prepareStatement(sql);

			// seteamos los valores de los parametros
			pstm.setString(1, unDepDTO.getNombre());
			pstm.setString(2, unDepDTO.getLoc());

			// ejecuta el query y guarda el resultado de filas afectadas en
			// respuesta
			respuesta = pstm.executeUpdate();

			// retorna la respuesta
			return respuesta;
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

	/**
	 * Metodo para modificar un departamento
	 * 
	 * @param unDepDTO
	 *            depatamento que se desea modificar
	 * @return <b>0</b> Si no se pudo modificar, <b>1</b> Si se pudo modificar
	 * @throws SQLException
	 *             Si ocurre un error al acceder a la base de datos
	 * @throws SQLTimeoutException
	 *             Cuando el tiempo de espera se ha superado
	 */
	public int modificarDepartamento(DepartamentoDTO unDepDTO) throws SQLException, SQLTimeoutException {
		// respuesta por defecto 0 filas afectadas
		int respuesta = 0;
		try {
			// establece la conexion
			conexion = UConectar.darConexion();
			// define un query
			String sql = "";
			sql += "update " + BD_TABLA + " ";
			sql += "set " + BD_NOMBRE + "  = ?, " + BD_LOC + " = ? ";
			sql += "where " + BD_ID + " = " + unDepDTO.getId();

			// prepara el query a ejecutar
			pstm = conexion.prepareStatement(sql);

			// seteamos los valores de los parametros
			pstm.setString(1, unDepDTO.getNombre());
			pstm.setString(2, unDepDTO.getLoc());

			// ejecuta el query y guarda el resultado de filas afectadas en
			// respuesta
			respuesta = pstm.executeUpdate();

			// retorna la respuesta
			return respuesta;
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

	/**
	 * Metodo para eliminar un departamento
	 * 
	 * @param unDepDTO
	 *            departamento que se desea eliminar
	 * @return <b>0</b> Si no se pudo eliminar, <b>1</b> Si se pudo eliminar.
	 * @throws SQLException
	 *             Si ocurre un error al acceder a la base de datos.
	 * @throws SQLTimeoutException
	 *             Cuando el tiempo de espera se ha superado.
	 */
	public int eliminarDepartamento(DepartamentoDTO unDepDTO) throws SQLException, SQLTimeoutException {
		// respuesta por defecto 0 filas afectadas
		int respuesta = 0;
		try {
			// establece la conexion
			conexion = UConectar.darConexion();
			// define un query
			String sql = "";
			sql += "delete from " + BD_TABLA + " ";
			sql += "where " + BD_NOMBRE + " = ? ";

			// prepara el query a ejecutar
			pstm = conexion.prepareStatement(sql);

			// seteamos los valores de los parametros
			pstm.setString(1, unDepDTO.getNombre());

			// ejecuta el query y guarda el resultado de filas afectadas en
			// respuesta
			respuesta = pstm.executeUpdate();

			// el autocommit es true por eso no es necesario
			// if (respuesta >= 1) {
			// conexion.commit();
			// } else {
			// throw new RuntimeException("Error...");
			// }

			// retorna la respuesta
			return respuesta;
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
