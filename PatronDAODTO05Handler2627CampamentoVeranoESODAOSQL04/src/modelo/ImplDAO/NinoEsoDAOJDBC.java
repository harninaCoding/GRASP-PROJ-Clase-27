package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.NinoEsoMapper;
import mapper.NinoMapper;
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
		   String sql = "SELECT n.numero_nino, n.nombre, n.apellidos, n.fecha_nacimiento, n.numero_grupo, ne.numero_tienda " +
                   "FROM nino_eso ne " +
                   "INNER JOIN nino n ON ne.numero_nino = n.numero_nino " +
                   "WHERE ne.numero_nino = ?";
      return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
	}

	@Override
	public Optional<NinoEso> deleteById(Integer id) {
		// TODO Auto-generated method stub

		return Optional.empty();
	}

	@Override
	public boolean create(NinoEso entidad) {
		// 1. Insertamos primero en la tabla padre 'nino'
        String sqlNino = "INSERT INTO nino (numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo) VALUES (?, ?, ?, ?, ?)";
        int filasNino = accessJdbc.executeUpdate(sqlNino, new NinoMapper().toInsertParams(entidad));

        // 2. Si se insertó correctamente en 'nino', insertamos en la tabla hija 'nino_eso'
        if (filasNino > 0) {
            String sqlNinoEso = "INSERT INTO nino_eso (numero_nino, numero_tienda) VALUES (?, ?)";
            int filasNinoEso = accessJdbc.executeUpdate(sqlNinoEso, mapper.toInsertParams(entidad));
            
            // Si fallara la segunda inserción y no usas transacciones, convendría revertir la primera:
            if (filasNinoEso == 0) {
                accessJdbc.executeUpdate("DELETE FROM nino WHERE numero_nino = ?", entidad.getNumeroNino());
                return false;
            }
            return true;
        }
        return false;  
	}

	@Override
	public Collection<NinoEso> findAll() {
		String sql = "SELECT n.numero_nino, n.nombre, n.apellidos, n.fecha_nacimiento, n.numero_grupo, ne.numero_tienda " +
                "FROM nino_eso ne " +
                "INNER JOIN nino n ON ne.numero_nino = n.numero_nino";
   return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
	}

}
