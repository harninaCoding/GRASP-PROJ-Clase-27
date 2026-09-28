package binarios033AdaptadoresAleatorioMapeoPersistenteBorradoMetodoUno;

import java.io.Serializable;
import java.util.HashMap;

public class AccesorRamdon implements Serializable{
	
	//habria que persistir el indice
	private HashMap<Integer, Long> indice=new HashMap<>();
	
	public Long get(int key) {
		return indice.get(key);
	}

	public Long remove(int key) {
		return indice.remove(key);
	}

	public int getPosicion() {
		return indice.size();
	}

	public Long put(Long value) {
		return indice.put(getPosicion(), value);
	}
		
}
