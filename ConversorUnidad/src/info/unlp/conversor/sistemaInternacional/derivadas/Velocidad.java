package info.unlp.conversor.sistemaInternacional.derivadas;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.Subfijo;
import info.unlp.conversor.Tiempo;
import info.unlp.conversor.TipoMagnitud;
import info.unlp.conversor.sistemaIngles.Pie;
import info.unlp.conversor.sistemaInternacional.Metro;

public class Velocidad extends Magnitud {
	private Magnitud m = new Metro(), s;
	private Subfijo segundo;

	public Velocidad(double cantm, double cants) {
		super(TipoMagnitud.VELOCIDAD, 1);
		setM(new Metro(cantm / cants, "m"));
		setS(new Tiempo(1, "s"));
		super.setSb(m.getSb());
		segundo = s.getSb();
	}

	public Velocidad(double velocidad) {
		super(TipoMagnitud.VELOCIDAD, 1);
		setM(new Metro(velocidad, "m"));
		setM(new Tiempo(1, "s"));
		super.setSb(m.getSb());
		segundo = s.getSb();

	}

	public Velocidad(double velocidad, String unidadD, String unidadT) {
		super(TipoMagnitud.VELOCIDAD);
		if (m.cambioLocal(unidadD)) {
			setM(new Metro(velocidad, unidadD));
		} else {
			setM(new Pie(velocidad, unidadD));
		}
		setS(new Tiempo(1, unidadT));
		super.setSistema(getM().getSistema());
		super.setSb(m.getSb());
		segundo = s.getSb();

	}

	public Velocidad(double velocidad, String unidad) {
		super(TipoMagnitud.VELOCIDAD);
		String[] aux = unidad.split("/");
		if (m.cambioLocal(aux[0])) {
			setM(new Metro(velocidad, aux[0]));
		} else {
			setM(new Pie(velocidad, aux[0]));
		}
		setS(new Tiempo(1, aux[1]));
		super.setSistema(m.getSistema());
		super.setSb(m.getSb());
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
			Magnitud aux = CambioDeMagnitud.getInstance().cambiarSistema(this.getSb().abrev() + "/" + segundo.abrev(),
					m);
			ret = new Velocidad(this.getCantidad() + aux.getCantidad(), this.getSb().abrev() + "/" + segundo.abrev());
		} else {
			((Velocidad) m).cambioLocal(m.getSb().abrev(), s.getSb().abrev());
			ret = new Velocidad(this.getCantidad() + m.getCantidad(), this.getSb().abrev() + "/" + segundo.abrev());
		}
		return ret;
	}

	public Magnitud resto(Magnitud m) {
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

}