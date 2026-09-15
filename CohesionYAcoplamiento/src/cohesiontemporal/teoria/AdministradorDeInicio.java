package cohesiontemporal.teoria;

import java.io.File;
import java.lang.System.Logger;

/**
 * Cohesion temporal. Al inicializar el sistema debemos hcer las cuatro tareas, pero no 
 * necesariamente en un orden concreto. Es su diferencia con la secuencial.
 * Tampoco tiene porque ser funcional o comunicacional.
 * Esta es la mejor de las peores cohesiones
 */
public class AdministradorDeInicio {
    private DatabaseConnection conexionBD;
    private Logger logger;
    private CacheManager cache;

    // Cohesion Temporal: agrupa tareas cuya uNICA relacion es ocurrir "al iniciar el sistema"
    public void inicializarSistema() {
        // Tarea 1: Cargar configuracion desde archivo
        System.setProperty("app.env", "production");
        
        // Tarea 2: Conectar a la base de datos
        this.conexionBD = new DatabaseConnection();
        this.conexionBD.conectar();

        // Tarea 3: Limpiar archivos temporales en disco
        File carpetaTemp = new File("/tmp/app");
        borrarArchivos(carpetaTemp);

        // Tarea 4: Enviar alerta por email al administrador
        ServicioEmail.notificarSystemUp("El servidor se ha iniciado correctamente.");
    }

    private void borrarArchivos(File carpeta) {
        //  borrar como sea lo que sea
    }
}