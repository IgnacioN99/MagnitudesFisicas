package info.unlp.conversor;

<<<<<<< Updated upstream

public class SondaEspacial <T> {
=======
/*es una clase gen�rica, es decir, recibe un tipo gen�rico, el cual determinar� la unidad con la cual va a operar */
public class SondaEspacial <T extends Magnitud> {
	
	/*m�todo de instancia que recibe como argumento una unidad de medida concreta e imprime lo que recibi�*/
>>>>>>> Stashed changes
	public void imprimirMagnitud(T dato) {
		System.out.println(dato);
	}
	public boolean verificacion(Magnitud dato) {
		
		return false;
	}
}
