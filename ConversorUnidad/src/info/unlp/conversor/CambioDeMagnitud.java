package info.unlp.conversor;

import info.unlp.conversor.sistemaIngles.PesoIngles;
import info.unlp.conversor.sistemaIngles.LongIngles;
import info.unlp.conversor.sistemaInternacional.PesoInternacional;
import info.unlp.conversor.sistemaInternacional.LongInternacional;
import info.unlp.conversor.sistemaInternacional.derivadas.Area;
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
		switch (algo.getSb().getTipoMagnitud()) {
		case LONGINT:
			return cambiarSistema(unidad, (LongInternacional) algo);
		case PESOINT:
			return cambiarSistema(unidad, (PesoInternacional)algo);
		case PESOING:
			return cambiarSistema(unidad, (PesoIngles)algo);
		case LONGING:
			return cambiarSistema(unidad, (LongIngles)algo);
		case AREA:
			return cambiarSistema((Area)algo, unidad);
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
	private Magnitud cambiarSistema(String unidad, LongInternacional distIntl) {
		LongIngles m;
		distIntl.cambioLocal("m");
		m = new LongIngles(distIntl.getCantidad() * 3.2808, "ft");
		m.cambioLocal(unidad);
		return m;
	}

	private Magnitud cambiarSistema(String unidad, PesoInternacional pesoIntl) {
		PesoIngles m;
		pesoIntl.cambioLocal("kg");
		m = new PesoIngles(pesoIntl.getCantidad() * 2.2046, "lb");
		m.cambioLocal(unidad);
		return m;
	}

	private Magnitud cambiarSistema(String unidad, PesoIngles pesoIng) {
		PesoInternacional m;
		pesoIng.cambioLocal("lb");
		m = new PesoInternacional(pesoIng.getCantidad() * 0.453592, "kg");
		m.cambioLocal(unidad);
		return m;
	}

	private Magnitud cambiarSistema(String unidad, LongIngles distIng) {
		LongInternacional m;
		distIng.cambioLocal("ft");
		m = new LongInternacional(distIng.getCantidad() * 0.3048, "m");
		m.cambioLocal(unidad);
		return m;
	}
	

	private Magnitud cambiarSistema(Area sup, String unidad) {
		Area s=sup;
		s.setM1(this.cambiarSistema(unidad, s.getM1()));
		s.setM2(this.cambiarSistema(unidad, s.getM2()));
		return s;
	}
	private Magnitud cambiarSistema(String unidadD,String unidadT, Velocidad vel) {
		Velocidad v=vel;
		v.setM(this.cambiarSistema(unidadD, v.getM()));
		v.getS().cambioLocal(unidadT);
		return v;
	}

}
