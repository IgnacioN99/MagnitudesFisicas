package info.unlp.conversor.sistemaIngles;

import info.unlp.conversor.Subfijo;

public enum SubfijoPie implements Subfijo {
	pulgadas("in"),
	pie("ft"),
	yarda("yd"),
	milla("mi");
	private String abrev;
	private SubfijoPie(String tipo) {
		this.abrev = tipo;
	}
	public String abrev() {
		return this.abrev;
	}
}
