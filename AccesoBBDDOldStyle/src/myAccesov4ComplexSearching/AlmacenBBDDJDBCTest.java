package myAccesov4ComplexSearching;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class AlmacenBBDDJDBCTest {

	@Test
	void testEjecutarConsulta() {
		AlmacenBBDDJDBC<Persona,Integer> almacenBBDDJDBC=new AlmacenBBDDJDBCPersonaDAO(
				"jdbc:mysql://localhost:3307/ejemplo"
				,"harnina"
				,"zzzz");
		List<Persona> ejecutarConsulta = almacenBBDDJDBC.getAll();
		System.out.println(ejecutarConsulta);
		Optional<Persona> byKey = almacenBBDDJDBC.getByKey(1);
		System.out.println(byKey.get());
		List<Persona> byApellidos = ((AlmacenBBDDJDBCPersonaDAO)almacenBBDDJDBC).getByApellidos("o");
		System.out.println(byApellidos);
	}

}
