package info.unlp.conversor;

public abstract class Longitud extends Magnitud{
	public Longitud(TipoMagnitud id,int sistema) {
		super(id,sistema);
	}

	@Override
	public abstract double cambiarSistema();
}
