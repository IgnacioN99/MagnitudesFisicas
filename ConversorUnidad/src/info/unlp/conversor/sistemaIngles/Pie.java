package info.unlp.conversor.sistemaIngles;
import info.unlp.conversor.Longitud;
import info.unlp.conversor.TipoMagnitud;

public class Pie extends Longitud {
	public Pie(double cantidad,String unidad) {
		super(TipoMagnitud.PIE,2);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
	}
	public Pie() {
		super(TipoMagnitud.PIE,2);
		super.setCantidad(0);
		cambioLocal("ft");
	}
	
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
		super.setSb(SubfijoPie.pie);
	}
	
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
		super.setSb(SubfijoPie.yarda);
	}
	
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
		super.setSb(SubfijoPie.milla);
	}
	
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
		super.setSb(SubfijoPie.pulgadas);
	}

}
