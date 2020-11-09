package info.unlp.conversor.sistemaIngles;
import info.unlp.conversor.Peso;

/**
 * @author Nacho
 *
 */
public class PesoIngles extends Peso {
	/**
	 * @param cantidad : cantidad de lb,oz,gr
	 * @param unidad : unidad del parametro cantidad
	 */
	public PesoIngles(double cantidad,String unidad) {
		super(2);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
	}
	public PesoIngles() {
		super(2);
		super.setCantidad(0);
		cambioLocal("lb");
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
