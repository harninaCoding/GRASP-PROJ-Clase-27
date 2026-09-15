package cohesionfuncional.teoria;


//EN POO esto tambien es cohesion funcional porque todas las funciones trabajan sobre el mismo conjunto de datos
//y realizan funciones de naturaleza parecida
public class CalculadoraEstadistica {
    private double[] datos;

    public CalculadoraEstadistica(double[] datos) throws Exception {
        if (datos == null || datos.length == 0)
            throw new Exception("El conjunto de datos no puede estar vacio.");
        
        datos = datos;
    }

    public double CalcularPromedio() {
        double suma = 0;
        for (Double x: datos) suma += x;
        return suma / datos.length;
    }

    public double CalcularVarianza() {
        double promedio = CalcularPromedio(); // Reutiliza la funcion del mismo dominio
        double sumaDiferenciasCuadradas = 0;
        
        for (Double x: datos) {
            sumaDiferenciasCuadradas += Math.pow(x - promedio, 2);
        }
        
        return sumaDiferenciasCuadradas / datos.length;
    }

    public double CalcularDesviacionEstandar() {
        return Math.sqrt(CalcularVarianza()); // Depende directamente de la varianza
    }
}