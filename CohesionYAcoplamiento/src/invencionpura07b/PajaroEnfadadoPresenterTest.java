package invencionpura07b;

import org.junit.jupiter.api.Test;

class PajaroEnfadadoPresenterTest {

	@Test
	void test() {
		PajaroEnfadado pajaroEnfadado=new PajaroEnfadado();
		PajaroEnfadadoView pajaroEnfadadoView=new PajaroEnfadadoViewConsola();
		PajaroEnfadadoPresenter pajaroEnfadadoPresenter=new PajaroEnfadadoPresenter(pajaroEnfadadoView, pajaroEnfadado);
	}

}
