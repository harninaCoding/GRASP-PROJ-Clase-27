package modelo.ImplDAO;

import java.sql.SQLException;

import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.MonitorDAO;
import modelo.acceso.AccessJdbc;

public class DAOFactoryJDBC extends DaoFactory {
	private AccessJdbc accessJdbc;
	private final MonitorDAO monitorDAO;
	
	public DAOFactoryJDBC() throws ClassNotFoundException, SQLException {
		super();
		// EStos parametros pueden ser pasado por parametros o configurados en otro
		// sitio
		accessJdbc = new AccessJdbc("ejemplo", "harnina", "zzzz");
		this.monitorDAO = new MonitorDAOJDBC(accessJdbc);
	}

	//Los singleton son los daos
	@Override
	public MonitorDAO getMonitorDAO() {
		return this.monitorDAO;
	}

	
	

}
