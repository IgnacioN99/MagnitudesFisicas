package info.unlp.conversor.sistemaInternacional.derivadas;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.Subfijo;
import info.unlp.conversor.Tiempo;
import info.unlp.conversor.TipoMagnitud;
import info.unlp.conversor.sistemaIngles.LongIngles;
import info.unlp.conversor.sistemaInternacional.LongInternacional;

/**
 * Clase Velocidad que se encarga de manejar los cambios locales de sistema y contiene sobreescrito los metodos de suma,resta y comparacion del mismo
 */
public class Velocidad extends Magnitud {
	
	//La clase consta de 2 objetos de tipo magnitud que luego pasaran a ser distancia y tiempo ya que la velocidad es dx/dt
	private Magnitud m = new LongInternacional(), s;
	
	/** Prefijo del tiempo en la clase */
	private Subfijo segundo;

	/**
	 * Crea una nueva instancia de velocidad con unidades en m/s
	 *
	 * @param cantm Cantidad de metros
	 * @param cants Cantidad de segundos
	 */
	public Velocidad(double cantm, double cants) {
		super(TipoMagnitud.VELOCIDAD, 1);
		setM(new LongInternacional(cantm / cants, "m"));
		setS(new Tiempo(1, "s"));
		super.setSb(m.getSb());
		segundo = s.getSb();
	}
	
	/**
	 * Crea una nueva instancia de velocidad en el que se le pasa la distancia recorrida en un tiempo x con sus respectivas unidades
	 *
	 * @param cantm Cantidad de distancia recorrida
	 * @param cants tiempo del recorrido
	 * @param unidadD unidad de distancia
	 * @param unidadT unidad de tiempo
	 */
	public Velocidad(double cantm, double cants,String unidadD, String unidadT) {
		super(TipoMagnitud.VELOCIDAD, 1);
		if (m.cambioLocal(unidadD)) {
			setM(new LongInternacional(cantm / cants, unidadD));
		} else {
			setM(new LongIngles(cantm / cants, unidadD));
		}
		setS(new Tiempo(1,unidadT));
		super.setSistema(m.getSistema());
		super.setSb(m.getSb());
		segundo = s.getSb();
	}
	
	/**
	 * Crea una nueva instancia de velocidad en el que se le pasa la cantidad de distancia recorrida en un x tiempo con una sola unidad
	 *
	 * @param cantm Cantidad de distancia recorrida
	 * @param cants tiempo del recorrido
	 * @param unidad unidad en la que estara la velocidad
	 */
	public Velocidad(double cantm, double cants,String unidad) {
		super(TipoMagnitud.VELOCIDAD, 1);
		String[] aux = unidad.split("/");
		if (m.cambioLocal(aux[0])) {
			setM(new LongInternacional(cantm / cants, aux[0]));
		} else {
			setM(new LongIngles(cantm / cants, aux[0]));
		}
		setS(new Tiempo(1, aux[1]));
		super.setSistema(m.getSistema());
		super.setSb(m.getSb());
		segundo = s.getSb();
	}

	/**
	 * Crea una nueva instancia de velocidad en el que se le pasa solamente la velocidad, se toma como unidad de medida metro/segundo
	 *
	 * @param velocidad velocidad pasada
	 */
	public Velocidad(double velocidad) {
		super(TipoMagnitud.VELOCIDAD, 1);
		setM(new LongInternacional(velocidad, "m"));
		setM(new Tiempo(1, "s"));
		super.setSb(m.getSb());
		segundo = s.getSb();
	}

	/**
	 * Crea una nueva instancia de velocidad en el que se le pasa la velocidad y las unidades en las que trabaja 
	 *
	 * @param velocidad velocidad pasada
	 * @param unidadD unidad de distancia
	 * @param unidadT unidad de tiempo
	 */
	public Velocidad(double velocidad, String unidadD, String unidadT) {
		super(TipoMagnitud.VELOCIDAD);
		if (m.cambioLocal(unidadD)) {
			setM(new LongInternacional(velocidad, unidadD));
		} else {
			setM(new LongIngles(velocidad, unidadD));
		}
		setS(new Tiempo(1, unidadT));
		super.setSistema(getM().getSistema());
		super.setSb(m.getSb());
		segundo = s.getSb();
	}

