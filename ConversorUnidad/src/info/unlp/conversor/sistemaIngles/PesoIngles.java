package info.unlp.conversor.sistemaIngles;
import info.unlp.conversor.Peso;
import info.unlp.conversor.TipoMagnitud;

/**
 * clase que manejara las magnitudes de peso ingles y sus cambios locales
 *
 * @author Nacho
 */
public class PesoIngles extends Peso {
	/**
	 * @param cantidad : cantidad de lb,oz,gr
	 * @param unidad : unidad del parametro cantidad
	 */
	public PesoIngles(double cantidad,String unidad) {
		super(TipoMagnitud.LIBRA,2);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
	}
	
	/**
	 *Instancia un objeto de tipo peso ingles vacio 
	 *util para verificar si la unidad pertenece al sistema 
	 */
	public PesoIngles() {
		super(TipoMagnitud.LIBRA,2);
		super.setCantidad(0);
		cambioLocal("lb");
	}



	/**
	 * Cambio local de unidad.
	 *
	 * @param unidad a la que se quiere cambiar
	 * @return devuelve si el cambio fue satisfactorio o no
	 */
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
		super.setSb(SubfijoPesoIngles.Grano);
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
		super.setSb(SubfijoPesoIngles.Onza);
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
		super.setSb(SubfijoPesoIngles.Libra);
	}
}
