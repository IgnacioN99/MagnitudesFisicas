package info.unlp.conversor;

public enum SubfijoTiempo {
	MiliSegundo("mm", 0.001), Segundo("s", 1), Minuto("min", 60), Hora("h", 3600);

	private String abrev;
	private double multiplicador;

	SubfijoTiempo(String tipo, double mult) {
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