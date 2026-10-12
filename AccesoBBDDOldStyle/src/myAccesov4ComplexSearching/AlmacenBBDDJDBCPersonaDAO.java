package myAccesov4ComplexSearching;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlmacenBBDDJDBCPersonaDAO extends AlmacenBBDDJDBC<Persona,Integer> {

	public AlmacenBBDDJDBCPersonaDAO(String uRL_BASEDATOS, String user, String password) {
		super(uRL_BASEDATOS, user, password, new PersonaMapper()
				,Persona.class,"ID");
	}
	
	public List<Persona> getByApellidos(String apellidos) {
		List<Persona> lista = new ArrayList<>();
		String sql = "Select * FROM " + clase.getSimpleName() + " Where " + "apellidos" + " like ?";
		try (PreparedStatement statement = conexion.prepareStatement(sql)) {
			statement.setObject(1, "%"+apellidos+"%");
			try (ResultSet rs = statement.executeQuery()) {
				while(rs.next()) {
					mapper.map(rs).ifPresent(lista::add);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return lista;
	}

	
}
