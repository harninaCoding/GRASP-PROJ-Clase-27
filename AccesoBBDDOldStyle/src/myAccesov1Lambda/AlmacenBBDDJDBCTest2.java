package myAccesov1Lambda;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class AlmacenBBDDJDBCTest2 {

	@Test
	void testEjecutarConsulta() {
		AlmacenBBDDJDBC<Persona> almacenBBDDJDBC=new AlmacenBBDDJDBC(
				"jdbc:mysql://localhost:3307/ejemplo"
				,"harnina"
				,"zzzz"
				,(rs)->{
					try {
						return Optional.of(new Persona(rs.getInt(1), 
								rs.getString(2),
								rs.getString(3)));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return Optional.empty();
				}
				,()->{return "persona";});
		List<Persona> ejecutarConsulta = almacenBBDDJDBC.getAll();
		System.out.println(ejecutarConsulta);
	}

}
