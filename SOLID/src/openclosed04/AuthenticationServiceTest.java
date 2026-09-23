package openclosed04;

import org.junit.jupiter.api.Test;

class AuthenticationServiceTest {

	@Test
	void test() {
		boolean facebook=false;
		AuthenticationEngine01 autenticador = null;
		AuthenticationService authenticationService=new AuthenticationService();
		//usuario final selecciona con un boton un tipo de autenticacion
		if(facebook) {
			autenticador=new AuthenticationEngineFacebook();
		}
		authenticationService.signing(autenticador);
	}

}
