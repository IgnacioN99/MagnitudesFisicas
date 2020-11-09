package info.unlp.conversor.sistemaInternacional.derivadas;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.sistemaIngles.LongIngles;
import info.unlp.conversor.sistemaInternacional.LongInternacional;

/**
 * Clase superficie que se encarga de manejar los cambios locales de sistema y contiene sobreescrito los metodos de suma,resta y comparacion del mismo
 */
public class Area extends Magnitud {

	private Magnitud m1=new LongInternacional(),m2=new LongInternacional();

	/**
	 * Crea una nueva superficie
	 *
	 * @param cant1 primera medida
	 * @param cant2 degunda medida
	 */
	public Area(double cant1, double cant2) {
		super(1);
		m1 = new LongInternacional(cant1,"m");
		m2= new LongInternacional(cant2,"m");
		super.setSb(SubfijoDerivadas.M2);
	}	
	/**
	 * Crea una nueva superficie
	 *
	 * @param cant cantidad total de la superficie
	 * @param unidad unidad de la superficie
	 */
	public Area(double cant, String unidad) {
		// TODO Auto-generated constructor stub
		super(1);
		if(m1.cambioLocal(unidad)) {
			m1= new LongInternacional(1,unidad);
			m2= new LongInternacional(cant,unidad);
		}else {
			m1= new LongIngles(1,unidad);
			m2= new LongIngles(cant,unidad);	
		}
		super.setSb(SubfijoDerivadas.M2);
	}
	
	/**
	 * Instantiates a new superficie.
	 *
	 * @param cant1 primera medida
	 * @param cant2 degunda medida
	 * @param unidad unidad de la superficie
	 */
	public Area(double cant1, double cant2, String unidad) {
		super(1);
		if(m1.cambioLocal(unidad)) {
			m1= new LongInternacional(cant1,unidad);
			m2= new LongInternacional(cant2,unidad);
		}else {
			m1= new LongIngles(cant1,unidad);
			m2= new LongIngles(cant2,unidad);	
		}
		super.setSb(SubfijoDerivadas.M2);
	}

	@Override
	public boolean cambioLocal(String unidad) {
		return m1.cambioLocal(unidad)&& m2.cambioLocal(unidad);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return m1.getCantidad()*m2.getCantidad()+" "+m1.getSb().abrev()+"²";
	}


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
	
	public Magnitud suma(Magnitud m) {
		Magnitud ret=null;
		if(this.getSistema()!=m.getSistema()) {
			Magnitud aux=CambioDeMagnitud.getInstance().cambiarSistema(this.m1.getSb().abrev(), m);
			ret= new Volumen(aux.getCantidad()+this.getCantidad(),this.m1.getSb().abrev());
		}else {
			m.cambioLocal(this.getSb().abrev());
			ret= new Volumen(m.getCantidad()+this.getCantidad(),this.m1.getSb().abrev());
		}
		return ret;
	}
	public Magnitud resta(Magnitud m) {
		Magnitud ret=null;
		if(this.getSistema()!=m.getSistema()) {
			Magnitud aux=CambioDeMagnitud.getInstance().cambiarSistema(this.m1.getSb().abrev(), m);
			ret= new Volumen(aux.getCantidad()-this.getCantidad(),this.m1.getSb().abrev());
		}else {
			m.cambioLocal(this.m1.getSb().abrev());
			ret= new Volumen(m.getCantidad()-this.getCantidad(),this.m1.getSb().abrev());
		}
		return ret;
	}
	
	public int comparar(Magnitud m) {
		if(this.getSistema()!=m.getSistema()) {
			m=CambioDeMagnitud.getInstance().cambiarSistema(this.m1.getSb().abrev(), m);
		}else {
			m.cambioLocal(this.m1.getSb().abrev());
		}
		if (this.getCantidad() == m.getCantidad())
			return 0;
		else if(this.getCantidad()>m.getCantidad())
			return 1;
		else 
			return -1;
	}
	public double getCantidad() {
		return m1.getCantidad()*m2.getCantidad();
	}

}
