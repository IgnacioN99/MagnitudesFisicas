package info.unlp.conversor.sistemaIngles;

public enum SubfijoLibra {
	Grano("gr",0.00014),
	Libra("lb",1),
	Onza("oz",16);
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
		return this.multiplicador;
	}
}
