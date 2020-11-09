package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Subfijo;

/**
 * enum que contiene todos los subfijos perteneciente a peso internacional y sus abreviaturas.
 */
public enum SubfijoPesoInternacional implements Subfijo {
	Miligramo("mg"),
	Gramo("g"),
	Kilogramo("kg"),
	Tonelada("ton");
	private String abrev;
	SubfijoPesoInternacional(String tipo) {
		this.abrev = tipo;
	}
	public String abrev() {
		return this.abrev;
	}
}
