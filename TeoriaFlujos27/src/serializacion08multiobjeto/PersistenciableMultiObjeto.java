package serializacion08multiobjeto;

public interface PersistenciableMultiObjeto<S,T> extends Grabable<T>{
	public S leer(Long posicion) ;
}
