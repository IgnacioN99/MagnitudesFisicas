package info.unlp.conversor.sistemaInternacional.derivadas;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.TipoMagnitud;
import info.unlp.conversor.sistemaIngles.Pie;
import info.unlp.conversor.sistemaInternacional.Metro;

public class Superficie extends Magnitud {

	private Magnitud m1=new Metro(),m2=new Metro();

	public Superficie(double cant1, double cant2) {
		super(TipoMagnitud.SUP,1);
		m1 = new Metro(cant1,"m");
		m2= new Metro(cant2,"m");
		super.setSb(m1.getSb());
	}
	
	
	public Superficie(double cant, String unidad) {
		// TODO Auto-generated constructor stub
		super(TipoMagnitud.SUP);
		if(m1.cambioLocal(unidad)) {
			m1= new Metro(1,unidad);
			m2= new Metro(cant,unidad);
		}else {
			m1= new Pie(1,unidad);
			m2= new Pie(cant,unidad);	
		}
		super.setSistema(m1.getSistema());
		super.setSb(m1.getSb());
	}
	public Superficie(double cant1, double cant2, String unidad) {
		super(TipoMagnitud.SUP);
		if(m1.cambioLocal(unidad)) {
			m1= new Metro(cant1,unidad);
			m2= new Metro(cant2,unidad);
		}else {
			m1= new Pie(cant1,unidad);
			m2= new Pie(cant2,unidad);	
		}
		super.setSistema(m1.getSistema());
		super.setSb(m1.getSb());
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
		return m1.getCantidad()*m2.getCantidad();
	}

}
