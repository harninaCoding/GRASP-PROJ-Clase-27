package myAccesov1SinNombrador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlmacenBBDDJDBC<T> {
	private static String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private String URL_BASEDATOS;
	private Connection conexion = null;
	private Mapper<T> mapper;
	private Class<T> clase;

	public AlmacenBBDDJDBC(String uRL_BASEDATOS, String user, 
			String password,Mapper<T> mapper,Class<T> clase) {
		super();
		URL_BASEDATOS = uRL_BASEDATOS;
		this.mapper=mapper;
		this.clase=clase;
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

	public List<T> getAll() {
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
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM "+clase.getSimpleName());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ArrayList<T> retorno=new ArrayList();
			System.out.println();
			while (conjuntoResultados.next()) {
				mapper.map(conjuntoResultados).ifPresent(retorno::add);
			}
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
