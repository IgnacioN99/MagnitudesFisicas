package info.unlp.conversor.sistemaInternacional.derivadas;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.TipoMagnitud;
import info.unlp.conversor.sistemaIngles.Pie;
import info.unlp.conversor.sistemaInternacional.Metro;

public class Volumen extends Magnitud {

	private Magnitud m1 = new Metro(), m2, m3;

	public Volumen(double cant1, double cant2, double cant3) {
		super(TipoMagnitud.VOLUMEN, 1);
		m1 = new Metro(cant1, "m");
		m2 = new Metro(cant2, "m");
		m3 = new Metro(cant3, "m");
		super.setSb(m1.getSb());
	}

	public Volumen(double cant) {
		super(TipoMagnitud.VOLUMEN, 1);
		m1 = new Metro(cant, "m");
		m2 = new Metro(1, "m");
		m3 = new Metro(1, "m");
		super.setSb(m1.getSb());
	}

	public Volumen(double cant, String unidad) {
		super(TipoMagnitud.VOLUMEN);
		if (m1.cambioLocal(unidad)) {
			m1 = new Metro(cant, unidad);
			m2 = new Metro(1, unidad);
			m3 = new Metro(1, unidad);
			super.setSistema(1);
		} else {
			m1 = new Pie(cant, unidad);
			m2 = new Pie(1, unidad);
			m3 = new Pie(1, unidad);
			super.setSistema(2);
		}
		super.setSb(m1.getSb());
	}
	public Volumen(double cant1, double cant2, double cant3, String unidad) {
		super(TipoMagnitud.VOLUMEN);
		if (m1.cambioLocal(unidad)) {
			m1 = new Metro(cant1, unidad);
			m2 = new Metro(cant2, unidad);
			m3 = new Metro(cant3, unidad);
			super.setSistema(1);
		} else {
			m1 = new Pie(cant1, unidad);
			m2 = new Pie(cant2, unidad);
			m3 = new Pie(cant3, unidad);
			super.setSistema(2);
		}
		super.setSb(m1.getSb());
	}

	@Override
	public boolean cambioLocal(String unidad) {
		return m1.cambioLocal(unidad) && m2.cambioLocal(unidad) && m3.cambioLocal(unidad);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return m1.getCantidad()*m2.getCantidad()*m3.getCantidad()+" "+m1.getSb().abrev()+"³";
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

	public Magnitud getM3() {
		return m3;
	}

	public void setM3(Magnitud m3) {
		this.m3 = m3;
	}
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
	public double getCantidad() {
		return m1.getCantidad()*m2.getCantidad()*m3.getCantidad();
	}

}
