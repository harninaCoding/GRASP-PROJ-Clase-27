package acop03control;

import java.util.Random;
import java.util.Scanner;

public class DeControl {

	public void imprimeAlgo() {
		System.out.println("Desea un numero par(p) o impar(i)");
		char letra = new Scanner(System.in).nextLine().charAt(0);
		//porque se mete en el funcionamiento de la anterior
		int valor = new Otra().dameAleatorio(letra);
	}
}
class Otra{
	public int dameAleatorio(char letra) {
		int valor = 0;
		if (letra == 'p')
			valor = new Random().nextInt(50) * 2;
		if (letra == 'i')
			valor = new Random().nextInt(49) * 2 + 1;
		return valor;
	}
}
