package info.unlp.conversor.Tiempo.subfijosTiempo;

import info.unlp.conversor.Magnitud;
import info.unlp.conversor.Tiempo.Tiempo;

public class Minutos extends Tiempo {
	public Minutos	(double cantidad) {
		super(cantidad);
	}

	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "h":
			return new Hora(getCantidad()*0.016667);
		case "s":
			return new Segundo(getCantidad()*60);
		case "m":
			return new Minutos(getCantidad());
		default:
			return null;
		}
	}


	@Override
	public Tiempo suma(Tiempo suma) {
		return new Minutos(this.getCantidad()+suma.cambioLocal("m").getCantidad());
	}

	@Override
	public Tiempo resta(Tiempo suma) {
		return new Minutos(this.getCantidad()-suma.cambioLocal("m").getCantidad());
	}

	@Override
	public int comparar(Tiempo comparacion) {
		if(this.getCantidad() > comparacion.cambioLocal("m").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("m").getCantidad()) 
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
		return "min";
	}

}
