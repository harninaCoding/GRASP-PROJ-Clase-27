package cohesioncomunicacional.teoria;

/**
 * Cohesion comunicacional o de datos: todas los modulos trabajan sobre los mismos datos
 * pero no realizan funciones que se relacionen entre ellas semanticamente, es decir, realizan
 * acciones de distinta naturaleza.
 * No es funcional por eso y no es secuencial porque los modulos son independientes
 */
public class ReporteEmpleado {
    private final Empleado empleado; // La estructura de datos compartida

    public ReporteEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    // Opera sobre 'empleado'
    public String generarEncabezadoHTML() {
        return "<h1>" + empleado.getNombre() + " - " + empleado.getPuesto() + "</h1>";
    }

    // Opera sobre 'empleado' 
    public double calcularSalarioAnualConBonos() {
        return (empleado.getSalarioBase() * 12) + empleado.getBonoAnual();
    }

    // Opera sobre 'empleado'
    public String exportarDatosContactoVCard() {
        return "BEGIN:VCARD\nFN:" + empleado.getNombre() + "\nTEL:" + empleado.getTelefono() + "\nEND:VCARD";
    }
}