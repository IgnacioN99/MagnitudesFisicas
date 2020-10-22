package info.unlp.conversor;
import info.unlp.conversor.sistemaInternacional.Area;
import info.unlp.conversor.sistemaInternacional.KiloGramos;

public class SondaEspacial <T> {
	private double cantidad;
	private int potencia;
	Magnitud m;
	public SondaEspacial(T dato) {
		//Yo se que T es de tipo magnitud por lo tanto puedo tomarlo como uno
		switch (((Magnitud)dato).getId()) {
		case AREA:
			m=(Area)dato;
			break;
		case KILOGRAMOS:
			m=(KiloGramos)dato;
		case LIBRA:
			m=()
		case METRO:
		case PIE:
		case SEGUNDOS:
		case VELOCIDAD:
		case SUP:
		default:
			break;
		}
		
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	
}
