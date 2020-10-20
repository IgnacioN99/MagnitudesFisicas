package info.unlp.conversor.sistemaInternacional;
import info.unlp.conversor.Longitud;
import info.unlp.conversor.TipoMagnitud;
import info.unlp.conversor.sistemaIngles.SubfijoPie;

public class Metro extends Longitud {

    public Metro() {
		super(TipoMagnitud.METRO,1);
	}

	private SubfijoMetro S = SubfijoMetro.Metro;

    public double cambiarSistema()
    {
        return (super.getCantidad()*3.28084);
    }

	@Override
	public void cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		switch (unidad.toLowerCase()) {
		case "cm":
			super.setCantidad(getCantidad()*SubfijoMetro.CentiMetro.mult());
			break;
		case "mm":
			super.setCantidad(getCantidad()*SubfijoMetro.MiliMetro.mult());
			break;			
		case "km":
			super.setCantidad(getCantidad()*SubfijoMetro.KiloMetro.mult());
			break;
		}
		
	}

}