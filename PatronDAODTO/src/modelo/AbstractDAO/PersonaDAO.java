package modelo.AbstractDAO;

import java.util.Collection;

import modelo.Entity.Alumno;
import modelo.Entity.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer> {
	public Persona findByName(String name);
	
	
}
