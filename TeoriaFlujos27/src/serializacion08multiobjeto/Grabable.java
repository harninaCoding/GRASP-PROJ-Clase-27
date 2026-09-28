package serializacion08multiobjeto;

public interface Grabable<T> {
	public boolean grabar(T objeto) throws Exception;
}
