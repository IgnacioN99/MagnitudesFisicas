package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Magnitud;
import info.unlp.conversor.TipoMagnitud;

public class Velocidad extends Magnitud{
	Magnitud m,s;
	public Velocidad(TipoMagnitud id, double cantidad) {
		super(id, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double cambiarSistema() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		return false;
	}
	
}