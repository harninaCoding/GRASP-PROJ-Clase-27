package myAccesov2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlmacenBBDDJDBC<T, K> {
	private static String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private String URL_BASEDATOS;
	private Connection conexion = null;
	private Mapper<T> mapper;
	private Class<T> clase;

	public AlmacenBBDDJDBC(String uRL_BASEDATOS, String user, String password, Mapper<T> mapper, Class<T> clase) {
		super();
		URL_BASEDATOS = uRL_BASEDATOS;
		this.mapper = mapper;
		this.clase = clase;
		try {
			conexion = DriverManager.getConnection(URL_BASEDATOS, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static {
		// Esto es la carga del driver de acceso a mysql sgbd desde java
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Optional<T> getByKey(K key) {
		String sql = "Select * FROM " + clase.getSimpleName() + "Where " + fieldName + " like ?";
		 try (PreparedStatement statement = conexion.prepareStatement(sql)) {
			 statement.setObject(1, key);
		 }
	}

	public List<T> getAll() {
		ArrayList<T> retorno = new ArrayList();
		try (Statement instruccion = conexion.createStatement();
			ResultSet conjuntoResultados = instruccion.executeQuery("SELECT * FROM " + clase.getSimpleName());
			) {
			while (conjuntoResultados.next()) {
				mapper.map(conjuntoResultados).ifPresent(retorno::add);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

}
