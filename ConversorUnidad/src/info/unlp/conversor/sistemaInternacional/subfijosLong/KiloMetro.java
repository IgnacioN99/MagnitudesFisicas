package info.unlp.conversor.sistemaInternacional.subfijosLong;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Longitud;
import info.unlp.conversor.sistemaInternacional.LongInternacional;


public class KiloMetro extends LongInternacional {

	public KiloMetro(double cantidad) {
		super(cantidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "m": 
			return new Metro(1000*this.getCantidad());
		case "mm":
			return new MiliMetro(1000000*this.getCantidad());
		case "cm":
			return new Centimetro(100000*this.getCantidad());
		case "km":
			return new KiloMetro(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Metro(getCantidad()));
		}
	}


	@Override
	public Longitud suma(Longitud suma) {
		// TODO Auto-generated method stub
		return new KiloMetro(this.getCantidad()+suma.cambioLocal("km").getCantidad());
	}

	@Override
	public Longitud resta(Longitud suma) {
		// TODO Auto-generated method stub
		return new KiloMetro(this.getCantidad()-suma.cambioLocal("km").getCantidad());
	}

	@Override
	public int comparar(Longitud comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("km").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("km").getCantidad()) 
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
		return "km";
	}


}
