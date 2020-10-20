package info.unlp.conversor;

public abstract class Magnitud {
	private static TipoMagnitud id;
	private double cantidad;
	private int potencia;
	private int sistema;


	public Magnitud(TipoMagnitud id,int sistema) {
		this.sistema=sistema;
		Magnitud.id = id;
	}

	/**
	 * Cambia la unidad de sistema Internacional a Sitema ingles y Viceversa
	 *
	 * @return the double
	 */
	public abstract double cambiarSistema();
	
	/**
	 * Cambia la unidad local.
	 * Es decir que si esta en cm pasa a metros, de gramos a kg, de pulgadas a pies, etc
	 *
	 * @param unidad the unidad
	 */
	public abstract void cambioLocal(String unidad);
	
	public int getSistema() {
		return sistema;
	}

	public void setSistema(int sistema) {
		this.sistema = sistema;
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

	public static  TipoMagnitud getId() {
		return id;
	}

	public void setId(TipoMagnitud id) {
		this.id = id;
	}

}
