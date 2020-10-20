package info.unlp.conversor.sistemaIngles;
import info.unlp.conversor.Longitud;
import info.unlp.conversor.TipoMagnitud;

public class Pie extends Longitud {
	public Pie() {
		super(TipoMagnitud.PIE,2);
	}

    private SubfijoPie s = SubfijoPie.pie;

    public double cambiarSistema()
    {
        return (super.getCantidad()*0.3048);
    }
	public void cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "mi":
			super.setCantidad(getCantidad()*SubfijoPie.milla.mult());
			break;
		case "in":
			super.setCantidad(getCantidad()*SubfijoPie.pulgadas.mult());
			break;			
		case "yd":
			super.setCantidad(getCantidad()*SubfijoPie.yarda.mult());
			break;
		}
	}

}
