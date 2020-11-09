package info.unlp.conversor;

public enum SubfijoTiempo implements Subfijo {
	MiliSegundo("ms", 0.001), Segundo("s", 1), Minuto("min", 60), Hora("h", 3600);

	private String abrev;
	private double multiplicador;

	SubfijoTiempo(String tipo, double mult) {
		this.abrev = tipo;
		this.multiplicador = mult;
	}

	public String abrev() {
		return this.abrev;
	}

<<<<<<< Updated upstream
	public double mult() {
		return this.multiplicador;
=======
	@Override
	public TipoMagnitud getTipoMagnitud() {
		// TODO Auto-generated method stub
		return TipoMagnitud.TIEMPO;
>>>>>>> Stashed changes
	}
}
