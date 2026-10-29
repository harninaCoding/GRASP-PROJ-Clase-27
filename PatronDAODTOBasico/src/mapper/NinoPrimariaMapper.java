package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Cabana;
import modelo.Entity.Grupo;
import modelo.Entity.NinoPrimaria;

public class NinoPrimariaMapper implements Mapper<ResultSet, NinoPrimaria> {

    @Override
    public NinoPrimaria map(ResultSet rs) {
        try {
            NinoPrimaria nino = new NinoPrimaria();
            nino.setNumeroNino(rs.getInt("numero_nino"));
            nino.setNombre(rs.getString("nombre"));
            nino.setApellidos(rs.getString("apellidos"));

            Date fechaNasc = rs.getDate("fecha_nacimiento");
            if (fechaNasc != null) {
                nino.setFechaNacimiento(fechaNasc.toLocalDate());
            }

            // Mapeo del Grupo
            Grupo grupo = new Grupo();
            grupo.setNumeroGrupo(rs.getInt("numero_grupo"));
            nino.setGrupo(grupo);

            // Mapeo de la Cabaña
            Cabana cabana = new Cabana();
            cabana.setCodigoCabana(rs.getString("codigo_cabana"));
            nino.setCabana(cabana);

            return nino;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}