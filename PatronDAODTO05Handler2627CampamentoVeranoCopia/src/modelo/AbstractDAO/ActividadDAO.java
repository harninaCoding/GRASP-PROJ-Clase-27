package modelo.AbstractDAO;

import java.util.Collection;
import java.util.List;

import modelo.Entity.Actividad;

public interface ActividadDAO extends GenericDAO<Actividad, String> {

	Collection<Actividad> findAllById(List<String> codigosActividades);
}

