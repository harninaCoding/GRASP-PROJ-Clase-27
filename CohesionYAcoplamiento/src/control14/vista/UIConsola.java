package control14.vista;

import control14.control.Controller;
import control14.modelo.Persona;

public class UIConsola {

	public static void main(String[] args) {
	Controller controller=new Controller();	
	System.out.println("voy a buscar un usuario y luego voy a meter uno");
	String nombre="luisito";
	Persona persona=controller.buscaPersona(nombre);
	System.out.println(persona.toString());
	}

}
