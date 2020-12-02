package info.unlp.conversor.sistemaInternacional.subfijosMasa;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Peso;
import info.unlp.conversor.sistemaInternacional.PesoInternacional;


public class Gramo extends PesoInternacional  {

	public Gramo(double cantidad) {
		super(cantidad);
	}
	@Override
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "kg":
			return new KiloGramo(0.001*getCantidad());
		case "mg":
			return new Gramo(getCantidad()*1000);
		case "ton":
			return new Tonelada(0.000001*getCantidad());
		case "g":
			return new Gramo(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Gramo(getCantidad()));
		}
		
	}


	@Override
	public Peso suma(Peso suma) {
		// TODO Auto-generated method stub
		return new Gramo(this.getCantidad()+suma.cambioLocal("g").getCantidad());
	}
	@Override
	public Peso resta(Peso suma) {
		// TODO Auto-generated method stub
		return new Gramo(this.getCantidad()-suma.cambioLocal("g").getCantidad());
	}
	@Override
	public int comparar(Peso comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("g").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("g").getCantidad()) 
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
		return "g";
	}



}
