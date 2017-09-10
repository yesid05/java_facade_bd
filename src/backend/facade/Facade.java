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
	 * Metodo que retorna todos los departamentos
	 * 
	 * @return ret de tipo <b>Vector</b>
	 */
	public Collection<DepartamentoDTO> buscarTodosDepartamentos() {
		return depDAO.buscarTodosDepartamentos();
	}
	
	
	public void insertarEmpleado(EmpleadoDTO unEmpDTO) throws SQLTimeoutException, SQLException{
		emDAO.insertarEmpleado(unEmpDTO);
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
