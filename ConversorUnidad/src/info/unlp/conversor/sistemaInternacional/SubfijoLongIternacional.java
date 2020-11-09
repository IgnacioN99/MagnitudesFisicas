package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Subfijo;

/**
 * enum que contiene todos los subfijos perteneciente a Longitud internacional y sus abreviaturas.
 */
public enum SubfijoLongIternacional implements Subfijo {
	MiliMetro("mm"),
	CentiMetro("mm"),
	Metro("m"),
	KiloMetro("km");
	private String abrev;
	SubfijoLongIternacional(String tipo) {
		this.abrev = tipo;

	}
	public String abrev() {
		return this.abrev;
	}
}
