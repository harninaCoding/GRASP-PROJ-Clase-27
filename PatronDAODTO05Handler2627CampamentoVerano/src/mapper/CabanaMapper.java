package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Cabana;

public class CabanaMapper implements Mapper<ResultSet, Cabana> {

    @Override
    public Cabana map(ResultSet rs) {
        try {
            Cabana cabana = new Cabana();
            cabana.setCodigoCabana(rs.getString("codigo_cabana"));
            cabana.setCapacidad(rs.getInt("capacidad"));
            return cabana;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object[] toInsertParams(Cabana cabana) {
        return new Object[] {
            cabana.getCodigoCabana(),
            cabana.getCapacidad()
        };
    }
}