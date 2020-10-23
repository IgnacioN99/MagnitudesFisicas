package info.unlp.conversor;

import info.unlp.conversor.sistemaIngles.Libra;
import info.unlp.conversor.sistemaIngles.Pie;
import info.unlp.conversor.sistemaInternacional.KiloGramos;
import info.unlp.conversor.sistemaInternacional.Metro;
import info.unlp.conversor.sistemaInternacional.derivadas.Superficie;
import info.unlp.conversor.sistemaInternacional.derivadas.Velocidad;
import info.unlp.conversor.sistemaInternacional.derivadas.Volumen;

public class CambioDeMagnitud {
	private static CambioDeMagnitud instancia=new CambioDeMagnitud();
	private CambioDeMagnitud() {
	}
	public static CambioDeMagnitud getInstance() {
		return instancia;
	}
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
		case SUP:
			return cambiarSistema((Superficie)algo, unidad);
		case VELOCIDAD:
			String[] partes=unidad.split("/");
			return cambiarSistema(partes[0], partes[1], (Velocidad)algo);
		case VOLUMEN:
			return cambiarSistema(unidad, (Volumen)algo);
		default:
			return null;
		}
	}
	private Magnitud cambiarSistema(String unidad, Volumen vol) {
		Volumen v=vol;
		v.setM1(this.cambiarSistema(unidad, v.getM1()));
		v.setM3(this.cambiarSistema(unidad, v.getM3()));
		v.setM2(this.cambiarSistema(unidad, v.getM2()));
		return v;
	}
	private Magnitud cambiarSistema(String unidad, Metro distIntl) {
		Pie m;
		distIntl.cambioLocal("m");
		m = new Pie(distIntl.getCantidad() * 3.2808, "ft");
		m.cambioLocal(unidad);
		return m;
	}

	private Magnitud cambiarSistema(String unidad, KiloGramos pesoIntl) {
		Libra m;
		pesoIntl.cambioLocal("kg");
		m = new Libra(pesoIntl.getCantidad() * 2.2046, "lb");
		m.cambioLocal(unidad);
		return m;
	}

	private Magnitud cambiarSistema(String unidad, Libra pesoIng) {
		KiloGramos m;
		pesoIng.cambioLocal("lb");
		m = new KiloGramos(pesoIng.getCantidad() * 0.453592, "kg");
		m.cambioLocal(unidad);
		return m;
	}

	private Magnitud cambiarSistema(String unidad, Pie distIng) {
		Metro m;
		distIng.cambioLocal("ft");
		m = new Metro(distIng.getCantidad() * 0.3048, "m");
		m.cambioLocal(unidad);
		return m;
	}
	private Magnitud cambiarSistema(Superficie sup, String unidad) {
		Superficie s=sup;
		s.setM1(this.cambiarSistema(unidad, s.getM1()));
		s.setM2(this.cambiarSistema(unidad, s.getM2()));
		s.setSistema(s.getM1().getSistema());
		return s;
	}
	private Magnitud cambiarSistema(String unidadD,String unidadT, Velocidad vel) {
		Velocidad v=vel;
		v.setM(this.cambiarSistema(unidadD, v.getM()));
		v.getS().cambioLocal(unidadT);
		return v;
	}

}
