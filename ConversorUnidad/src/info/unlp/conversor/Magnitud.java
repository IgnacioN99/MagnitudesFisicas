package info.unlp.conversor;

public abstract class Magnitud {
	private TipoMagnitud id = null; //Tipo de magnitud que sera
	private Subfijo sb = null; //Subfijo de la magnitud
	private double cantidad; //medida 
	private int sistema; //sistema que maneja 1(Sistema internacional) o 2 (Sistema Ingles)
	/*Crea una nueva instancia de magnitud en la que se le especifica el tipo y el sistema en el que se trabajara*/
	public Magnitud(TipoMagnitud id, int sistema) {
		this.sistema = sistema;
		this.id = id;
	}
	/*Crea una nueva instancia de magnitud en la que se le especifica el tipo de magnitud que sera*/
	public Magnitud(TipoMagnitud id) {
		this.id = id;
	}

	/**
	 * Cambio de unidad de un mismo sistema
	 *
	 * @param unidad unidad a la que se quiere cambiar
	 * @return Si el cambio fue exitoso
	 */
	public boolean cambioLocal(String unidad) {
		return false;
	}
	//****************	Getters y setters ****************//
	
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
	
	//****************	Getters y setters ****************//
	public String toString() {
		return this.cantidad + " " + this.sb;
	}
	/**
	 * Suma la instancia actual con la pasada por parametro.
	 *
	 * @param m Magnitud a ser sumada
	 * @return resultado de la suma
	 */
	public Magnitud suma(Magnitud m) {
		Magnitud ret = this;
		if (m.getSistema() != this.getSistema()) {
			Magnitud aux = CambioDeMagnitud.getInstance().cambiarSistema(this.sb.abrev(), m);
			ret.setCantidad(getCantidad() + aux.getCantidad());
		} else {
			m.cambioLocal(this.sb.abrev());
		}
		return ret;
	}
	/**
	 * Resta la instancia actual con la pasada por parametro.
	 *
	 * @param m Magnitud a ser restada
	 * @return resultado de la suma
	 */
	public Magnitud resta(Magnitud m) {
		Magnitud ret = this;
		if (m.getSistema() != this.getSistema()) {
			Magnitud aux = CambioDeMagnitud.getInstance().cambiarSistema(this.sb.abrev(), m);
			ret.setCantidad(getCantidad() - aux.getCantidad());
		} else {
			m.cambioLocal(this.sb.abrev());
			ret.setCantidad(getCantidad() - m.getCantidad());
		}
		return ret;
	}
	/**
	 * Compara la instancia actual con la pasada por parametro.
	 *
	 * @param m Magnitud a ser comparada
	 * @return 0 si es Igual, 1 si es mayor a la pasada por parametro y -1 si la instancia actual es menor a la pasada por parametro
	 */
	public int comparar(Magnitud m) {
		if (m.getSistema() != this.getSistema()) {
			m = CambioDeMagnitud.getInstance().cambiarSistema(this.sb.abrev(), m);
		} else {
			m.cambioLocal(this.sb.abrev());
		}
		if (this.getCantidad() == m.getCantidad())
			return 0;
		else if(this.getCantidad()>m.getCantidad())
			return 1;
		else 
			return -1;
	}

}
