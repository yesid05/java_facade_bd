package frontend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import backend.conexion.UConectar;
import backend.dao.DepartamentoDAO;
import backend.dao.EmpleadoDAO;
import backend.dto.DepartamentoDTO;
import backend.dto.EmpleadoDTO;
import backend.facade.Facade;

public class Main {

	public static void main(String[] args) {
		
		Facade facade = new Facade();
		
		DepartamentoDTO unDepDTO = new DepartamentoDTO();
		unDepDTO.setNombre("Pasteleria");
		unDepDTO.setLoc("Neiva");
		
		EmpleadoDTO unEmplDTO = new EmpleadoDTO();
		unEmplDTO.setNombre("yesid");
		unEmplDTO.setApellido("caicedo añazco");
		unEmplDTO.setDireccion("calle 25n 5a 26");
		
		
		try {
			facade.insertarDepartamento(unDepDTO);
			facade.insertarEmpleado(unEmplDTO);
		} catch (SQLException e) {
			System.out.println("error en la bd");
			e.printStackTrace();
		}
		
		Collection<DepartamentoDTO> listaDepDTO = facade.buscarTodosDepartamentos();
		
		for(DepartamentoDTO depDTO:listaDepDTO){
			System.out.println("id: "+depDTO.getId());
			System.out.println("Nombre: "+depDTO.getNombre());
			System.out.println("Locación: "+depDTO.getLoc());
		}
		
		
		
		Collection<EmpleadoDTO> listaEmpDTO = facade.buscarTodosEmpleados();
		
		for(EmpleadoDTO empDTO:listaEmpDTO){
			System.out.println("id: "+empDTO.getId());
			System.out.println("nombre: "+empDTO.getNombre());
			System.out.println("apellido: "+empDTO.getApellido());
			System.out.println("dirección: "+empDTO.getDireccion());
		}
		
	}

}
