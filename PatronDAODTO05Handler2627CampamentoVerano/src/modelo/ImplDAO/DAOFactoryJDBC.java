package modelo.ImplDAO;

import java.sql.SQLException;
import modelo.AbstractDAO.*;
import modelo.acceso.AccessJdbc;

public class DAOFactoryJDBC extends DaoFactory {
	private final AccessJdbc accessJdbc;

	// Instancias únicas (Singleton) de cada DAO
	private final ActividadDAO actividadDAO;
	private final CabanaDAO cabanaDAO;
	private final GrupoDAO grupoDAO;
	private final MonitorDAO monitorDAO;
	private final TiendaDAO tiendaDAO;
	private final NinoEsoDAO ninoEsoDAO;
	private final NinoPrimariaDAO ninoPrimariaDAO;
	private final GrupoActividadMonitorDAO grupoActividadMonitorDAO;

	public DAOFactoryJDBC() throws ClassNotFoundException, SQLException {
		super();
		this.accessJdbc = new AccessJdbc("ejemplo", "harnina", "zzzz");

		// Se instancian solo una vez, por lo que son singleton
		this.actividadDAO = new ActividadDAOJDBC(accessJdbc);
		this.cabanaDAO = new CabanaDAOJDBC(accessJdbc);
		this.grupoDAO = new GrupoDAOJDBC(accessJdbc);
		this.monitorDAO = new MonitorDAOJDBC(accessJdbc);
		this.tiendaDAO = new TiendaDAOJDBC(accessJdbc);
		this.ninoEsoDAO = new NinoEsoDAOJDBC(accessJdbc);
		this.ninoPrimariaDAO = new NinoPrimariaDAOJDBC(accessJdbc);
		this.grupoActividadMonitorDAO = new GrupoActividadMonitorDAOJDBC(accessJdbc);
	}

	@Override
	public ActividadDAO getActividadDAO() {
		return actividadDAO; // Devuelve siempre la misma instancia
	}

	@Override
	public CabanaDAO getCabanaDAO() {
		return cabanaDAO;
	}

	@Override
	public GrupoDAO getGrupoDAO() {
		return grupoDAO;
	}

	@Override
	public MonitorDAO getMonitorDAO() {
		return monitorDAO;
	}

	@Override
	public TiendaDAO getTiendaDAO() {
		return tiendaDAO;
	}

	@Override
	public NinoEsoDAO getNinoEsoDAO() {
		return ninoEsoDAO;
	}

	@Override
	public NinoPrimariaDAO getNinoPrimariaDAO() {
		return ninoPrimariaDAO;
	}

	@Override
	public GrupoActividadMonitorDAO getGrupoActividadMonitorDAO() {
		return grupoActividadMonitorDAO;
	}
}