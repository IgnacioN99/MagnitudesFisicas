package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Longitud;
import info.unlp.conversor.TipoMagnitud;

public class LongInternacional extends Longitud {

	public LongInternacional(double cantidad, String unidad) {
		super(TipoMagnitud.METRO, 1);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
	}
	public LongInternacional() {
		super(TipoMagnitud.METRO,1);
		super.setCantidad(0);
		cambioLocal("m");
	}
	

	@Override
	public boolean cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		switch (unidad.toLowerCase()) {
		case "cm":
			this.cambioCm();
			return true;
		case "mm":
			this.cambiomm();
			return true;
		case "km":
			this.cambiokm();
			return true;
		case "m":
			this.cambioM();
			return true;
		default:
			return false;
		}

	}

	private void cambioCm() {
		if (super.getSb() != null) {
			switch (super.getSb().abrev()) {
			case "m":
				super.setCantidad(getCantidad() / 0.01);
				break;
			case "mm":
				super.setCantidad(getCantidad() / 10);
				break;
			case "km":
				super.setCantidad(getCantidad() / 0.00001);
			default:
				break;
			}
		}
		super.setSb(SubfijoMetro.CentiMetro);
	}

	private void cambiomm() {
		if (super.getSb() != null) {
			switch (super.getSb().abrev()) {
			case "m":
				super.setCantidad(getCantidad() / 0.001);
				break;
			case "cm":
				super.setCantidad(getCantidad() / 0.1);
				break;
			case "km":
				super.setCantidad(getCantidad() / 0.000001);
			default:
				break;
			}
		}
		super.setSb(SubfijoMetro.MiliMetro);
	}
	
	private void cambiokm() {
		if (super.getSb() != null) {
			switch (super.getSb().abrev()) {
			case "m":
				super.setCantidad(getCantidad() / 1000);
				break;
			case "cm":
				super.setCantidad(getCantidad() / 100000);
				break;
			case "mm":
				super.setCantidad(getCantidad() / 1000000);
			default:
				break;
			}
		}
		super.setSb(SubfijoMetro.KiloMetro);
	}

	private void cambioM() {
		if (super.getSb() != null) {
			switch (super.getSb().abrev()) {
			case "km":
				super.setCantidad(getCantidad() / 0.001);
				break;
			case "cm":
				super.setCantidad(getCantidad() / 100);
				break;
			case "mm":
				super.setCantidad(getCantidad() / 1000);
			default:
				break;
			}
		}
		super.setSb(SubfijoMetro.Metro);
	}
}