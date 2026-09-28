import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	public static void main(String[] args) {
		String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
		String URL_BASEDATOS = "jdbc:mysql://localhost:3307/ejemplo";

		// Esto es la carga del driver de acceso a mysql sgbd desde java
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Creamos una conexion
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL_BASEDATOS, "harnina", "zzzz");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ya ");
		// Una vez conectados pedimos al sgbd que genere una estructura
		// donde albergar la sentencia
		ResultSet conjuntoResultados = null;
		Statement instruccion = null;
		try {
			instruccion = conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Ejecutar la consulta concreta
		try {
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM persona");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("con consulta");
		ResultSetMetaData metaDatos = null;
		try {
			metaDatos = conjuntoResultados.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int numeroDeColumnas = 0;
		try {
			numeroDeColumnas = metaDatos.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("resultados");
		for (int i = 1; i <= numeroDeColumnas; i++) {
			try {
				System.out.printf("%-8s\t", new Object[] { metaDatos.getColumnName(i) });
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			System.out.println();
			while (conjuntoResultados.next()) {
				for (int j = 1; j <= numeroDeColumnas; j++)
					System.out.printf("%-8s\t", new Object[] { conjuntoResultados.getObject(j) });
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
