import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class AlmacenBBDDJDBCTest {

	@Test
	void testEjecutarConsulta() {
		AlmacenBBDDJDBC almacenBBDDJDBC=new AlmacenBBDDJDBC("jdbc:mysql://localhost:3307/ejemplo","harnina","zzzz");
		List<Persona> ejecutarConsulta = almacenBBDDJDBC.getAll();
		System.out.println(ejecutarConsulta);
	}

}
