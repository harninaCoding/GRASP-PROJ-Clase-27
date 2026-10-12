package myAccesov3DAO;

public class AlmacenBBDDJDBCPersonaDAO extends AlmacenBBDDJDBC<Persona,Integer> {

	CriteriasEnumPersonas criterias;
	public AlmacenBBDDJDBCPersonaDAO(String uRL_BASEDATOS, String user, String password) {
		super(uRL_BASEDATOS, user, password, new PersonaMapper()
				,Persona.class,"ID");
	}

	
	

	
}
