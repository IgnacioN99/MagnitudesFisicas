package info.unlp.conversor;

public class Tiempo extends Magnitud {
	public Tiempo() {
		super(TipoMagnitud.SEGUNDOS,1);
	}
	
	public double cambiarSistema()
	{
		return (super.getCantidad());
	}

	@Override
	public void cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		
	}
	
}
