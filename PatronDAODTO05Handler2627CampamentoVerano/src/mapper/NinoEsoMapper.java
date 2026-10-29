package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Grupo;
import modelo.Entity.NinoEso;
import modelo.Entity.Tienda;


public class NinoEsoMapper implements Mapper<ResultSet, NinoEso> {

    @Override
    public NinoEso map(ResultSet rs) {
        try {
            NinoEso nino = new NinoEso();
            nino.setNumeroNino(rs.getInt("numero_nino"));
            nino.setNombre(rs.getString("nombre"));
            nino.setApellidos(rs.getString("apellidos"));
            
            Date fechaNasc = rs.getDate("fecha_nacimiento");
            if (fechaNasc != null) {
                nino.setFechaNacimiento(fechaNasc.toLocalDate());
            }

            // Mapeo del Grupo (si viene en la consulta)
            Grupo grupo = new Grupo();
            grupo.setNumeroGrupo(rs.getInt("numero_grupo"));
            nino.setGrupo(grupo);

            // Mapeo de la Tienda (si viene en la consulta)
            Tienda tienda = new Tienda();
            tienda.setNumeroTienda(rs.getInt("numero_tienda"));
            nino.setTienda(tienda);

            return nino;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object[] toInsertParams(NinoEso nino) {
        return new Object[] {
            nino.getNumeroNino(),
            nino.getNombre(),
            nino.getApellidos(),
            nino.getFechaNacimiento() != null ? Date.valueOf(nino.getFechaNacimiento()) : null,
            nino.getGrupo() != null ? nino.getGrupo().getNumeroGrupo() : null,
            nino.getTienda() != null ? nino.getTienda().getNumeroTienda() : null
        };
    }
}