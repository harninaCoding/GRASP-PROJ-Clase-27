package modelo.AbstractDAO;

import modelo.ImplDAO.DAOFactoryJDBC;

public abstract class DaoFactory {
    
    // Método estático para obtener la factoría concreta deseada
    public static DaoFactory getFactory() {
        try {
            return new DAOFactoryJDBC();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Aquí añadirás los demás DAOs del campamento:
    // public abstract MonitorDAO getMonitorDAO();
    // public abstract GrupoDAO getGrupoDAO();
}