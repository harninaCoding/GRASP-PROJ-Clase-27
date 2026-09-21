package creador11Solucion;

public class Prueba {

	public static void main(String[] args) {
		Cliente yo=new Cliente("Luis");
		Pedido uno=new Pedido("1",yo);
		Factura fac=uno.getFactura();

	}

}
