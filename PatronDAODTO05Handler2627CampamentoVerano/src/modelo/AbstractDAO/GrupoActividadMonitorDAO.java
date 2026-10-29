package modelo.AbstractDAO;

import java.util.Collection;

import modelo.Entity.GrupoActividadMonitor;

public interface GrupoActividadMonitorDAO {
    public boolean create(GrupoActividadMonitor entidad);
    public Collection<GrupoActividadMonitor> findAll();
    public boolean deleteByKeys(Integer numeroGrupo, String codigoActividad, String dniMonitor);
}

