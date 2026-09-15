package cohesionsecuencial.teoria;

/*
 * Cohesion secuencial. Se puede acceder independientemente a todos los metodos 
 * pero necesitan ser ejecutados en un orden concreto.
 * 
 * EN POO se entiende como peligrosa. Tiene sentido que los modeulos esten juntos pero es peligroso
 * que exija un orden concreto pero no lo obligue
 */
public class PreparadorDeCafe {
    private boolean aguaHervida = false;
    private boolean cafeMezclado = false;

    // Paso 1: Genera el agua hervida
    public void paso1_HervirAgua() {
        this.aguaHervida = true;
    }

    // Paso 2: Requiere que el agua este hervida (Paso 1)
    public void paso2_MezclarConCafe() {
        if (!this.aguaHervida) {
            throw new IllegalStateException("No puedes mezclar el cafe con agua fri. Ejecuta paso 1 primero.");
        }
        this.cafeMezclado = true;
    }

    // Paso 3: Requiere que el cafe ya este mezclado (Paso 2)
    public void paso3_ServirEnTaza() {
        if (!this.cafeMezclado) {
            throw new IllegalStateException("No hay nada que servir! Ejecuta paso 2 primero.");
        }
        System.out.println("Cafe servido y listo para tomar.");
    }
}