package myAccesov3DAO;

//Como asegurar que solo se usa para almacen de personas
public enum CriteriasEnumPersonas implements ByCriteria<Persona>{
	apellidos("apellidos",1),nombre("nombre",1);

	private String field;
	private int posicion;
	
	private CriteriasEnumPersonas(String field, int posicion) {
		this.field = field;
		this.posicion = posicion;
	}

	@Override
	public String getCampo() {
		return field;
	}

	@Override
	public Class<Persona> getEntityClass() {
		return Persona.class;
	}

	@Override
	public Integer getPosicion() {
		return posicion;
	}
	
}
