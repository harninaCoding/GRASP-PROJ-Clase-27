package binarios032AdaptadoresAleatorioMapeo;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable{
	private int numero;
	private String nombre;
	private boolean preferente;
	private float saldo;
	public Cliente(int numero, String nombre, boolean preferente, float saldo) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.preferente = preferente;
		this.saldo = saldo;
	}
	public int getNumero() {
		return numero;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre, numero, preferente, saldo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nombre, other.nombre) && numero == other.numero && preferente == other.preferente
				&& Float.floatToIntBits(saldo) == Float.floatToIntBits(other.saldo);
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isPreferente() {
		return preferente;
	}
	public void setPreferente(boolean preferente) {
		this.preferente = preferente;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Cliente [numero=" + numero + ", nombre=" + nombre + ", preferente=" + preferente + ", saldo=" + saldo
				+ "]";
	}
	
}
