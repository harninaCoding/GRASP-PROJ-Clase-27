package invencionpura07a;

public class PajaroEnfadadoProblema
{
    public void Volar()
    {
    }

    //este metodo hace que la clase dependa mucho del interfaz de consola
    public void MostrarConsola()
    {
        System.out.println("no soy un pajaro enfadado");
    }
    
    public void MostrarError() {
    	System.err.println(" si que estoy enfadado");
    }
}