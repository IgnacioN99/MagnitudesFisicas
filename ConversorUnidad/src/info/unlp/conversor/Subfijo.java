package info.unlp.conversor;

public interface Subfijo {
	TipoMagnitud tipo = null;
	public String abrev();
	enum TipoMagnitud {
		PESOING,LONGING,PESOINT,LONGINT,TIEMPO,VOLUMEN,AREA,VELOCIDAD;
	}
	public TipoMagnitud getTipoMagnitud();
}
