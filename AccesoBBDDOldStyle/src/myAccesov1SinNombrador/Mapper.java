package myAccesov1SinNombrador;

import java.sql.ResultSet;
import java.util.Optional;

@FunctionalInterface
public interface Mapper<T> {
	public Optional<T> map(ResultSet resultSet);
	
}
