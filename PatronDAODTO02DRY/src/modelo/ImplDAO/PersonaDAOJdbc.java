package modelo.ImplDAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collection;

import mapper.PersonaMapper;
import modelo.AbstractDAO.PersonaDAO;
import modelo.Entity.Persona;
import modelo.acceso.AccessJdbc;

public class PersonaDAOJdbc implements PersonaDAO {
// esto ya no se necesita, observa que el error estaria en la no DRY findAllDrying() 
//	private AccessJdbc accessJdbc;
	private final DAOFactoryJDBC daoFactoryJDBC;

	public PersonaDAOJdbc(DAOFactoryJDBC daoFactoryJDBC) {
		super();
		this.daoFactoryJDBC = daoFactoryJDBC;
//		this.accessJdbc = daoFactoryJDBC.accessJdbc;
	}

	@Override
	public void create(Persona entidad) {
		// TODO Auto-generated method stub
	}

	//Pendiente de aplicar DRY
//	@Override
	public Collection<Persona> findAllDrying() {
		ResultSet conjuntoResultados = accessJdbc.execute("SELECT * FROM persona");
		Collection<Persona> personas = new ArrayList<>();
		try {
			while (conjuntoResultados.next()) {
				personas.add(new PersonaMapper().map(conjuntoResultados));
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return personas;
	}
	@Override
	public Collection<Persona> findAll() {
		return daoFactoryJDBC.findAllGeneric("SELECT * FROM persona",new PersonaMapper());
	}

	@Override
	public Persona findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
