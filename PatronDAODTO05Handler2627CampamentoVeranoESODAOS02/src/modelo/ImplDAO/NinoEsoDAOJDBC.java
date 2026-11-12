package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import mapper.NinoEsoMapper;
import modelo.AbstractDAO.NinoEsoDAO;
import modelo.Entity.NinoEso;
import modelo.acceso.AccessJdbc;

public class NinoEsoDAOJDBC implements NinoEsoDAO {
	private final AccessJdbc accessJdbc;
	private final NinoEsoMapper mapper = new NinoEsoMapper();

	public NinoEsoDAOJDBC(AccessJdbc accessJdbc) {
		this.accessJdbc = accessJdbc;
	}

	@Override
	public Optional<NinoEso> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<NinoEso> deleteById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean create(NinoEso entidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<NinoEso> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
