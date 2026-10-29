package modelo.ImplDAO;

import java.sql.SQLException;

import modelo.AbstractDAO.DaoFactory;
import modelo.acceso.AccessJdbc;

public class DAOFactoryJDBC extends DaoFactory {
	private AccessJdbc accessJdbc;
	
	public DAOFactoryJDBC() throws ClassNotFoundException, SQLException {
		super();
		// EStos parametros pueden ser pasado por parametros o configurados en otro
		// sitio
		accessJdbc = new AccessJdbc("ejemplo", "harnina", "zzzz");
	}

	
	

}
