package info.unlp.conversor.sistemaInternacional.derivadas;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.TipoMagnitud;
import info.unlp.conversor.sistemaIngles.LongIngles;
import info.unlp.conversor.sistemaInternacional.LongInternacional;

/**
 * Clase Volumen que se encarga de manejar los cambios locales de sistema y contiene sobreescrito los metodos de suma,resta y comparacion del mismo
 */
public class Volumen extends Magnitud {

	/** El volumen esta formado por 3 instancias de magnitud que se convertiran luego en longitud. */
	private Magnitud m1 = new LongInternacional(), m2, m3;

	/**
	 * Crea una nueva instancia de Volumen en el que se le pasa las 3 medidas sin unidad de medida que es tomada por defecto como m^3
	 *
	 * @param cant1 1era medida
	 * @param cant2 2da medida
	 * @param cant3 3ra medida
	 */
	public Volumen(double cant1, double cant2, double cant3) {
		super(TipoMagnitud.VOLUMEN, 1);
		m1 = new LongInternacional(cant1, "m");
		m2 = new LongInternacional(cant2, "m");
		m3 = new LongInternacional(cant3, "m");
		super.setSb(m1.getSb());
	}

	/**
	 * Crea una nueva instancia de Volumen en el que se le pasa el volumen total sin unidad de medida que es tomada por defecto como m^3
	 *
	 * @param cant volumen
	 */
	public Volumen(double cant) {
		super(TipoMagnitud.VOLUMEN, 1);
		m1 = new LongInternacional(cant, "m");
		m2 = new LongInternacional(1, "m");
		m3 = new LongInternacional(1, "m");
		super.setSb(m1.getSb());
	}

	/**
	 * Crea una nueva instancia de Volumen en el que se le pasa el volumen y su unidad de medida
	 *
	 * @param cant volumen
	 * @param unidad unidad de medida
	 */
	public Volumen(double cant, String unidad) {
		super(TipoMagnitud.VOLUMEN);
		if (m1.cambioLocal(unidad)) {
			m1 = new LongInternacional(cant, unidad);
			m2 = new LongInternacional(1, unidad);
			m3 = new LongInternacional(1, unidad);
			super.setSistema(1);
		} else {
			m1 = new LongIngles(cant, unidad);
			m2 = new LongIngles(1, unidad);
			m3 = new LongIngles(1, unidad);
			super.setSistema(2);
		}
		super.setSb(m1.getSb());
	}
	
	/**
	 * Crea una nueva instancia de Volumen en el que se le pasa las 3 medidas  en el que se le pasa su unidad de medida
	 *
	 * @param cant1 1era medida
	 * @param cant2 2da medida
	 * @param cant3 3ra medida
	 * @param unidad unidad de medida
	 */
	public Volumen(double cant1, double cant2, double cant3, String unidad) {
		super(TipoMagnitud.VOLUMEN);
		if (m1.cambioLocal(unidad)) {
			m1 = new LongInternacional(cant1, unidad);
			m2 = new LongInternacional(cant2, unidad);
			m3 = new LongInternacional(cant3, unidad);
			super.setSistema(1);
		} else {
			m1 = new LongIngles(cant1, unidad);
			m2 = new LongIngles(cant2, unidad);
			m3 = new LongIngles(cant3, unidad);
			super.setSistema(2);
		}
		super.setSb(m1.getSb());
	}

	/**
	 * Cambio local de unidades.
	 *
	 * @param unidad a la unidad que se quiere cambiar
	 * @return si el cambio fue satisfactorio
	 */
	@Override
	public boolean cambioLocal(String unidad) {
		return m1.cambioLocal(unidad) && m2.cambioLocal(unidad) && m3.cambioLocal(unidad);
	}
	
	/**
	 * To string.
	 *
	 * @return volumen con su unidad de medida
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return m1.getCantidad()*m2.getCantidad()*m3.getCantidad()+" "+m1.getSb().abrev()+"³";
	}

	//****************	Getters y setters ****************//
	
	public Magnitud getM1() {
		return m1;
	}

	public void setM1(Magnitud m1) {
		this.m1 = m1;
	}

	public Magnitud getM2() {
		return m2;
	}

	public void setM2(Magnitud m2) {
		this.m2 = m2;
	}
	
	public Magnitud getM3() {
		return m3;
	}

	public void setM3(Magnitud m3) {
		this.m3 = m3;
	}
	
	public double getCantidad() {
		return m1.getCantidad()*m2.getCantidad()*m3.getCantidad();
	}
	
	//****************	Getters y setters ****************//
	
	/**
	 * Suma la instancia actual con la pasada por parametro.
	 *
	 * @param m Magnitud a ser sumada
	 * @return resultado de la suma
	 */
	@Override
	public Magnitud suma(Magnitud m) {
		Magnitud ret=null;
		if(this.getSistema()!=m.getSistema()) {
			Magnitud aux=CambioDeMagnitud.getInstance().cambiarSistema(this.m1.getSb().abrev(), m);
			ret= new Volumen(aux.getCantidad()+this.getCantidad(),this.getSb().abrev());
		}else {
			m.cambioLocal(this.getSb().abrev());
			ret= new Volumen(m.getCantidad()+this.getCantidad(),this.getSb().abrev());
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
		Magnitud ret=null;
		if(this.getSistema()!=m.getSistema()) {
			Magnitud aux=CambioDeMagnitud.getInstance().cambiarSistema(this.m1.getSb().abrev(), m);
			ret= new Volumen(aux.getCantidad()-this.getCantidad(),this.getSb().abrev());
		}else {
			m.cambioLocal(this.getSb().abrev());
			ret= new Volumen(m.getCantidad()-this.getCantidad(),this.getSb().abrev());
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
		if(this.getSistema()!=m.getSistema()) {
			m=CambioDeMagnitud.getInstance().cambiarSistema(this.m1.getSb().abrev(), m);
		}else {
			m.cambioLocal(this.getSb().abrev());
		}
		if (this.getCantidad() == m.getCantidad())
			return 0;
		else if(this.getCantidad()>m.getCantidad())
			return 1;
		else 
			return -1;
	}
	



}
