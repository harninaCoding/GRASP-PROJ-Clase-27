package serializacion08multiobjeto;

import java.io.IOException;

public interface PersistenciableMonoObjeto<S,T> extends Grabable<T>{
	public S leer() throws IOException;
}
