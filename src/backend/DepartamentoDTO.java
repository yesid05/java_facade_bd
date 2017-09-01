package backend;

public class DepartamentoDTO {
	// =====================
	// Atributos de la bd
	// =====================
	private int id;

	private String nombre;

	private String loc;

	public DepartamentoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construye un departamento con sus caracteristicas
	 * 
	 * @param id
	 *            del departamento de tipo entero id != null
	 * @param nombre
	 *            del departamento de tipo cadena nombre != null
	 * @param loc
	 *            del departamento de tipo cadena loc != null
	 */
	public DepartamentoDTO(int id, String nombre, String loc) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.loc = loc;
	}

	// =====================
	// Atributos de la bd
	// =====================
	/**
	 * Retorna el id del departamento
	 * @return <b>id</id> de tipo entero
	 */
	public int getId() {
		return id;
	}

	/**
	 * Agrega o modifica el id del departamento
	 * @param id del departamento de tipo entero id != null
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna el nombre del departamento
	 * @return <b>nombre</b> de tipo cadena
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Agrega o modifica el nombre del departamento
	 * @param nombre del departamento de tipo cadena nombre != null
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna la locacion del departamento
	 * @return <b>loc</b> de tipo cadena 
	 */
	public String getLoc() {
		return loc;
	}

	/**
	 * Agrega o modifica la locacion del departamento
	 * @param loc del departamento de tipo cadena loc != null
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

}
