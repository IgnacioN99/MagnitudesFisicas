package info.unlp.conversor.sistemaInternacional;
import info.unlp.conversor.Longitud;
import info.unlp.conversor.TipoMagnitud;

public class Metro extends Longitud {

    public Metro(double cantidad,String unidad) {
		super(TipoMagnitud.METRO,1);
		super.setCantidad(cantidad);
		cambioLocal(unidad);
		super.setSb(SubfijoMetro.Metro);
	}


    public double cambiarSistema()
    {
        return (super.getCantidad()*3.28084);
    }

	@Override
	public boolean cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		switch (unidad.toLowerCase()) {
		case "cm":
			super.setCantidad(getCantidad()*SubfijoMetro.CentiMetro.mult());
			return true;
		case "mm":
			super.setCantidad(getCantidad()*SubfijoMetro.MiliMetro.mult());
			return true;			
		case "km":
			super.setCantidad(getCantidad()*SubfijoMetro.KiloMetro.mult());
			return true;
		default: 
			return false;
		}
		
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}

}