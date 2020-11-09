package info.unlp.conversor.sistemaInternacional.derivadas;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.Subfijo;
import info.unlp.conversor.Tiempo;
import info.unlp.conversor.sistemaIngles.LongIngles;
import info.unlp.conversor.sistemaInternacional.LongInternacional;

public class Velocidad extends Magnitud {
	private Magnitud m = new LongInternacional(), s;
	private Subfijo segundo;

	public Velocidad(double cantm, double cants) {
		super(1);
		setM(new LongInternacional(cantm / cants, "m"));
		setS(new Tiempo(1, "s"));
		super.setSb(SubfijoDerivadas.MS);
		segundo = s.getSb();
	}
	public Velocidad(double cantm, double cants,String unidadD, String unidadT) {
		super(1);
		if (m.cambioLocal(unidadD)) {
			setM(new LongInternacional(cantm / cants, unidadD));
		} else {
			setM(new LongIngles(cantm / cants, unidadD));
		}
		setS(new Tiempo(1,unidadT));
		super.setSb(SubfijoDerivadas.MS);
		segundo = s.getSb();
	}
	public Velocidad(double cantm, double cants,String unidad) {
		super(1);
		String[] aux = unidad.split("/");
		if (m.cambioLocal(aux[0])) {
			setM(new LongInternacional(cantm / cants, aux[0]));
		} else {
			setM(new LongIngles(cantm / cants, aux[0]));
		}
		setS(new Tiempo(1, aux[1]));
		super.setSb(SubfijoDerivadas.MS);
		segundo = s.getSb();
	}

	public Velocidad(double velocidad) {
		super( 1);
		setM(new LongInternacional(velocidad, "m"));
		setM(new Tiempo(1, "s"));
		super.setSb(SubfijoDerivadas.MS);
		segundo = s.getSb();
	}

	public Velocidad(double velocidad, String unidadD, String unidadT) {
		super(1);
		if (m.cambioLocal(unidadD)) {
			setM(new LongInternacional(velocidad, unidadD));
		} else {
			setM(new LongIngles(velocidad, unidadD));
		}
		setS(new Tiempo(1, unidadT));
		super.setSb(SubfijoDerivadas.MS);
		segundo = s.getSb();
	}

	public Velocidad(double velocidad, String unidad) {
		super(1);
		String[] aux = unidad.split("/");
		if (m.cambioLocal(aux[0])) {
			setM(new LongInternacional(velocidad, aux[0]));
		} else {
			setM(new LongIngles(velocidad, aux[0]));
		}
		setS(new Tiempo(1, aux[1]));
		super.setSb(SubfijoDerivadas.MS);
		segundo = s.getSb();
	}

	public boolean cambioLocal(String unidadD, String unidadT) {
		return m.cambioLocal(unidadD) && s.cambioLocal(unidadT);
	}

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return m.getCantidad() * s.getCantidad() + " " + m.getSb().abrev() + "/" + s.getSb().abrev();
	}

	public Magnitud suma(Magnitud m) {
		Magnitud ret;
		if (m.getSistema() != this.getSistema()) {
			Magnitud aux = CambioDeMagnitud.getInstance().cambiarSistema(this.m.getSb().abrev() + "/" + segundo.abrev(),
					m);
			ret = new Velocidad(this.getCantidad() + aux.getCantidad(), this.m.getSb().abrev()+ "/" + segundo.abrev());
		} else {
			((Velocidad) m).cambioLocal(m.getSb().abrev(), s.getSb().abrev());
			ret = new Velocidad(this.getCantidad() + m.getCantidad(), this.m.getSb().abrev() + "/" + segundo.abrev());
		}
		return ret;
	}

	public Magnitud resto(Magnitud m) {
		Magnitud ret;
		if (m.getSistema() != this.getSistema()) {
			Magnitud aux = CambioDeMagnitud.getInstance().cambiarSistema(this.m.getSb().abrev() + "/" + segundo.abrev(),
					m);
			ret = new Velocidad(this.getCantidad() + aux.getCantidad(), this.m.getSb().abrev() + "/" + segundo.abrev());
		} else {
			((Velocidad) m).cambioLocal(m.getSb().abrev(), s.getSb().abrev());
			ret = new Velocidad(this.getCantidad() + m.getCantidad(), this.m.getSb().abrev() + "/" + segundo.abrev());
		}
		return ret;
	}
	
	public int comparar(Magnitud m) {
		if(this.getSistema()!=m.getSistema()) {
			m=CambioDeMagnitud.getInstance().cambiarSistema(this.m.getSb().abrev() + "/" + segundo.abrev(),
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
	public double getCantidad() {
		return m.getCantidad() * s.getCantidad();
	}

}