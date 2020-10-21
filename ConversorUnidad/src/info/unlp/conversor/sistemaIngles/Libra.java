package info.unlp.conversor.sistemaIngles;
import info.unlp.conversor.Peso;
import info.unlp.conversor.TipoMagnitud;

/**
 * @author Nacho
 *
 */
public class Libra extends Peso {
	/**
	 * @param cantidad : cantidad de lb,oz,gr
	 * @param unidad : unidad del parametro cantidad
	 */
	public Libra(double cantidad,String unidad) {
		super(TipoMagnitud.LIBRA,2);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
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
			this.cambiogr();
			return true;
		case "oz":
			this.cambioOz();
			return true;
		case "lb":
			this.cambioLb();
			return true;
		default:
			System.out.println("Por favor ingrese una unidad valida");
			return false;
		}
	}
	
	private void cambiogr() {
		if(super.getSb()!=null) {
			switch (super.getSb().abrev()) {
			case "lb":
				super.setCantidad(getCantidad()/0.00014286);
				break;
			case "oz":
				super.setCantidad(getCantidad()/0.00228571);
				break;
			}
		}
		super.setSb(SubfijoLibra.Grano);
	}
	
	private void cambioOz() {
		if(super.getSb()!=null) {
			switch (super.getSb().abrev()) {
			case "lb":
				super.setCantidad(getCantidad()/0.0625);
				break;
			case "gr":
				super.setCantidad(getCantidad()/437.5);
				break;
			}
		}
		super.setSb(SubfijoLibra.Onza);
	}

	private void cambioLb() {
		if(super.getSb()!=null) {
			switch (super.getSb().abrev()) {
			case "oz":
				super.setCantidad(getCantidad()/16);
				break;
			case "gr":
				super.setCantidad(getCantidad()/7000);
			}
		}
		super.setSb(SubfijoLibra.Libra);
	}
}
