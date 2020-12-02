package info.unlp.conversor.sistemaIngles.subfijosMasa;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Peso;
import info.unlp.conversor.sistemaIngles.PesoIngles;

public class Libra extends PesoIngles {
	public Libra(double cantidad) {
		// TODO Auto-generated constructor stub
		super(cantidad);
	}
	
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "oz":
			return new Onza(getCantidad()*16);
		case "gr":
			return new Grano(getCantidad()*7000);
		case "lb":
			return new Libra(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Grano(getCantidad()));
		}
	}

	@Override
	public Peso suma(Peso suma) {
		// TODO Auto-generated method stub
		return new Libra(this.getCantidad()+suma.cambioLocal("lb").getCantidad());
	}

	@Override
	public Peso resta(Peso suma) {
		// TODO Auto-generated method stub
		return new Libra(this.getCantidad()-suma.cambioLocal("lb").getCantidad());
	}

	@Override
	public int comparar(Peso comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("lb").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("lb").getCantidad()) 
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
		return "lb";
	}

}
