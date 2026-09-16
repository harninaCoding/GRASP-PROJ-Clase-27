package acop04externo;

public class Curva {
	private float arco;
	private float radio;

	public Curva(float arco, float radio) {
		super();
		this.arco = arco;
		this.radio = radio;
	}

	
	public float getArco() {
		return arco;
	}

	public void setArco(float arco) {
		this.arco = arco;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

}
