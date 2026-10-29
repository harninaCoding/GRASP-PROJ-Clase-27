package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
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
    public boolean create(NinoEso entidad) {
        String sql = "INSERT INTO nino_eso (numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo, numero_tienda) VALUES (?, ?, ?, ?, ?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<NinoEso> findAll() {
        String sql = "SELECT numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo, numero_tienda FROM nino_eso";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<NinoEso> findById(Integer id) {
        String sql = "SELECT numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo, numero_tienda FROM nino_eso WHERE numero_nino = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<NinoEso> deleteById(Integer id) {
        Optional<NinoEso> nino = findById(id);
        if (nino.isPresent()) {
            String sql = "DELETE FROM nino_eso WHERE numero_nino = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return nino;
    }
}
