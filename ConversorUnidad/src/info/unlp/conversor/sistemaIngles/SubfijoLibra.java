package info.unlp.conversor.sistemaIngles;

import info.unlp.conversor.Subfijo;

public enum SubfijoLibra implements Subfijo {
	Grano("gr",0.00014286),
	Libra("lb",1),
	Onza("oz",0.0625);
	private String abrev;
	private double multiplicador;
	SubfijoLibra(String tipo, double mult) {
		this.abrev = tipo;
		this.multiplicador = mult;
	}
	public String abrev() {
		return this.abrev;
	}
	public double mult() {
		return (multiplicador);
	}
}
