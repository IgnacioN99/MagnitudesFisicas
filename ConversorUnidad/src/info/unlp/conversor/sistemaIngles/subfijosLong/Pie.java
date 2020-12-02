package info.unlp.conversor.sistemaIngles.subfijosLong;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Longitud;
import info.unlp.conversor.sistemaIngles.LongIngles;

public class Pie extends LongIngles{
	public Pie(double cantidad) {
		// TODO Auto-generated constructor stub
		super(cantidad);
	}
	

	@Override
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "yd":
			return new Yarda(getCantidad()*0.333333);
		case "in":
			return new Pulgada(getCantidad()*12);
		case "mi":
			return new Milla(getCantidad()*0.00018939);
		case "ft":
			return new Pie(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Milla(getCantidad()));
		}
	}

	@Override
	public Longitud suma(Longitud suma) {
		// TODO Auto-generated method stub
		return new Pie(this.getCantidad()+suma.cambioLocal("ft").getCantidad());
	}

	@Override
	public Longitud resta(Longitud suma) {
		// TODO Auto-generated method stub
		return new Pie(this.getCantidad()-suma.cambioLocal("ft").getCantidad());
	}

	@Override
	public int comparar(Longitud comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("ft").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("ft").getCantidad()) 
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
		return "ft";
	}


}
