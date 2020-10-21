package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Magnitud;
import info.unlp.conversor.TipoMagnitud;

public class Superficie extends Magnitud {

	Magnitud m1,m2;

	public Superficie(TipoMagnitud id, int sistema, double cant1, double cant2) {
		super(id, sistema);
		m1 = new Metro(cant1,"m");
		m2= new Metro(cant2,"m");
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public boolean cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		return false;
	}

}
