package info.unlp.conversor.Tiempo.subfijosTiempo;

import info.unlp.conversor.Magnitud;
import info.unlp.conversor.Tiempo.Tiempo;

public class Segundo extends Tiempo {
	public Segundo(double cantidad) {
		super(cantidad);
	}
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "min":
			return new Minutos(getCantidad()*0.016667);
		case "h":
			return new Hora(getCantidad()*0.00027778);
		case "s":
			new Segundo(getCantidad());
		default:
			return null;
		}
	}

	@Override
	public Tiempo suma(Tiempo suma) {
		return new Segundo(this.getCantidad()+suma.cambioLocal("s").getCantidad());
	}
	@Override
	public Tiempo resta(Tiempo suma) {
		return new Segundo(this.getCantidad()-suma.cambioLocal("s").getCantidad());
	}
	@Override
	public int comparar(Tiempo comparacion) {
		if(this.getCantidad() > comparacion.cambioLocal("s").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("s").getCantidad()) 
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
		return "s";
	}


}
