package backend.facade;

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
	 * Metodo que retorna todos los departamentos
	 * 
	 * @return ret de tipo <b>Vector</b>
	 */
	public Collection<DepartamentoDTO> buscarTodosDepartamentos() {
		return depDAO.buscarTodosDepartamentos();
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
