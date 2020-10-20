package info.unlp.conversor;

public class Tiempo extends Magnitud {

	public Tiempo(double cantidad, String unidad) {
		super(TipoMagnitud.SEGUNDOS,1);
		super.setSb(SubfijoTiempo.Segundo);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
		
	}
	
	public double cambiarSistema()
	{
		return (super.getCantidad());
	}
	@Override
	public boolean cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "h":
			super.setCantidad(getCantidad()*SubfijoTiempo.Hora.mult());
			return true;
		case "min":
			super.setCantidad(getCantidad()*SubfijoTiempo.Minuto.mult());
			return true;
		case "ms":
			super.setCantidad(getCantidad()*SubfijoTiempo.MiliSegundo.mult());
			return true;
		case "s":
			super.setCantidad(getCantidad()*SubfijoTiempo.Segundo.mult());
			return true;
		default:
			return false;
		}
		
	}
	
}
