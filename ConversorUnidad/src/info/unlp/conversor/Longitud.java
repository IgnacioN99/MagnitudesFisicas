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
	@Override
	public abstract double cambiarSistema();
}
