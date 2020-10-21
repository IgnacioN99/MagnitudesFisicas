package info.unlp.conversor;

public abstract class Peso extends Magnitud{
	public Peso(TipoMagnitud id,int sistema) {
		super(id,sistema);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public abstract double cambiarSistema();
}
