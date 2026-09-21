package control14.control;

import control14.modelo.Persona;
import control14.modelo.PersonaRepositorio;

public class Controller {

	private PersonaRepositorio personaRepositorio=new PersonaRepositorio();

	public Persona buscaPersona(String nombre) {
		return personaRepositorio.findPersonaByName(nombre);
	}
}
