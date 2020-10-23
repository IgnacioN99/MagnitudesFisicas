package info.unlp.conversor;



public abstract class Magnitud {
	private TipoMagnitud id=null;
	private Subfijo sb=null;
	private double cantidad;
	private int sistema;


	public Magnitud(TipoMagnitud id, int sistema) {
		this.sistema = sistema;
		this.id = id;
	}
	public Magnitud(TipoMagnitud id) {
		this.id = id;
	}

	

	/**
	 * Cambia la unidad local. Es decir que si esta en cm pasa a metros, de gramos a
	 * kg, de pulgadas a pies, etc
	 *
	 * @param unidad the unidad
	 * @return Si el cambio fue exitoso
	 */
	public boolean cambioLocal(String unidad) {
		return false;
	}
	
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
	public Magnitud suma(Magnitud m) {
		Magnitud ret=this;
		if(m.getSistema()!=this.getSistema()) {
			Magnitud aux= CambioDeMagnitud.getInstance().cambiarSistema(this.sb.abrev(),m);
			ret.setCantidad(getCantidad()+aux.getCantidad());
		}else {
			m.cambioLocal(this.sb.abrev());
		}
		return ret;
	}
	public Magnitud resta(Magnitud m) {
		Magnitud ret=this;
		if(m.getSistema()!=this.getSistema()) {
			Magnitud aux= CambioDeMagnitud.getInstance().cambiarSistema(this.sb.abrev(),m);
			ret.setCantidad(getCantidad()-aux.getCantidad());
		}else {
			m.cambioLocal(this.sb.abrev());
			ret.setCantidad(getCantidad()-m.getCantidad());
		}
		return ret;
	}

}
