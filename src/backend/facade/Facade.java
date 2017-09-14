package backend.facade;

import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.Collection;

import backend.dao.DepartamentoDAO;
import backend.dao.EmpleadoDAO;
import backend.dto.DepartamentoDTO;
import backend.dto.EmpleadoDTO;

public class Facade {
	// =============
	// Atributos
	// =============
	private DepartamentoDAO depDAO = null;

	private EmpleadoDAO emDAO = null;

	public Facade() {
		depDAO = new DepartamentoDAO();
		emDAO = new EmpleadoDAO();
	}

	// =============
	// Metodos
	// =============
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
	public void insertarDepartamento(DepartamentoDTO unDepDTO) throws SQLException, SQLTimeoutException {
		depDAO.insertarDepartamento(unDepDTO);
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
	public void modificarDepartamento(DepartamentoDTO unDepDTO) throws SQLException, SQLTimeoutException {
		depDAO.modificarDepartamento(unDepDTO);
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
	public void eliminarDepartamento(DepartamentoDTO unDepDTO) throws SQLException, SQLTimeoutException {
		depDAO.eliminarDepartamento(unDepDTO);
	}

	/**
	 * Metodo que retorna todos los departamentos
	 * 
	 * @return ret de tipo <b>Vector</b>
	 */
	public Collection<DepartamentoDTO> buscarTodosDepartamentos() {
		return depDAO.buscarTodosDepartamentos();
	}

	/**
	 * Metodo para insertar un empleado
	 * 
	 * @param unEmplDTO
	 *            empleado que se desea insertar
	 * @return <b>0</b> Si no se pudo insertar, <b>1</b> Si se pudo insertar
	 * @throws SQLException
	 *             Si ocurre un error al acceder a la base de datos
	 * @throws SQLTimeoutException
	 *             Cuando el tiempo de espera se ha superado
	 */
	public void insertarEmpleado(EmpleadoDTO unEmpDTO) throws SQLTimeoutException, SQLException {
		emDAO.insertarEmpleado(unEmpDTO);
	}

	/**
	 * Metodo para modificar un empleado.
	 * 
	 * @param unEmplDTO
	 *            empleado que se desea modificar.
	 * @return <b>0</b> Si no se pudo modificar, <b>1</b> Si se pudo modificar.
	 * @throws SQLException
	 *             Si ocurre un error al acceder a la base de datos.
	 * @throws SQLTimeoutException
	 *             Cuando el tiempo de espera se ha superado.
	 */
	public void modificarEmpleado(EmpleadoDTO unEmplDTO) throws SQLException, SQLTimeoutException {
		emDAO.modificarEmpleado(unEmplDTO);
	}

	/**
	 * Metodo para eliminar empleado.
	 * 
	 * @param unEmplDTO
	 *            empleado que se desea eliminar.
	 * @return <b>0</b> Si no se pudo eliminar, <b>1</b> Si se pudo eliminar.
	 * @throws SQLException
	 *             Si ocurre un error al acceder a la base de datos.
	 * @throws SQLTimeoutException
	 *             Cuando el tiempo de espera se ha superado.
	 */
	public void eliminarEmpleado(EmpleadoDTO unEmplDTO) throws SQLException, SQLTimeoutException {
		emDAO.eliminarEmpleado(unEmplDTO);
	}

	/**
	 * Metodo que retorna todos los empleados
	 * 
	 * @return ret de tipo <b>Vector</b>
	 */
	public Collection<EmpleadoDTO> buscarTodosEmpleados() {
		return emDAO.buscarTodosEmpleados();
	}

}
