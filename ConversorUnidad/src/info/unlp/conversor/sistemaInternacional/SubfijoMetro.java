package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Subfijo;

public enum SubfijoMetro implements Subfijo {
	MiliMetro("mm"),
	CentiMetro("mm"),
	Metro("m"),
	KiloMetro("km");
	private String abrev;
	SubfijoMetro(String tipo) {
		this.abrev = tipo;

	}
	public String abrev() {
		return this.abrev;
	}
}
