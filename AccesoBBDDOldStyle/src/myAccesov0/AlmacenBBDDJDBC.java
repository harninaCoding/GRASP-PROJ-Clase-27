package myAccesov0;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlmacenBBDDJDBC {
	private static String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private String URL_BASEDATOS;
	private Connection conexion = null;

	public AlmacenBBDDJDBC(String uRL_BASEDATOS, String user, String password) {
		super();
		URL_BASEDATOS = uRL_BASEDATOS;

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

	public List<Persona> getAll() {
		// Una vez conectados pedimos al sgbd que genere una estructura
		// donde albergar la sentencia
		ResultSet conjuntoResultados = null;
		Statement instruccion = null;
		try {
			instruccion = conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Ejecutar la consulta concreta
		try {
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM persona");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ArrayList<Persona> retorno=new ArrayList();
			System.out.println();
			while (conjuntoResultados.next()) {
				Persona persona=new Persona(conjuntoResultados.getInt(1),conjuntoResultados.getString(2),conjuntoResultados.getString(3));
				retorno.add(persona);
			}
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
