package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Actividad;
import modelo.Entity.Grupo;
import modelo.Entity.GrupoActividadMonitor;
import modelo.Entity.Monitor;

public class GrupoActividadMonitorMapper implements Mapper<ResultSet, GrupoActividadMonitor> {

    @Override
    public GrupoActividadMonitor map(ResultSet rs) {
        try {
            Grupo grupo = new Grupo();
            grupo.setNumeroGrupo(rs.getInt("numero_grupo"));

            Actividad actividad = new Actividad();
            actividad.setCodigoActividad(rs.getString("codigo_actividad"));

            Monitor monitor = new Monitor();
            monitor.setDni(rs.getString("dni_monitor"));

            return new GrupoActividadMonitor(grupo, actividad, monitor);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}