package info.unlp.conversor;

public enum SubfijoTiempo implements Subfijo {
	MiliSegundo("ms"), Segundo("s"), Minuto("min"), Hora("h");

	private String abrev;

	SubfijoTiempo(String tipo) {
		this.abrev = tipo;
		
	}

	public String abrev() {
		return this.abrev;
	}
	@Override
	public TipoMagnitud getTipoMagnitud() {
		// TODO Auto-generated method stub
		return TipoMagnitud.TIEMPO;
	}
}
