package info.unlp.conversor.sistemaIngles;
import info.unlp.conversor.Peso;
import info.unlp.conversor.TipoMagnitud;

/**
 * @author Nacho
 *
 */
public class Libra extends Peso {
	/**
	 * No importa que tipo de unidad se pase, la misma sera truncada a libra por cuestion de comodidad
	 * @param cantidad : cantidad de lb,oz,gr
	 * @param unidad : unidad del parametro cantidad
	 */
	public Libra(double cantidad,String unidad) {
		super(TipoMagnitud.LIBRA,2);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
		super.setSb(SubfijoLibra.Libra);
	}
	/**
	 * Cambia de sistema Ingles a Sistema Internacional.
	 *
	 * @return el valor dado convertido a sistema Internacional
	 */
	public double cambiarSistema() {
		return (super.getCantidad() * 0.453592);
	}



	@Override
	public boolean cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "gr":
			super.setCantidad(getCantidad()*SubfijoLibra.Grano.mult());
			return true;
		case "oz":
			super.setCantidad(getCantidad()*SubfijoLibra.Onza.mult());
			return true;
		case "lb":
			super.setCantidad(getCantidad());
			return true;
		default:
			System.out.println("Por favor ingrese una unidad valida");
			return false;
		}
	}

}
