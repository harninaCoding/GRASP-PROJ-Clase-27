package liskovreal00;

import java.awt.Point;

public class Cuadrado extends Forma {

	public Cuadrado(Point point) {
		super(point);
	}

	
	//ESto rompe el principio de substitucion de liskov
	@Override
	public void mover(Movement movement) {
		System.out.println("soy recto");
		System.out.println("Yo no me muevo");
		System.out.println("---------------------------------------");
	}
}
