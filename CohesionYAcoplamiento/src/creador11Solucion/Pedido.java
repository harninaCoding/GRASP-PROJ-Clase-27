package creador11Solucion;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Pedido {
	public String idPedido;
	public String datos_Pedido;
	public Cliente cliente;
	public Map<String, Float> lineas;
	
	
	public Pedido(String idPedido, Cliente cliente) {
		super();
		//Creo el objeto donde donde lo voy a usar y es intimo
		lineas=new HashMap<String, Float>();
		this.idPedido = idPedido;
		this.cliente = cliente;
	}
	
	private Float getTotal() {
		//Se puede usar porque no se modifica total
		float total=0;
		for (Entry<String,Float> entry : lineas.entrySet()) {
			total+=entry.getValue();
		}
		return total;
	}
	
	public Factura getFactura() {
		return new Factura(cliente,"20",getTotal());
	}
}
