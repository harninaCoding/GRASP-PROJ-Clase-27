package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.TiendaMapper;
import modelo.AbstractDAO.TiendaDAO;
import modelo.Entity.Tienda;
import modelo.acceso.AccessJdbc;

public class TiendaDAOJDBC implements TiendaDAO {
    private final AccessJdbc accessJdbc;
    private final TiendaMapper mapper = new TiendaMapper();

    public TiendaDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(Tienda entidad) {
        String sql = "INSERT INTO tienda (numero_tienda, capacidad) VALUES (?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<Tienda> findAll() {
        String sql = "SELECT numero_tienda, capacidad FROM tienda";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<Tienda> findById(Integer id) {
        String sql = "SELECT numero_tienda, capacidad FROM tienda WHERE numero_tienda = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<Tienda> deleteById(Integer id) {
        Optional<Tienda> tienda = findById(id);
        if (tienda.isPresent()) {
            String sql = "DELETE FROM tienda WHERE numero_tienda = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return tienda;
    }
}
