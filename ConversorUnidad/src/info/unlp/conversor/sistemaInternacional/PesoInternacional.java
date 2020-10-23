package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Peso;
import info.unlp.conversor.TipoMagnitud;


public class PesoInternacional extends Peso {

	public PesoInternacional(double cantidad, String unidad) {
		super(TipoMagnitud.KILOGRAMOS, 1);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
	}
	public PesoInternacional() {
		super(TipoMagnitud.KILOGRAMOS, 1);
		super.setCantidad(0);
		cambioLocal("kg");
	}


	@Override
	public boolean cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "mg":
			this.cambiomg();
			return true;
		case "g":
			this.cambiog();
			return true;
		case "ton":
			this.cambioton();
			return true;
		case "kg":
			this.cambiokg();
			return true;
		default:
			return false;
		}
	}

	private void cambiomg() {
		if (super.getSb() != null)
			switch (super.getSb().abrev()) {
			case "g":
				super.setCantidad(super.getCantidad() / 0.001);
				break;
			case "kg":
				super.setCantidad(super.getCantidad() / 0.000001);
				break;
			case "ton":
				super.setCantidad(super.getCantidad() / 0.000000001);
				break;
			default:
				break;
			}
		super.setSb(SubfijoKilogramos.Miligramo);
	}

	private void cambiog() {
		if (super.getSb() != null) {
			switch (super.getSb().abrev()) {
			case "mg":
				super.setCantidad(getCantidad() / 1000);
				break;
			case "kg":
				super.setCantidad(getCantidad() / 0.001);
				break;
			case "ton":
				super.setCantidad(getCantidad() / 0.000001);
				break;
			default:
				break;
			}
		}

		super.setSb(SubfijoKilogramos.Gramo);
	}

	private void cambiokg() {
		if (super.getSb() != null)
			switch (super.getSb().abrev()) {
			case "g":
				super.setCantidad(getCantidad() / 1000);
				break;
			case "mg":
				super.setCantidad(getCantidad() / 1000000);
				break;
			case "ton":
				super.setCantidad(getCantidad() / 0.001);
				break;
			default:
				break;
			}
		super.setSb(SubfijoKilogramos.Kilogramo);
	}

	private void cambioton() {
		if (super.getSb() != null)
			switch (super.getSb().abrev()) {
			case "g":
				super.setCantidad(getCantidad() / 1000000);
				break;
			case "kg":
				super.setCantidad(getCantidad() / 1000);
				break;
			case "mg":
				super.setCantidad(getCantidad() / 1000000000);
				break;
			default:
				break;
			}
		super.setSb(SubfijoKilogramos.Tonelada);
	}


}
