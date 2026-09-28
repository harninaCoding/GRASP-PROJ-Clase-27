package binarios032AdaptadoresAleatorioMapeo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AdaptadorTest {
	Cliente cliente=new Cliente(1, "javierito", true, 12.5f);
	Cliente clienteDos=new Cliente(2, "Enriquito", true, 22.5f);
	//esto es en la carpeta raiz del proyecto
	String path = "./clienteAleatorio.cli";
	Adaptador adaptador;
	File file=null;
	
	@BeforeEach
	void setUp() throws Exception {
		adaptador=new Adaptador();
		file=new File(path);
		file.delete();
		file=new File(path);
	}

	@AfterEach
	void tearDown() throws Exception {
		file.delete();
	}

	private void pruebaCreacion() {
//		assertFalse(file.exists());
		assertTrue(adaptador.grabar(path, cliente));
		assertTrue(adaptador.grabar(path, clienteDos));
		assertTrue(file.exists());
	}

	@Test
//	@Ignore
	void testLeer() {
		//Cujmplo el requisito de que debe existir un archivo
		pruebaCreacion();
		//Hacer la prueba de leer
		assertEquals(cliente, adaptador.leer(path,0));
		Cliente leer = adaptador.leer(path,1);
		assertEquals(clienteDos, leer);
		System.out.println(leer.toString());
				
	}


	@Test
	void testGrabar() {
		pruebaCreacion();
	}

}
