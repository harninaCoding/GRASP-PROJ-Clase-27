package control14.modelo;

import java.util.List;

public class PersonaRepositorio {

	List<Persona> personas;

	public PersonaRepositorio() {
		super();
		personas = PersonaObjectMother.getPersonas();
	}

	public Persona findPersonaByName(String nombre) {
		assert(nombre!=null&&!nombre.isEmpty()):"nombre no valido";
		for (Persona persona : personas) {
			if (persona.getNombreString().equals(nombre))
				return persona;
		}
		return null;
	}

	public boolean add(Persona e) {
		assert(e!=null):"valor de persona invalido";
		return personas.add(e);
	}
	
}
