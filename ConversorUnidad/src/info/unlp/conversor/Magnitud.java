package info.unlp.conversor;

import info.unlp.conversor.sistemaIngles.LongIngles;
import info.unlp.conversor.sistemaInternacional.LongInternacional;

public abstract class Magnitud {
<<<<<<< Updated upstream
	private TipoMagnitud id = null;
	private Subfijo sb = null;
	private double cantidad;
	private int sistema;

	public Magnitud(TipoMagnitud id, int sistema) {
=======
	private Subfijo sb = null; //Subfijo de la magnitud
	private double cantidad; //medida 
	private int sistema; //sistema que maneja 1(Sistema internacional) o 2 (Sistema Ingles)
	/*Crea una nueva instancia de magnitud en la que se le especifica el tipo y el sistema en el que se trabajara*/
	public Magnitud( int sistema) {
>>>>>>> Stashed changes
		this.sistema = sistema;
	}
<<<<<<< Updated upstream

	public Magnitud(TipoMagnitud id) {
		this.id = id;
=======
	/*Crea una nueva instancia de magnitud */
	public Magnitud() {
>>>>>>> Stashed changes
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

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
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
		Magnitud ret = this;
		if (m.getSistema() != this.getSistema()) {
			Magnitud aux = CambioDeMagnitud.getInstance().cambiarSistema(this.sb.abrev(), m);
			ret=new LongInternacional();
			ret.setCantidad(getCantidad() + aux.getCantidad());
			ret.setSb(aux.getSb());
		} else {
			m.cambioLocal(this.sb.abrev());
			ret=new LongIngles();
			ret.setCantidad(getCantidad() + m.getCantidad());
			ret.setSb(m.getSb());
		}
		return ret;
	}

	public Magnitud resta(Magnitud m) {
		Magnitud ret;
		if (m.getSistema() != this.getSistema()) {
			Magnitud aux = CambioDeMagnitud.getInstance().cambiarSistema(this.sb.abrev(), m);
			ret=new LongInternacional();
			ret.setCantidad(getCantidad() - aux.getCantidad());
			ret.setSb(aux.getSb());
		} else {
			m.cambioLocal(this.sb.abrev());
			ret=new LongIngles();
			ret.setCantidad(getCantidad() - m.getCantidad());
			ret.setSb(m.getSb());
		}
		return ret;
	}

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
