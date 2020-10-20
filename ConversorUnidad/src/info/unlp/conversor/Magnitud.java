package info.unlp.conversor;



public abstract class Magnitud {
	private TipoMagnitud id;
	private Subfijo sb;
	private double cantidad;
	private int sistema;


	public Magnitud(TipoMagnitud id, int sistema) {
		this.sistema = sistema;
		this.id = id;
	}

	/**
	 * Cambia la unidad de sistema Internacional a Sitema ingles y Viceversa
	 *
	 * @return the double
	 */
	public abstract double cambiarSistema();

	/**
	 * Cambia la unidad local. Es decir que si esta en cm pasa a metros, de gramos a
	 * kg, de pulgadas a pies, etc
	 *
	 * @param unidad the unidad
	 * @return Si el cambio fue exitoso
	 */
	public abstract boolean cambioLocal(String unidad);

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

	public TipoMagnitud getId() {
		return id;
	}

	public void setId(TipoMagnitud id) {
		this.id = id;
	}

	public Subfijo getSb() {
		return sb;
	}

	public void setSb(Subfijo sb) {
		this.sb = sb;
	}

	public String toString() {
		return this.cantidad + " " + this.sb;
	}

}
