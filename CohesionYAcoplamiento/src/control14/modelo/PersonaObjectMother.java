package control14.modelo;

import java.util.ArrayList;
import java.util.List;

public class PersonaObjectMother {

	public static List<Persona> getPersonas() {
		ArrayList<Persona> mPersonas=new ArrayList<>();
		mPersonas.add(new Persona("angelito", 2000f));
		mPersonas.add(new Persona("luisito", 1000f));
		mPersonas.add(new Persona("abundio"));
		return mPersonas;
	}

}
