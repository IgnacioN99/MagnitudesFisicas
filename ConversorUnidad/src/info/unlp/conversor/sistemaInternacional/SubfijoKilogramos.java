package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.Subfijo;

public enum SubfijoKilogramos implements Subfijo {
	Miligramo("mg"),
	Gramo("g"),
	Kilogramo("kg"),
	Tonelada("ton");
	private String abrev;
	SubfijoKilogramos(String tipo) {
		this.abrev = tipo;
	}
	public String abrev() {
		return this.abrev;
	}
}
