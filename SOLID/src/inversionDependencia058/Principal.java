package inversionDependencia058;

import java.util.List;

public class Principal {
	// Softare cliente (aunque ponga main)
	public static void main(String[] args) {
		// Inversion de depedencias
		INecesitada necesitada = new Necesitada();
		Dependiente b = new Dependiente(necesitada);
		Dependiente b1 = new Dependiente(new OtraNecesitada());
		Dependiente b2=new Dependiente(new INecesitada() {
			
			@Override
			public void dame(List<String> cc) {
				// TODO Auto-generated method stub
				
			}
		});

	}
}
