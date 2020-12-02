package info.unlp.conversor.Tiempo.subfijosTiempo;

import info.unlp.conversor.Magnitud;
import info.unlp.conversor.Tiempo.Tiempo;

public class Hora extends Tiempo {
	public Hora(double cantidad) {
		super(cantidad);
	}
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "min":
			return new Minutos(getCantidad()*60);
		case "s":
			return new Segundo(getCantidad()*3600);
		case "h":
			return new Hora(getCantidad());
		default:
			return null;
		}
	}

	@Override
	public Tiempo suma(Tiempo suma) {
		return new Hora(this.getCantidad()+suma.cambioLocal("h").getCantidad());
	}
	@Override
	public Tiempo resta(Tiempo suma) {
		return new Hora(this.getCantidad()-suma.cambioLocal("h").getCantidad());
	}
	@Override
	public int comparar(Tiempo comparacion) {
		if(this.getCantidad() > comparacion.cambioLocal("h").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("h").getCantidad()) 
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
		return "h";
	}

}
