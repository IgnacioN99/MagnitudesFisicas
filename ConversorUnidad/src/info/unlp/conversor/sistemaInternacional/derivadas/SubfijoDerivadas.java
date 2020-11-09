package info.unlp.conversor.sistemaInternacional.derivadas;

import info.unlp.conversor.Subfijo;

public enum SubfijoDerivadas implements Subfijo {
	M2("m^2"), MS("m/s"), M3("m^3");

	private String abrev;

	private SubfijoDerivadas(String abrev) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String abrev() {
		// TODO Auto-generated method stub
		return this.abrev;
	}

	@Override
	public TipoMagnitud getTipoMagnitud() {
		switch (this.abrev) {
		case "m^2":
			return TipoMagnitud.AREA;
		case "m/s":
			return TipoMagnitud.VELOCIDAD;
		case "m^3":
			return TipoMagnitud.VOLUMEN;
		default:
			return null;
		}
	}

}
