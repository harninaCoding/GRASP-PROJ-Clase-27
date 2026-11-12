package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Grupo;
import modelo.Entity.Nino;

public class NinoMapper implements Mapper<ResultSet, Nino> {

    @Override
    public Nino map(ResultSet rs) {
        try {
            Nino nino = new Nino();
            nino.setNumeroNino(rs.getInt("numero_nino"));
            nino.setNombre(rs.getString("nombre"));
            nino.setApellidos(rs.getString("apellidos"));
            Date fechaNasc = rs.getDate("fecha_nacimiento");
            if (fechaNasc != null) {
                nino.setFechaNacimiento(fechaNasc.toLocalDate());
            }
            // Mapeo del Grupo (LAZY)
            Grupo grupo = new Grupo();
            grupo.setNumeroGrupo(rs.getInt("numero_grupo"));
            nino.setGrupo(grupo);

            return nino;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object[] toInsertParams(Nino nino) {
        return new Object[] {
                nino.getNumeroNino(),
                nino.getNombre(),
                nino.getApellidos(),
                nino.getFechaNacimiento() != null ? Date.valueOf(nino.getFechaNacimiento()) : null,
                nino.getGrupo().getNumeroGrupo()
        };
    }

}
