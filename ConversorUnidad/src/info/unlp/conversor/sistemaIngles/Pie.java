package info.unlp.conversor.sistemaIngles;
import info.unlp.conversor.Longitud;
import info.unlp.conversor.TipoMagnitud;

public class Pie extends Longitud {
	public Pie(double cantidad,String unidad) {
		super(TipoMagnitud.PIE,2);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
		super.setSb(SubfijoPie.pie);
	}


    public double cambiarSistema()
    {
        return (super.getCantidad()*0.3048);
    }
	public boolean cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "mi":
			super.setCantidad(getCantidad()*SubfijoPie.milla.mult());
			return true;
		case "in":
			super.setCantidad(getCantidad()*SubfijoPie.pulgadas.mult());
			return true;			
		case "yd":
			super.setCantidad(getCantidad()*SubfijoPie.yarda.mult());
			return true;
		default:
			return false;
		}
	}

}
