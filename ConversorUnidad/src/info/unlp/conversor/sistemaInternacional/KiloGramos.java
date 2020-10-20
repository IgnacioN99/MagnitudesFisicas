package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Peso;
import info.unlp.conversor.TipoMagnitud;

public class KiloGramos extends Peso {

	public KiloGramos(double cantidad, String unidad) {
		super(TipoMagnitud.KILOGRAMOS, 1);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
		super.setSb(SubfijoKilogramos.Kilogramo);
	}

	public double cambiarSistema() {
		return (super.getCantidad() * 2.20462);
	}

	@Override
	public boolean cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "mg":
			super.setCantidad(getCantidad() * SubfijoKilogramos.Miligramo.mult());
			return true;
		case "g":
			super.setCantidad(getCantidad() * SubfijoKilogramos.Gramo.mult());
			return true;
		case "ton":
			super.setCantidad(getCantidad() * SubfijoKilogramos.Tonelada.mult());
			return true;
		default:
			return false;
		}
	}

}
