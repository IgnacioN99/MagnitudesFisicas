package info.unlp.conversor.sistemaIngles;
import info.unlp.conversor.Longitud;
import info.unlp.conversor.TipoMagnitud;

// TODO: Auto-generated Javadoc
/**
 * Clase longitud ingles. Es la encargada de manejar las longitudes en ingles y sus cambios
 * @author Nacho
 */
public class LongIngles extends Longitud {
	
	/**
	 * Instancia una nueva longitud en sistema ingles.
	 *
	 * @param cantidad Cantidad de la unidad inglesa
	 * @param unidad unidad en la que se trabajara
	 */
	public LongIngles(double cantidad,String unidad) {
		super(TipoMagnitud.PIE,2);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
	}
	
	/**
	 * Instancia una nueva longitud vacia en el sistema ingles
	 * 	util para saber si una unidad pertenece al sistema mencionado
	 */
	public LongIngles() {
		super(TipoMagnitud.PIE,2);
		super.setCantidad(0);
		cambioLocal("ft");
	}
	
	/**
	 * Cambio local de unidad
	 *
	 * @param unidad a la que se quiere cambiar
	 * @return devuelve el resultado del cambio
	 */
	public boolean cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "mi":
			this.cambiomi();
			return true;
		case "in":
			this.cambioin();
			return true;			
		case "yd":
			this.cambioyd();
			return true;
		case "ft":
			this.cambioft();
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * Cambioft.
	 */
	private void cambioft() {
		if(super.getSb()!=null) {
			switch (super.getSb().abrev()) {
			case "mi":
				super.setCantidad(getCantidad()/0.00018939);
				break;
			case "in":
				super.setCantidad(getCantidad()/12);
				break;
			case "yd":
				super.setCantidad(getCantidad()/0.333333);
				break;
			}
		}
		super.setSb(SubfijoLongIngles.pie);
	}
	
	/**
	 * Cambioyd.
	 */
	private void cambioyd() {
		if(super.getSb()!=null) {
			switch (super.getSb().abrev()) {
			case "mi":
				super.setCantidad(getCantidad()/0.00056818);
				break;
			case "in":
				super.setCantidad(getCantidad()/36);
				break;
			case "ft":
				super.setCantidad(getCantidad()/3);
				break;
			}
		}
		super.setSb(SubfijoLongIngles.yarda);
	}
	
	/**
	 * Cambiomi.
	 */
	private void cambiomi() {
		if(super.getSb()!=null) {
			switch (super.getSb().abrev()) {
			case "yd":
				super.setCantidad(getCantidad()/1760);
				break;
			case "in":
				super.setCantidad(getCantidad()/63360);
				break;
			case "ft":
				super.setCantidad(getCantidad()/5280);
				break;
			}
		}
		super.setSb(SubfijoLongIngles.milla);
	}
	
	/**
	 * Cambioin.
	 */
	private void cambioin() {
		if(super.getSb()!=null) {
			switch (super.getSb().abrev()) {
			case "yd":
				super.setCantidad(getCantidad()/0.027778);
				break;
			case "mi":
				super.setCantidad(getCantidad()/0.0000157828);
				break;
			case "ft":
				super.setCantidad(getCantidad()/0.083333);
				break;
			}
		}
		super.setSb(SubfijoLongIngles.pulgadas);
	}

}
