package info.unlp.conversor.sistemaIngles.subfijosMasa;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Peso;
import info.unlp.conversor.sistemaIngles.PesoIngles;

public class Onza extends PesoIngles {

	public Onza(double cantidad) {
		super(cantidad);
		// TODO Auto-generated constructor stub
	}
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "lb":
			return new Onza(getCantidad()*0.0625);
		case "gr":
			return new Grano(getCantidad()*437.5);
		case "oz":
			return new Onza(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Grano(getCantidad()));
		}
	}


	@Override
	public Peso suma(Peso suma) {
		// TODO Auto-generated method stub
		return new Onza(this.getCantidad()+suma.cambioLocal("oz").getCantidad());
	}
	@Override
	public Peso resta(Peso suma) {
		// TODO Auto-generated method stub
		return new Onza(this.getCantidad()-suma.cambioLocal("oz").getCantidad());
	}
	@Override
	public int comparar(Peso comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("oz").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("oz").getCantidad()) 
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
		return "oz";
	}

}
