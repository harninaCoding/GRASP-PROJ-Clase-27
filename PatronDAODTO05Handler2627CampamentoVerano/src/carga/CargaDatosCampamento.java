package carga;

import java.time.LocalDate;

import modelo.AbstractDAO.DaoFactory;
import modelo.Entity.Actividad;
import modelo.Entity.Cabana;
import modelo.Entity.Grupo;
import modelo.Entity.GrupoActividadMonitor;
import modelo.Entity.Monitor;
import modelo.Entity.NinoEso;
import modelo.Entity.NinoPrimaria;
import modelo.Entity.Tienda;

public class CargaDatosCampamento {

    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getFactory();
        if (factory == null) {
            System.out.println("Error al obtener la factoría de DAOs.");
            return;
        }

        // =============================================
        // 1. MONITORES
        // =============================================
        Monitor[] monitores = {
            new Monitor("11111111A", "Carlos", "García López", "600111111"),
            new Monitor("22222222B", "Laura", "Martínez Ruiz", "600222222"),
            new Monitor("33333333C", "Pedro", "Sánchez Díaz", "600333333"),
            new Monitor("44444444D", "Ana", "Fernández Gil", "600444444"),
            new Monitor("55555555E", "Miguel", "Torres Vega", "600555555"),
            new Monitor("66666666F", "Sofía", "Romero Blanco", "600666666")
        };

        System.out.println("=== Insertando Monitores ===");
        for (Monitor m : monitores) {
            boolean ok = factory.getMonitorDAO().create(m);
            System.out.println("  Monitor " + m.getDni() + " (" + m.getNombre() + "): " + (ok ? "OK" : "ERROR"));
        }

        // =============================================
        // 2. ACTIVIDADES
        // =============================================
        Actividad[] actividades = {
            new Actividad("ACT01", "Piragüismo", "Descenso en piragua por el río del campamento"),
            new Actividad("ACT02", "Escalada", "Escalada en el rocódromo con arnés y casco"),
            new Actividad("ACT03", "Tiro con arco", "Práctica de tiro con arco en la zona de diana"),
            new Actividad("ACT04", "Senderismo", "Ruta de senderismo por los alrededores del campamento"),
            new Actividad("ACT05", "Manualidades", "Taller de manualidades con materiales reciclados"),
            new Actividad("ACT06", "Natación", "Clases de natación en la piscina del campamento"),
            new Actividad("ACT07", "Fútbol", "Partidos y torneos de fútbol en el campo de hierba"),
            new Actividad("ACT08", "Astronomía", "Observación nocturna de estrellas con telescopio")
        };

        System.out.println("\n=== Insertando Actividades ===");
        for (Actividad a : actividades) {
            boolean ok = factory.getActividadDAO().create(a);
            System.out.println("  Actividad " + a.getCodigoActividad() + " (" + a.getNombreActividad() + "): " + (ok ? "OK" : "ERROR"));
        }

        // =============================================
        // 3. GRUPOS
        // =============================================
        Grupo[] grupos = {
            new Grupo(1, "Grupo Águilas - los más aventureros del campamento"),
            new Grupo(2, "Grupo Lobos - compañerismo y trabajo en equipo"),
            new Grupo(3, "Grupo Delfines - amantes del agua y la naturaleza"),
            new Grupo(4, "Grupo Halcones - velocidad y destreza")
        };

        System.out.println("\n=== Insertando Grupos ===");
        for (Grupo g : grupos) {
            boolean ok = factory.getGrupoDAO().create(g);
            System.out.println("  Grupo " + g.getNumeroGrupo() + " (" + g.getInformaciones() + "): " + (ok ? "OK" : "ERROR"));
        }

        // =============================================
        // 4. CABAÑAS (para niños de Primaria)
        // =============================================
        Cabana[] cabanas = {
            new Cabana("CAB01", 6),
            new Cabana("CAB02", 6),
            new Cabana("CAB03", 4),
            new Cabana("CAB04", 8)
        };

        System.out.println("\n=== Insertando Cabañas ===");
        for (Cabana c : cabanas) {
            boolean ok = factory.getCabanaDAO().create(c);
            System.out.println("  Cabaña " + c.getCodigoCabana() + " (capacidad " + c.getCapacidad() + "): " + (ok ? "OK" : "ERROR"));
        }

        // =============================================
        // 5. TIENDAS (para niños de ESO)
        // =============================================
        Tienda[] tiendas = {
            new Tienda(1, 4),
            new Tienda(2, 4),
            new Tienda(3, 3),
            new Tienda(4, 5)
        };

        System.out.println("\n=== Insertando Tiendas ===");
        for (Tienda t : tiendas) {
            boolean ok = factory.getTiendaDAO().create(t);
            System.out.println("  Tienda " + t.getNumeroTienda() + " (capacidad " + t.getCapacidad() + "): " + (ok ? "OK" : "ERROR"));
        }

        // =============================================
        // 6. NIÑOS DE PRIMARIA (duermen en cabañas)
        // =============================================
        NinoPrimaria[] ninosPrimaria = {
            new NinoPrimaria(1, "Lucía", "Pérez Navarro", LocalDate.of(2016, 3, 15), grupos[0], cabanas[0]),
            new NinoPrimaria(2, "Hugo", "López Moreno", LocalDate.of(2015, 7, 22), grupos[0], cabanas[0]),
            new NinoPrimaria(3, "Martina", "Gómez Serrano", LocalDate.of(2016, 1, 10), grupos[1], cabanas[1]),
            new NinoPrimaria(4, "Leo", "Ruiz Castillo", LocalDate.of(2015, 11, 5), grupos[1], cabanas[1]),
            new NinoPrimaria(5, "Valeria", "Jiménez Ortega", LocalDate.of(2016, 5, 28), grupos[0], cabanas[2]),
            new NinoPrimaria(6, "Daniel", "Hernández Ramos", LocalDate.of(2015, 9, 14), grupos[1], cabanas[2]),
            new NinoPrimaria(7, "Emma", "Díaz Fuentes", LocalDate.of(2016, 8, 3), grupos[0], cabanas[3]),
            new NinoPrimaria(8, "Pablo", "Morales Castro", LocalDate.of(2015, 12, 19), grupos[1], cabanas[3])
        };

