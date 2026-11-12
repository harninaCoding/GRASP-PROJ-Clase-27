package services;

import java.util.Optional;

import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.NinoDAO;
import modelo.AbstractDAO.NinoEsoDAO;
import modelo.AbstractDAO.TiendaDAO;
import modelo.Entity.Nino;
import modelo.Entity.NinoEso;
import modelo.Entity.Tienda;

public class CampamentoServiceImpl implements CampamentoService {

    private final NinoDAO ninoDAO;
    private final NinoEsoDAO ninoEsoDAO;
    private final TiendaDAO tiendaDAO;

    public CampamentoServiceImpl() {
		this.ninoDAO = DaoFactory.getFactory().getNinoDAO();
		this.ninoEsoDAO = DaoFactory.getFactory().getNinoEsoDAO();
		this.tiendaDAO = DaoFactory.getFactory().getTiendaDAO();
      
    }
   
    @Override
    public boolean create(NinoEso ninoEso) {
        if (ninoEso == null) {
            return false;
        }

        // 1. Obtener instancias de ambos DAOs (con fallback a DaoFactory)
        // mecanismo de seguridad si, al crear este objeto, todavia no se ha creado el DAOFActory
        NinoDAO baseDao = this.ninoDAO;
        if (baseDao == null && DaoFactory.getFactory() != null) {
            baseDao = DaoFactory.getFactory().getNinoDAO();
        }

        NinoEsoDAO esoDao = this.ninoEsoDAO;
        if (esoDao == null && DaoFactory.getFactory() != null) {
            esoDao = DaoFactory.getFactory().getNinoEsoDAO();
        }

        if (baseDao == null || esoDao == null) {
            return false;
        }

        // 2. Insertar primero en la tabla padre 'nino'
        // Como NinoEso hereda de Nino, podemos pasarlo directamente a baseDao.create()
        boolean creadoEnNino = baseDao.create(ninoEso);
        if (!creadoEnNino) {
            return false;
        }

        // 3. Insertar después en la tabla hija 'nino_eso'
        boolean creadoEnNinoEso = esoDao.create(ninoEso);
        if (!creadoEnNinoEso) {
            // Rollback manual: si falla la tabla hija, eliminamos el registro padre creado en el paso 2
            if (ninoEso.getNumeroNino() != null) {
                baseDao.deleteById(ninoEso.getNumeroNino());
            }
            return false;
        }

        return true;
    }

    @Override
    public Optional<NinoEso> getNinoEsoById(int numeroNino) {
        // 1. Obtener el NinoEso (solo trae numero_nino y el ID de tienda)
        NinoEsoDAO esoDao = this.ninoEsoDAO;
        if (esoDao == null && DaoFactory.getFactory() != null) {
            esoDao = DaoFactory.getFactory().getNinoEsoDAO();
        }
        if (esoDao == null) {
            return Optional.empty();
        }

        Optional<NinoEso> ninoEsoOpt = esoDao.findById(numeroNino);
        if (ninoEsoOpt == null || !ninoEsoOpt.isPresent()) {
            return Optional.empty();
        }

        NinoEso ninoEso = ninoEsoOpt.get();

        // 2. Cargar los campos heredados de la tabla padre 'nino'
        NinoDAO baseDao = this.ninoDAO;
        if (baseDao == null && DaoFactory.getFactory() != null) {
            baseDao = DaoFactory.getFactory().getNinoDAO();
        }
        if (baseDao != null) {
            Optional<Nino> ninoBaseOpt = baseDao.findById(numeroNino);
            if (ninoBaseOpt != null && ninoBaseOpt.isPresent()) {
                ninoEso.setBase(ninoBaseOpt.get());
            }
        }

        // 3. Cargar los datos completos de la Tienda asociada
        TiendaDAO tDao = this.tiendaDAO;
        if (tDao == null && DaoFactory.getFactory() != null) {
            tDao = DaoFactory.getFactory().getTiendaDAO();
        }
        if (tDao != null && ninoEso.getTienda() != null && ninoEso.getTienda().getNumeroTienda() != null) {
            Optional<Tienda> tiendaOpt = tDao.findById(ninoEso.getTienda().getNumeroTienda());
            if (tiendaOpt != null && tiendaOpt.isPresent()) {
                ninoEso.setTienda(tiendaOpt.get());
            }
        }

        return Optional.of(ninoEso);
    }
    @Override
    public Optional<NinoEso> deleteNinoEsoById(int numeroNino) {
        // 1. Recuperamos el NinoEso completo (con datos de Nino y Tienda) antes de borrarlo
        Optional<NinoEso> ninoEsoOpt = getNinoEsoById(numeroNino);
        if (!ninoEsoOpt.isPresent()) {
            return Optional.empty();
        }

        NinoDAO baseDao = this.ninoDAO;
        NinoEsoDAO esoDao = this.ninoEsoDAO;

        if (baseDao == null || esoDao == null) {
            return Optional.empty();
        }

        // 2. Borramos primero en la tabla hija y después en la tabla padre
        // (De este modo funciona tanto si la BD tiene ON DELETE CASCADE como si no)
        esoDao.deleteById(numeroNino);
        baseDao.deleteById(numeroNino);

        return ninoEsoOpt;
    }
}