package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Magnitud;
import info.unlp.conversor.TipoMagnitud;

public class Superficie extends Magnitud {

	public Superficie(TipoMagnitud id, int sistema) {
		super(id, sistema);
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
