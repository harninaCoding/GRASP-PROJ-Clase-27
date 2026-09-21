package control14.control;

public class CadenaService {

	public String toUpper(String nombre) {
		String upperCase = nombre.toUpperCase();
		String replace = upperCase.replace('A', 'E');
		return  replace;
	}
}
