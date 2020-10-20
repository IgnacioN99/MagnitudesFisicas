package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Peso;
import info.unlp.conversor.TipoMagnitud;

public class KiloGramos extends Peso {

	public KiloGramos() {
		super(TipoMagnitud.KILOGRAMOS, 1);
		// TODO Auto-generated constructor stub
	}

	private SubfijoKilogramos s = SubfijoKilogramos.Kilogramo;

	public double cambiarSistema() {
		return (super.getCantidad() * 2.20462);
	}
	@Override
	public void cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "mg":
			super.setCantidad(getCantidad()*SubfijoKilogramos.Miligramo.mult());
			break;
		case "g":
			super.setCantidad(getCantidad()*SubfijoKilogramos.Gramo.mult());
			break;			
		case "ton":
			super.setCantidad(getCantidad()*SubfijoKilogramos.Tonelada.mult());
			break;
		}
	}

}
