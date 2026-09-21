package invencionpura07b;


public class PajaroEnfadadoViewError implements PajaroEnfadadoView {

	@Override
	public void Mostrar(PajaroEnfadado pajaroEnfadado) {
		System.err.println(pajaroEnfadado.nombre);
	}

}
