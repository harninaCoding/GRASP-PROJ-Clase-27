package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.NinoEsoMapper;
import modelo.AbstractDAO.NinoDAO;
import modelo.AbstractDAO.NinoEsoDAO;
import modelo.Entity.Nino;
import modelo.Entity.NinoEso;
import modelo.acceso.AccessJdbc;

public class NinoEsoDAOJDBC implements NinoEsoDAO {
	private final AccessJdbc accessJdbc;
	private final NinoEsoMapper mapper = new NinoEsoMapper();
	private final NinoDAO ninoDAO;

	public NinoEsoDAOJDBC(AccessJdbc accessJdbc, NinoDAO ninoDAO) {
		this.accessJdbc = accessJdbc;
		this.ninoDAO = ninoDAO;
	}

	@Override
	public Optional<NinoEso> findById(Integer id) {
		String sql = "SELECT numero_nino, numero_tienda FROM nino_eso WHERE numero_nino = ?";
		Optional<NinoEso> ninoEso = accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
		if (ninoEso != null && ninoEso.isPresent()) {
			// Yo quiero solucionar el problema del lazy
			Optional<Nino> ninoBase = ninoDAO.findById(id);
			if (ninoBase != null && ninoBase.isPresent()) {
				ninoEso.get().setBase(ninoBase.get());
				return ninoEso;
			}
		}
		return Optional.empty();
	}

	@Override
	public Optional<NinoEso> deleteById(Integer id) {
		// TODO Auto-generated method stub

		return Optional.empty();
	}

	@Override
	public boolean create(NinoEso entidad) {
		   boolean b = ninoDAO.create(entidad);
	        int filas = 0;
	        if (b) {
	            String sqlNinoEso = "INSERT INTO nino_eso (numero_nino, numero_tienda) VALUES ( ?, ?)";
	            filas = accessJdbc.executeUpdate(sqlNinoEso, mapper.toInsertParams(entidad));
	        }
	        return filas > 0 && b;
	}

	 //el problema de consultas N+1 se centraria aqui. encontrar todos los ninoESo me obligaria a hacer una consulta 
    //al DAO nino por cada ninoESO
	@Override
	public Collection<NinoEso> findAll() {
		String sql="Select numero_nino, numero_tienda FROM nino_eso";
		Collection<NinoEso> executeQuery = accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
		return executeQuery;
		//por cada objeto lazy necesito una consulta al dao del padre
	}

}