        System.out.println("\n=== Insertando Niños de Primaria ===");
        for (NinoPrimaria np : ninosPrimaria) {
            boolean ok = factory.getNinoPrimariaDAO().create(np);
            System.out.println("  Niño Primaria " + np.getNumeroNino() + " (" + np.getNombre() + " " + np.getApellidos() + "): " + (ok ? "OK" : "ERROR"));
        }

        // =============================================
        // 7. NIÑOS DE ESO (duermen en tiendas)
        // =============================================
        NinoEso[] ninosEso = {
            new NinoEso(101, "Alejandro", "Vidal Peña", LocalDate.of(2013, 4, 12), grupos[2], tiendas[0]),
            new NinoEso(102, "Carmen", "Reyes Molina", LocalDate.of(2012, 6, 25), grupos[2], tiendas[0]),
            new NinoEso(103, "Adrián", "Navarro Prieto", LocalDate.of(2013, 2, 8), grupos[3], tiendas[1]),
            new NinoEso(104, "Noa", "Iglesias Delgado", LocalDate.of(2012, 10, 30), grupos[3], tiendas[1]),
            new NinoEso(105, "Marcos", "Suárez Herrera", LocalDate.of(2013, 7, 17), grupos[2], tiendas[2]),
            new NinoEso(106, "Daniela", "Castro Méndez", LocalDate.of(2012, 1, 3), grupos[3], tiendas[2]),
            new NinoEso(107, "Iker", "Ortega Cano", LocalDate.of(2013, 9, 21), grupos[2], tiendas[3]),
            new NinoEso(108, "Julia", "Ramírez Santos", LocalDate.of(2012, 5, 11), grupos[3], tiendas[3])
        };

        System.out.println("\n=== Insertando Niños de ESO ===");
        for (NinoEso ne : ninosEso) {
            boolean ok = factory.getNinoEsoDAO().create(ne);
            System.out.println("  Niño ESO " + ne.getNumeroNino() + " (" + ne.getNombre() + " " + ne.getApellidos() + "): " + (ok ? "OK" : "ERROR"));
        }

        // =============================================
        // 8. GRUPO-ACTIVIDAD-MONITOR (asignaciones)
        // =============================================
        GrupoActividadMonitor[] asignaciones = {
            // Grupo 1 (Águilas)
            new GrupoActividadMonitor(grupos[0], actividades[0], monitores[0]),  // Piragüismo con Carlos
            new GrupoActividadMonitor(grupos[0], actividades[2], monitores[1]),  // Tiro con arco con Laura
            new GrupoActividadMonitor(grupos[0], actividades[5], monitores[0]),  // Natación con Carlos
            // Grupo 2 (Lobos)
            new GrupoActividadMonitor(grupos[1], actividades[1], monitores[2]),  // Escalada con Pedro
            new GrupoActividadMonitor(grupos[1], actividades[4], monitores[3]),  // Manualidades con Ana
            new GrupoActividadMonitor(grupos[1], actividades[6], monitores[2]),  // Fútbol con Pedro
            // Grupo 3 (Delfines)
            new GrupoActividadMonitor(grupos[2], actividades[0], monitores[4]),  // Piragüismo con Miguel
            new GrupoActividadMonitor(grupos[2], actividades[3], monitores[5]),  // Senderismo con Sofía
            new GrupoActividadMonitor(grupos[2], actividades[7], monitores[4]),  // Astronomía con Miguel
            // Grupo 4 (Halcones)
            new GrupoActividadMonitor(grupos[3], actividades[1], monitores[5]),  // Escalada con Sofía
            new GrupoActividadMonitor(grupos[3], actividades[5], monitores[3]),  // Natación con Ana
            new GrupoActividadMonitor(grupos[3], actividades[6], monitores[1])   // Fútbol con Laura
        };

        System.out.println("\n=== Insertando Asignaciones Grupo-Actividad-Monitor ===");
        for (GrupoActividadMonitor gam : asignaciones) {
            boolean ok = factory.getGrupoActividadMonitorDAO().create(gam);
            System.out.println("  Grupo " + gam.getGrupo().getNumeroGrupo()
                    + " - " + gam.getActividad().getCodigoActividad()
                    + " - Monitor " + gam.getMonitor().getDni() + ": " + (ok ? "OK" : "ERROR"));
        }

        System.out.println("\n========================================");
        System.out.println("  Carga de datos del campamento completada");
        System.out.println("========================================");
        System.out.println("Resumen:");
        System.out.println("  - " + monitores.length + " monitores");
        System.out.println("  - " + actividades.length + " actividades");
        System.out.println("  - " + grupos.length + " grupos");
        System.out.println("  - " + cabanas.length + " cabañas");
        System.out.println("  - " + tiendas.length + " tiendas");
        System.out.println("  - " + ninosPrimaria.length + " niños de Primaria");
        System.out.println("  - " + ninosEso.length + " niños de ESO");
        System.out.println("  - " + asignaciones.length + " asignaciones grupo-actividad-monitor");
    }
}

