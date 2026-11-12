package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.NinoEso;
import modelo.Entity.Tienda;

public class NinoEsoMapper implements Mapper<ResultSet, NinoEso> {

	@Override
	public NinoEso map(ResultSet rs) {
		 try {
	            NinoEso nino = new NinoEso();
	            nino.setNumeroNino(rs.getInt("numero_nino"));
	            Tienda tienda = new Tienda();
	            tienda.setNumeroTienda(rs.getInt("numero_tienda"));
	            nino.setTienda(tienda);
	            return nino;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	}

	@Override
	public Object[] toInsertParams(NinoEso t) {
		 return new Object[] {
	                t.getNumeroNino(),
	                t.getTienda().getNumeroTienda()
	        };
	}

}
