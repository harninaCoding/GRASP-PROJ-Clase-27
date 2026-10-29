package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.NinoPrimariaMapper;
import modelo.AbstractDAO.NinoPrimariaDAO;
import modelo.Entity.NinoPrimaria;
import modelo.acceso.AccessJdbc;

public class NinoPrimariaDAOJDBC implements NinoPrimariaDAO {
    private final AccessJdbc accessJdbc;
    private final NinoPrimariaMapper mapper = new NinoPrimariaMapper();

    public NinoPrimariaDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(NinoPrimaria entidad) {
        String sql = "INSERT INTO nino_primaria (numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo, codigo_cabana) VALUES (?, ?, ?, ?, ?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<NinoPrimaria> findAll() {
        String sql = "SELECT numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo, codigo_cabana FROM nino_primaria";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<NinoPrimaria> findById(Integer id) {
        String sql = "SELECT numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo, codigo_cabana FROM nino_primaria WHERE numero_nino = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<NinoPrimaria> deleteById(Integer id) {
        Optional<NinoPrimaria> nino = findById(id);
        if (nino.isPresent()) {
            String sql = "DELETE FROM nino_primaria WHERE numero_nino = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return nino;
    }
}
