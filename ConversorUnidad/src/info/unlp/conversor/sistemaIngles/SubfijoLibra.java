package info.unlp.conversor.sistemaIngles;

import info.unlp.conversor.Subfijo;

public enum SubfijoLibra implements Subfijo {
	Grano("gr"),
	Libra("lb"),
	Onza("oz");
	private String abrev;
	SubfijoLibra(String tipo) {
		this.abrev = tipo;
	}
	public String abrev() {
		return this.abrev;
	}
}
