package creador11Solucion;

public class Factura {
	public Cliente cliente;
	public String id_Factura;
	public Float Total;
	
	public Factura(Cliente cliente, String id_Factura, Float total) {
		super();
		this.cliente = cliente;
		this.id_Factura = id_Factura;
		Total = total;
	}
	
	
}
