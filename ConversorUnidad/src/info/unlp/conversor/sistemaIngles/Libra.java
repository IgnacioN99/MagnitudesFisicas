package info.unlp.conversor.sistemaIngles;
import info.unlp.conversor.Peso;
import info.unlp.conversor.TipoMagnitud;

public class Libra extends Peso {
	public Libra() {
		super(TipoMagnitud.LIBRA,2);
	}


	private SubfijoLibra s = SubfijoLibra.Libra;
	

	/**
	 * Cambia de sistema Ingles a Sistema Internacional.
	 *
	 * @return el valor dado convertido a sistema Internacional
	 */
	public double cambiarSistema() {
		return (super.getCantidad() * 0.453592);
	}


	@Override
	public void cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		switch (unidad.toLowerCase()) {
		case "gr":
			super.setCantidad(getCantidad()*SubfijoLibra.Grano.mult());
			break;
		case "oz":
			super.setCantidad(getCantidad()*SubfijoLibra.Onza.mult());
			break;			
		}
	}

}
