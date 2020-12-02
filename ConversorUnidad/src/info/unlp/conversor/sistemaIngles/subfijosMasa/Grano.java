package info.unlp.conversor.sistemaIngles.subfijosMasa;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Peso;
import info.unlp.conversor.sistemaIngles.PesoIngles;

public class Grano extends PesoIngles {

	public Grano(double cantidad) {
		super(cantidad);
		// TODO Auto-generated constructor stub
	}
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "oz":
			return new Onza(getCantidad()*0.00228571);
		case "lb":
			return new Libra(getCantidad()*0.00014286);
		case "gr":
			return new Grano(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Grano(getCantidad()));
		}
	}

	@Override
	public Peso suma(Peso suma) {
		// TODO Auto-generated method stub
		return new Grano(this.getCantidad()+suma.cambioLocal("gr").getCantidad());
	}
	@Override
	public Peso resta(Peso suma) {
		// TODO Auto-generated method stub
		return new Grano(this.getCantidad()-suma.cambioLocal("gr").getCantidad());
	}
	@Override
	public int comparar(Peso comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("gr").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("gr").getCantidad()) 
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
		return "gr";
	}

}
