package info.unlp.conversor.sistemaIngles.subfijosLong;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Longitud;
import info.unlp.conversor.sistemaIngles.LongIngles;

public class Pulgada extends LongIngles {
	public Pulgada(double cantidad) {
		// TODO Auto-generated constructor stub
		super(cantidad);
	}
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "ft":
			return new Pie(getCantidad()*0.083333);
		case "yd":
			return new Yarda(getCantidad()*0.027778);
		case "mi":
			return new Milla(getCantidad()*0.0000157828);
		case "in":
			return new Pulgada(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Milla(getCantidad()));
		}
	}
	
	@Override
	public Longitud suma(Longitud suma) {
		// TODO Auto-generated method stub
		return new Pulgada(this.getCantidad()+suma.cambioLocal("in").getCantidad());
	}
	@Override
	public Longitud resta(Longitud suma) {
		// TODO Auto-generated method stub
		return new Pulgada(this.getCantidad()-suma.cambioLocal("in").getCantidad());
	}
	@Override
	public int comparar(Longitud comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("in").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("in").getCantidad()) 
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
		return "in";
	}

}
