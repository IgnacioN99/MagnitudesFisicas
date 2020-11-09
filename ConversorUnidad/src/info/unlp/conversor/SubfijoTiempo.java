package info.unlp.conversor;
/*Enum que contiene los subfijos utilizados en las unidades de tiempo*/
public enum SubfijoTiempo implements Subfijo {
	MiliSegundo("ms"), Segundo("s"), Minuto("min"), Hora("h");

	private String abrev;

	SubfijoTiempo(String tipo) {
		this.abrev = tipo;
	}

	public String abrev() {
		return this.abrev;
	}
}
