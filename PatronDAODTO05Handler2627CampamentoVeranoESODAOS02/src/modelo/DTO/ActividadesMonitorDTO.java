package modelo.DTO;

import java.util.Collection;

//cuando es un DTO, puede ser inmutable
public class ActividadesMonitorDTO {
	private String nombreMonitor;
	private Collection<String> actividades;
	public ActividadesMonitorDTO(String nombreMonitor, Collection<String> actividades) {
		super();
		this.nombreMonitor = nombreMonitor;
		this.actividades = actividades;
	}
	public String getNombreMonitor() {
		return nombreMonitor;
	}
	public void setNombreMonitor(String nombreMonitor) {
		this.nombreMonitor = nombreMonitor;
	}
	public Collection<String> getActividades() {
		return actividades;
	}
	public void setActividades(Collection<String> actividades) {
		this.actividades = actividades;
	}
	
}
