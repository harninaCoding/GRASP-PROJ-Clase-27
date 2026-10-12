package myAccesov3DAO;

import java.sql.ResultSet;
import java.util.Optional;

@FunctionalInterface
public interface Mapper<T> {
	public Optional<T> map(ResultSet resultSet);
	
}
