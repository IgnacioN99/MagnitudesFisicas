package info.unlp.conversor.sistemaIngles;

import info.unlp.conversor.Subfijo;

public enum SubfijoPie implements Subfijo {
	pulgadas("in",0.083),
	pie("ft",1),
	yarda("yd",3),
	milla("mi",5280);
	private String abrev;
	private double multiplicador;
	private SubfijoPie(String tipo, double mult) {
		this.abrev = tipo;
		this.multiplicador = mult;
	}
	public String abrev() {
		return this.abrev;
	}
	public double mult() {
		return (this.multiplicador);
	}
}
