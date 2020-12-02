package info.unlp.conversor.sistemaIngles.subfijosLong;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Longitud;
import info.unlp.conversor.sistemaIngles.LongIngles;

public class Yarda extends LongIngles {
	public Yarda(double cantidad) {
		// TODO Auto-generated constructor stub
		super(cantidad);
	}
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "ft":
			return new Pie(getCantidad()*3);
		case "in":
			return new Pulgada(getCantidad()*36);
		case "mi":
			return new Milla(getCantidad()*0.00056818);
		case "yd":
			return new Yarda(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Milla(getCantidad()));
		}
	}
	
	@Override
	public Longitud suma(Longitud suma) {
		// TODO Auto-generated method stub
		return new Yarda(this.getCantidad()+suma.cambioLocal("yd").getCantidad());
	}
	@Override
	public Longitud resta(Longitud suma) {
		// TODO Auto-generated method stub
		return new Yarda(this.getCantidad()-suma.cambioLocal("yd").getCantidad());
	}
	@Override
	public int comparar(Longitud comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("yd").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("yd").getCantidad()) 
		{
			return (-1);
		}
		else
		{
			return 0;
		}
	}
	@Override
	public String getSubfijo() {
		// TODO Auto-generated method stub
		return "yd";
	}

}