	/**
	 * Crea una nueva instancia de velocidad en el que se le pasa la velocidad y su unidad
	 *
	 * @param velocidad pasada
	 * @param unidad unidad en la que se trabaja
	 */
	public Velocidad(double velocidad, String unidad) {
		super(TipoMagnitud.VELOCIDAD);
		String[] aux = unidad.split("/");
		if (m.cambioLocal(aux[0])) {
			setM(new LongInternacional(velocidad, aux[0]));
		} else {
			setM(new LongIngles(velocidad, aux[0]));
		}
		setS(new Tiempo(1, aux[1]));
		super.setSistema(m.getSistema());
		super.setSb(m.getSb());
		segundo = s.getSb();
	}

	/**
	 * Cambio local de unidades.
	 *
	 * @param unidadD unidad de distancia
	 * @param unidadT unidad de tiempo
	 * @return devuelve el resultado del cambio
	 */
	public boolean cambioLocal(String unidadD, String unidadT) {
		return m.cambioLocal(unidadD) && s.cambioLocal(unidadT);
	}

	//****************	Getters y setters ****************//
	
	public Magnitud getS() {
		return s;
	}

	public void setS(Magnitud s) {
		this.s = s;
	}

	public Magnitud getM() {
		return m;
	}

	public void setM(Magnitud m) {
		this.m = m;
	}
	
	public double getCantidad() {
		return m.getCantidad() * s.getCantidad();
	}
	
	//****************	Getters y setters ****************//


	/**
	 * To string.
	 *
	 * @return velocidad con su unidad de medida
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return m.getCantidad() * s.getCantidad() + " " + m.getSb().abrev() + "/" + s.getSb().abrev();
	}

	/**
	 * Suma la instancia actual con la pasada por parametro.
	 *
	 * @param m Magnitud a ser sumada
	 * @return resultado de la suma
	 */
	public Magnitud suma(Magnitud m) {
		Magnitud ret;
		if (m.getSistema() != this.getSistema()) {
			Magnitud aux = CambioDeMagnitud.getInstance().cambiarSistema(this.getSb().abrev() + "/" + segundo.abrev(),
					m);
			ret = new Velocidad(this.getCantidad() + aux.getCantidad(), this.getSb().abrev() + "/" + segundo.abrev());
		} else {
			((Velocidad) m).cambioLocal(m.getSb().abrev(), s.getSb().abrev());
			ret = new Velocidad(this.getCantidad() + m.getCantidad(), this.getSb().abrev() + "/" + segundo.abrev());
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
		Magnitud ret;
		if (m.getSistema() != this.getSistema()) {
			Magnitud aux = CambioDeMagnitud.getInstance().cambiarSistema(this.getSb().abrev() + "/" + segundo.abrev(),
					m);
			ret = new Velocidad(this.getCantidad() + aux.getCantidad(), this.getSb().abrev() + "/" + segundo.abrev());
		} else {
			((Velocidad) m).cambioLocal(m.getSb().abrev(), s.getSb().abrev());
			ret = new Velocidad(this.getCantidad() + m.getCantidad(), this.getSb().abrev() + "/" + segundo.abrev());
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
			m=CambioDeMagnitud.getInstance().cambiarSistema(this.getSb().abrev() + "/" + segundo.abrev(),
					m);
		}else {
			((Velocidad) m).cambioLocal(m.getSb().abrev(), s.getSb().abrev());
		}
		if (this.getCantidad() == m.getCantidad())
			return 0;
		else if(this.getCantidad()>m.getCantidad())
			return 1;
		else 
			return -1;
	}
	


}