package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.CabanaMapper;
import modelo.AbstractDAO.CabanaDAO;
import modelo.Entity.Cabana;
import modelo.acceso.AccessJdbc;

public class CabanaDAOJDBC implements CabanaDAO {
    private final AccessJdbc accessJdbc;
    private final CabanaMapper mapper = new CabanaMapper();

    public CabanaDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(Cabana entidad) {
        String sql = "INSERT INTO cabana (codigo_cabana, capacidad) VALUES (?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<Cabana> findAll() {
        String sql = "SELECT codigo_cabana, capacidad FROM cabana";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<Cabana> findById(String id) {
        String sql = "SELECT codigo_cabana, capacidad FROM cabana WHERE codigo_cabana = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<Cabana> deleteById(String id) {
        Optional<Cabana> cabana = findById(id);
        if (cabana.isPresent()) {
            String sql = "DELETE FROM cabana WHERE codigo_cabana = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return cabana;
    }
}
