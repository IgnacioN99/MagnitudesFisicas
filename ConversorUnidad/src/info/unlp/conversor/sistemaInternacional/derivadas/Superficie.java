package info.unlp.conversor.sistemaInternacional.derivadas;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.TipoMagnitud;
import info.unlp.conversor.sistemaIngles.LongIngles;
import info.unlp.conversor.sistemaInternacional.LongInternacional;

/**
 * Clase superficie que se encarga de manejar los cambios locales de sistema y contiene sobreescrito los metodos de suma,resta y comparacion del mismo
 */
public class Superficie extends Magnitud {

	/** superficie contiene 2 instancias de magnitud ya que el calgulo del mismo es el producto de 2 longitudes. */
	private Magnitud m1=new LongInternacional(),m2=new LongInternacional();

	/**
	 * Crea una nueva superficie
	 *
	 * @param cant1 primera medida
	 * @param cant2 degunda medida
	 */
	public Superficie(double cant1, double cant2) {
		super(TipoMagnitud.SUP,1);
		m1 = new LongInternacional(cant1,"m");
		m2= new LongInternacional(cant2,"m");
		super.setSb(m1.getSb());
	}
	
	/**
	 * Crea una nueva superficie
	 *
	 * @param cant cantidad total de la superficie
	 * @param unidad unidad de la superficie
	 */
	public Superficie(double cant, String unidad) {
		// TODO Auto-generated constructor stub
		super(TipoMagnitud.SUP);
		if(m1.cambioLocal(unidad)) {
			m1= new LongInternacional(1,unidad);
			m2= new LongInternacional(cant,unidad);
		}else {
			m1= new LongIngles(1,unidad);
			m2= new LongIngles(cant,unidad);	
		}
		super.setSistema(m1.getSistema());
		super.setSb(m1.getSb());
	}
	
	/**
	 * Instantiates a new superficie.
	 *
	 * @param cant1 primera medida
	 * @param cant2 degunda medida
	 * @param unidad unidad de la superficie
	 */
	public Superficie(double cant1, double cant2, String unidad) {
		super(TipoMagnitud.SUP);
		if(m1.cambioLocal(unidad)) {
			m1= new LongInternacional(cant1,unidad);
			m2= new LongInternacional(cant2,unidad);
		}else {
			m1= new LongIngles(cant1,unidad);
			m2= new LongIngles(cant2,unidad);	
		}
		super.setSistema(m1.getSistema());
		super.setSb(m1.getSb());
	}

	/**
	 * Cambio local de unidad.
	 *
	 * @param unidad a la que se quiere cambiar
	 * @return devuelve si el cambio fue satisfactorio o no
	 */
	@Override
	public boolean cambioLocal(String unidad) {
		return m1.cambioLocal(unidad)&& m2.cambioLocal(unidad);
	}

	/**
	 * metodo toString
	 * @return la magnitud en un string
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return m1.getCantidad()*m2.getCantidad()+" "+m1.getSb().abrev()+"²";
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

	public double getCantidad() {
		return m1.getCantidad()*m2.getCantidad();
	}
	
	
	public void setM2(Magnitud m2) {
		this.m2 = m2;
	}
	
	//****************	Getters y setters ****************//
	
	/**
	 * suma la instancia actual de Superficie con la instancia pasada por parametro.
	 *
	 * @param la magnitud que se quiere sumar
	 * @return Magnitud resultado
	 */
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
	 * Resta la instancia actual de superficie con la que es pasada por parametro
	 *
	 * @param m magnitud a ser restada
	 * @return resultado de la resta
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
	 * se compara la instancia actual de Superficie con la que es pasada por parametro
	 *
	 * @param m Superficie a comparar
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
