package cohesionprocedimental.teoria;

public class PublicadorDeBlog {
	private String titulo;
    private String contenido;

    public PublicadorDeBlog(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    // Cohesion Procedimental: Controla un algoritmo de pasos estrictos
    public void publicar() {
        validarReglasDeComunidad(); // Paso 1
        guardarEnBaseDeDatos();      // Paso 2 (No recibe nada del Paso 1)
        notificarAFormatosRSS();     // Paso 3 (No recibe nada del Paso 2)
        limpiarCacheDePagina();      // Paso 4 (No recibe nada del Paso 3)
    }

    private void validarReglasDeComunidad() {
        if (contenido.contains("palabraProhibida")) {
            throw new IllegalArgumentException("Contenido no permitido");
        }
    }

    private void guardarEnBaseDeDatos() {
        System.out.println("Guardando en BD: " + titulo);
    }

    private void notificarAFormatosRSS() {
        System.out.println("Actualizando feed RSS...");
    }

    private void limpiarCacheDePagina() {
        System.out.println("Cache invalidada.");
    }
}
