package myAccesov1SinNombrador;
import java.util.List;

import org.junit.jupiter.api.Test;

class AlmacenBBDDJDBCTest {

	@Test
	void testEjecutarConsulta() {
		AlmacenBBDDJDBC<Persona> almacenBBDDJDBC=new AlmacenBBDDJDBC(
				"jdbc:mysql://localhost:3307/ejemplo"
				,"harnina"
				,"zzzz"
				,new PersonaMapper()
				,Persona.class);
		List<Persona> ejecutarConsulta = almacenBBDDJDBC.getAll();
		System.out.println(ejecutarConsulta);
	}

}
