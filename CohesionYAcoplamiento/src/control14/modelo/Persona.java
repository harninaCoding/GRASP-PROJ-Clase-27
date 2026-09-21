package control14.modelo;

import java.util.Objects;

public class Persona {
	// propiedades
	// obligatorias
	private String nombreString;
	// opcionales
	private Float salario;

	// contructores
	public Persona(String nombreString) {
		super();
		this.setNombreString(nombreString);
		this.salario=0f;
	}

	public Persona(String nombreString, Float salario) {
		this(nombreString);
		this.setSalario(salario);
	}

	// get&setters
	String getNombreString() {
		return nombreString;
	}

	private Float getSalario() {
		return salario;
	}

	private void setSalario(Float salario) {
		assert (salario > 0) : "cantidad no correcta";
		this.salario = salario;
	}

	private void setNombreString(String nombreString) {
		assert (nombreString != null) : "nombre no valido";
		this.nombreString = nombreString;
	}

	@Override
	public String toString() {
		return "Persona [nombreString=" + nombreString + ", salario=" + salario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreString, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nombreString, other.nombreString) && Objects.equals(salario, other.salario);
	}

	
}
