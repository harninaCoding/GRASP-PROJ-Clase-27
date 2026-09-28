package serializacion08multiobjeto;

import java.util.List;
import java.util.Optional;

public interface RepositorioIndexado<T extends Keyable<K>,K> extends Grabable<T> {
	public Optional<T> leer(K k);
	public List<T> getTodos();
}
