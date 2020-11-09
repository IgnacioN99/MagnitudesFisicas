package info.unlp.conversor;

/*es una clase genérica, es decir, recibe un tipo genérico, el cual determinará la unidad con la cual va a operar */
public class SondaEspacial <T extends Magnitud> {
	/*método de instancia que recibe como argumento una unidad de medida concreta e imprime lo que recibió*/
	public void imprimirMagnitud(T dato) {
		System.out.println(dato);
	}
}
