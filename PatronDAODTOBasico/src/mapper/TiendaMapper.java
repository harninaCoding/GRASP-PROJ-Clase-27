package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Tienda;

public class TiendaMapper implements Mapper<ResultSet, Tienda> {

    @Override
    public Tienda map(ResultSet rs) {
        try {
            Tienda tienda = new Tienda();
            tienda.setNumeroTienda(rs.getInt("numero_tienda"));
            tienda.setCapacidad(rs.getInt("capacidad"));
            return tienda;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}