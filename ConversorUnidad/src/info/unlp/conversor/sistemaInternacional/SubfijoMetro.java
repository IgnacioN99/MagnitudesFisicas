package info.unlp.conversor.sistemaInternacional;

public enum SubfijoMetro {
	MiliMetro("mm",0.001),
	CentiMetro("mm",0.001),
	Metro("m",1),
	KiloMetro("km",1000);
	private String abrev;
	private double multiplicador;
	SubfijoMetro(String tipo, double mult) {
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
