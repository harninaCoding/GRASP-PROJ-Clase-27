package myAccesov1Lambda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PersonaMapper implements Mapper<Persona> {

	@Override
	public Optional<Persona> map(ResultSet conjuntoResultados) {
		try {
			return Optional.of(new Persona(conjuntoResultados.getInt(1), 
					conjuntoResultados.getString(2),
					conjuntoResultados.getString(3)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

}
