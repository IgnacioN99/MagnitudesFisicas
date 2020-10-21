package info.unlp.conversor;

public abstract class Longitud extends Magnitud{

	public Longitud(TipoMagnitud id,int sistema) {
		super(id,sistema);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}

	public abstract Magnitud cambiarSistema(String unidad);
}
