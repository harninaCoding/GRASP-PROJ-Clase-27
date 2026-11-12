package dataloader;

import java.util.Arrays;

import modelo.AbstractDAO.ActividadDAO;
import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.GrupoActividadMonitorDAO;
import modelo.AbstractDAO.GrupoDAO;
import modelo.AbstractDAO.MonitorDAO;
import modelo.Entity.Actividad;
import modelo.Entity.Grupo;
import modelo.Entity.GrupoActividadMonitor;
import modelo.Entity.Monitor;

public class CargaDatosCampamento {

	public static void main(String[] args) {
		DaoFactory factory = DaoFactory.getFactory();
		Monitor[] monitores = { new Monitor("11111111A", "Carlos", "García López", "600111111"),
				new Monitor("22222222B", "Laura", "Martínez Ruiz", "600222222"),
				new Monitor("33333333C", "Pedro", "Sánchez Díaz", "600333333"),
				new Monitor("44444444D", "Ana", "Fernández Gil", "600444444"),
				new Monitor("55555555E", "Miguel", "Torres Vega", "600555555"),
				new Monitor("66666666F", "Sofía", "Romero Blanco", "600666666") };
		MonitorDAO monitorDAO = factory.getMonitorDAO();
		Arrays.asList(monitores).forEach(monitorDAO::create);
		Grupo[] grupos = { new Grupo(1, "Grupo Águilas - los más aventureros del campamento"),
				new Grupo(2, "Grupo Lobos - compañerismo y trabajo en equipo"),
				new Grupo(3, "Grupo Delfines - amantes del agua y la naturaleza"),
				new Grupo(4, "Grupo Halcones - velocidad y destreza") };
		GrupoDAO grupoDAO = factory.getGrupoDAO();
		Arrays.asList(grupos).forEach(grupoDAO::create);
		Actividad[] actividades = {
				new Actividad("ACT01", "Piragüismo", "Descenso en piragua por el río del campamento"),
				new Actividad("ACT02", "Escalada", "Escalada en el rocódromo con arnés y casco"),
				new Actividad("ACT03", "Tiro con arco", "Práctica de tiro con arco en la zona de diana"),
				new Actividad("ACT04", "Senderismo", "Ruta de senderismo por los alrededores del campamento"),
				new Actividad("ACT05", "Manualidades", "Taller de manualidades con materiales reciclados"),
				new Actividad("ACT06", "Natación", "Clases de natación en la piscina del campamento"),
				new Actividad("ACT07", "Fútbol", "Partidos y torneos de fútbol en el campo de hierba"),
				new Actividad("ACT08", "Astronomía", "Observación nocturna de estrellas con telescopio") };
		ActividadDAO actividadDAO = factory.getActividadDAO();
		Arrays.asList(actividades).forEach(actividadDAO::create);
		// y ahora lo otro
		GrupoActividadMonitor[] asignaciones = {
				// Grupo 1 (Águilas)
				new GrupoActividadMonitor(grupos[0], actividades[0], monitores[0]), // Piragüismo con
																					// Carlos
				new GrupoActividadMonitor(grupos[0], actividades[2], monitores[1]), // Tiro con arco con
																					// Laura
				new GrupoActividadMonitor(grupos[0], actividades[5], monitores[0]), // Natación con
																					// Carlos
				// Grupo 2 (Lobos)
				new GrupoActividadMonitor(grupos[1], actividades[1], monitores[2]), // Escalada con
																					// Pedro
				new GrupoActividadMonitor(grupos[1], actividades[4], monitores[3]), // Manualidades con
																					// Ana
				new GrupoActividadMonitor(grupos[1], actividades[6], monitores[2]), // Fútbol con Pedro
				// Grupo 3 (Delfines)
				new GrupoActividadMonitor(grupos[2], actividades[0], monitores[4]), // Piragüismo con
																					// Miguel
				new GrupoActividadMonitor(grupos[2], actividades[3], monitores[5]), // Senderismo con
																					// Sofía
				new GrupoActividadMonitor(grupos[2], actividades[7], monitores[4]), // Astronomía con
																					// Miguel
				// Grupo 4 (Halcones)
				new GrupoActividadMonitor(grupos[3], actividades[1], monitores[5]), // Escalada con
																					// Sofía
				new GrupoActividadMonitor(grupos[3], actividades[5], monitores[3]), // Natación con Ana
				new GrupoActividadMonitor(grupos[3], actividades[6], monitores[1]) // Fútbol con Laura
		};
		GrupoActividadMonitorDAO grupoActividadMonitorDAO = factory.getGrupoActividadMonitorDAO();
		Arrays.asList(asignaciones).forEach(grupoActividadMonitorDAO::create);
	}

}
