package info.unlp.conversor.sistemaInternacional;

public enum SubfijoKilogramos {
	Miligramo("mg",0.000001),
	Gramo("g",0.001),
	Kilogramo("kg",1),
	Tonelada("ton",1000);
	private String abrev;
	private double multiplicador;
	SubfijoKilogramos(String tipo, double mult) {
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
