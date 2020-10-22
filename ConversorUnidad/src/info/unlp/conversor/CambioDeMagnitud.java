package info.unlp.conversor;

import info.unlp.conversor.sistemaIngles.Libra;
import info.unlp.conversor.sistemaIngles.Pie;
import info.unlp.conversor.sistemaInternacional.KiloGramos;
import info.unlp.conversor.sistemaInternacional.Metro;

public class CambioDeMagnitud {
	public Magnitud cambiarSistema(String unidad, Magnitud algo) {
		switch (algo.getId()) {
		case METRO:
			return cambiarSistema(unidad, (Metro) algo);
		case KILOGRAMOS:
			return cambiarSistema(unidad, (KiloGramos)algo);
		case LIBRA:
			return cambiarSistema(unidad, (Libra)algo);
		case PIE:
			return cambiarSistema(unidad, (Pie)algo);
		default:
			return null;
		}
	}

	private Magnitud cambiarSistema(String unidad, Metro distIntl) {
		Magnitud m;
		distIntl.cambioLocal("m");
		m = new Pie(distIntl.getCantidad() * 3.2808, "ft");
		m.cambioLocal(unidad);
		return m;
	}

	private Magnitud cambiarSistema(String unidad, KiloGramos pesoIntl) {
		Magnitud m;
		pesoIntl.cambioLocal("kg");
		m = new Libra(pesoIntl.getCantidad() * 2.2046, "lb");
		m.cambioLocal(unidad);
		return m;
	}

	private Magnitud cambiarSistema(String unidad, Libra pesoIng) {
		Magnitud m;
		pesoIng.cambioLocal("lb");
		m = new KiloGramos(pesoIng.getCantidad() * 0.453592, "kg");
		m.cambioLocal(unidad);
		return m;
	}

	private Magnitud cambiarSistema(String unidad, Pie distIng) {
		Magnitud m;
		distIng.cambioLocal("ft");
		m = new Metro(distIng.getCantidad() * 0.3048, "m");
		m.cambioLocal(unidad);
		return m;
	}

}
