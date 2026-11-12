package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;
import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.NinoMapper;
import modelo.AbstractDAO.NinoDAO;
import modelo.Entity.Nino;
import modelo.acceso.AccessJdbc;

public class NinoDAOJDBC implements NinoDAO {

    protected final AccessJdbc accessJdbc;
    protected final NinoMapper mapper = new NinoMapper();

    public NinoDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(Nino entidad) {
        String sql = "INSERT INTO nino (numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo) VALUES (?,?, ?, ?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<Nino> findAll() {
        String sql = "SELECT numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo FROM nino";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<Nino> findById(Integer id) {
        String sql = "SELECT numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo FROM nino WHERE numero_nino = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<Nino> deleteById(Integer id) {
        Optional<Nino> nino = findById(id);
        if (nino.isPresent()) {
            // El DELETE en la tabla padre 'nino' elimina en cascada (ON DELETE CASCADE) en
            // la tabla hija
            String sql = "DELETE FROM nino WHERE numero_nino = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return nino;
    }
}