package backend.dto;

public class EmpleadoDTO {
	// ==================
	// Atributos de la bd
	// ==================
	private int id;

	private String nombre;

	private String apellido;

	private String direccion;

	public EmpleadoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construye un empleado con sus caracteristicas
	 * 
	 * @param id
	 *            del empleado de tipo entero id != null
	 * @param nombre
	 *            del empleado de tipo cadena nombre != null
	 * @param apellido
	 *            del empleado de tipo cadena apellido != null
	 * @param direccion
	 *            del empleado de tipo cadena direccion != null
	 */
	public EmpleadoDTO(int id, String nombre, String apellido, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}

	// ==================
	// Metodos de la clase
	// ==================

	/**
	 * Retorna el id del empleado
	 * 
	 * @return <b>id</b> de tipo entero
	 */
	public int getId() {
		return id;
	}

	/**
	 * Agrega o modifica el id del empleado
	 * 
	 * @param id
	 *            del empleado de tipo entero id != null
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna el nombre del empleado
	 * 
	 * @return <b>nombre</b> de tipo cadena
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Agrega o modifica el nombre del empleado
	 * 
	 * @param nombre
	 *            del empleado de tipo cadena nombre != null
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna el apellido del empleado
	 * 
	 * @return <b>apellido</b> de tipo cadena
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Agrega o modifica el apellido del empleado
	 * 
	 * @param apellido
	 *            del empleado de tipo cadena apellido != null
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Retorna la direccion del empleado
	 * 
	 * @return <b>direccion</b> de tipo cadena
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Agrega o modifica la direccion del empleado
	 * 
	 * @param direccion
	 *            del empleado de tipo cadena direccion != null
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
