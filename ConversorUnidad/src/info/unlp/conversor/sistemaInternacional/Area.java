package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Magnitud;
import info.unlp.conversor.TipoMagnitud;

public class Area extends Magnitud {

	public Area(TipoMagnitud id, int sistema) {
		super(id, sistema);
		
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
