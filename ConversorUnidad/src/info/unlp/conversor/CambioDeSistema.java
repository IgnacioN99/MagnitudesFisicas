package info.unlp.conversor;

import info.unlp.conversor.magnitudes.Peso;
import info.unlp.conversor.sistemaIngles.LongIngles;
import info.unlp.conversor.sistemaIngles.subfijosLong.Pie;
import info.unlp.conversor.sistemaIngles.subfijosMasa.Libra;
import info.unlp.conversor.sistemaInternacional.LongInternacional;
import info.unlp.conversor.sistemaInternacional.PesoInternacional;
import info.unlp.conversor.sistemaInternacional.subfijosLong.Metro;
import info.unlp.conversor.sistemaInternacional.subfijosMasa.KiloGramo;

public class CambioDeSistema {
	private static CambioDeSistema instancia=new CambioDeSistema();
	private CambioDeSistema() {
	}
	public static CambioDeSistema getInstance() {
		return instancia;
	}
	public Magnitud cambiarSistema(String unidad, LongInternacional distIntl) {
		Magnitud m;
		distIntl.cambioLocal("m");
		m = new Pie(distIntl.getCantidad() * 3.2808).cambioLocal(unidad);
		return  m;
	}
	public Magnitud cambiarSistema(String unidad, LongIngles distIng) {
		Magnitud m;
		distIng.cambioLocal("ft");
		m = new Metro(distIng.getCantidad() * 0.3048).cambioLocal(unidad);
		return m;
	}

	public Magnitud cambiarSistema(String unidad, PesoInternacional pesoIntl) {
		Magnitud m;
		pesoIntl.cambioLocal("kg");
		m = new Libra(pesoIntl.getCantidad() * 2.2046).cambioLocal(unidad);
		return m;
	}

	public Magnitud cambiarSistema(String unidad, Peso pesoIng) {
		Magnitud m;
		pesoIng.cambioLocal("lb");
		m = new KiloGramo(pesoIng.getCantidad() * 0.453592).cambioLocal(unidad);
		m.cambioLocal(unidad);
		return m;
	}
	//public Magnitud cambiarSistema(Derivadas);

}
