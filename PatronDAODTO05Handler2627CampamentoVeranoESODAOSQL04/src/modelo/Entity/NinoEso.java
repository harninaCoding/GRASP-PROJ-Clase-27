package modelo.Entity;

import java.time.LocalDate;
import java.util.Optional;

public class NinoEso extends Nino {
	private Tienda tienda;

	public NinoEso() {
		super();
	}

	public NinoEso(Integer numeroNino, String nombre, String apellidos, LocalDate fechaNacimiento, Grupo grupo,
			Tienda tienda) {
		super(numeroNino, nombre, apellidos, fechaNacimiento, grupo);
		this.tienda = tienda;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public void setBase(Nino ninoBase) {
		setNombre(ninoBase.getNombre());
		setApellidos(ninoBase.getApellidos());
		setFechaNacimiento(ninoBase.getFechaNacimiento());
		setGrupo(ninoBase.getGrupo());
	}
}