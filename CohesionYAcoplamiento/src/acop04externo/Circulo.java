package acop04externo;

import java.util.Iterator;

public class Circulo implements Iterable<Circulo>{
	private float radio;

	public Circulo(float radio) {
		super();
		this.radio = radio;
	}

	public float getRadio() {
		return radio;
	}
	
	public float getPerimetro() {
		return 2*Constantes.PI*radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	public float calculaArea(){
		return radio;
		
	}

	@Override
	public Iterator<Circulo> iterator() {
		return this.iterator();
	}
}
