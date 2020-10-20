package info.unlp.conversor;

public class SondaEspacial <T> {
	private double cantidad;
	private int potencia;
	public SondaEspacial(T dato) {
		if(dato instanceof Magnitud) {
			((Magnitud) dato).getId();
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
