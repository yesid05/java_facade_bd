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

public class Main {

	public static void main(String[] args) {
		
		DepartamentoDAO depDAO = new DepartamentoDAO();
		
		Collection<DepartamentoDTO> coll = depDAO.buscarTodosDepartamentos();
		
		for(DepartamentoDTO dto:coll){
			
			System.out.println("Id: "+dto.getId());
			System.out.println("Locación: "+dto.getLoc());
			System.out.println("Nombre: "+dto.getNombre());
		}
		
		EmpleadoDAO emDAO = new EmpleadoDAO();
		
		Collection<EmpleadoDTO> colemp = emDAO.buscarTodosEmpleados();
		
		for(EmpleadoDTO emDTO:colemp){
			
			System.out.println("id: "+ emDTO.getId());
			System.out.println("Nombre: "+emDTO.getNombre());
			System.out.println("Apeliido: "+emDTO.getApellido());
			System.out.println("Direccion: "+emDTO.getDireccion());
			
		}

	}

}
