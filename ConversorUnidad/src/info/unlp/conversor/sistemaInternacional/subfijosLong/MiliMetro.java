package info.unlp.conversor.sistemaInternacional.subfijosLong;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Longitud;
import info.unlp.conversor.sistemaInternacional.LongInternacional;


public class MiliMetro extends LongInternacional {

	public MiliMetro(double cantidad) {
		super(cantidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "cm": 
			return new Centimetro(0.1*this.getCantidad());
		case "m":
			return new Metro(0.001*this.getCantidad());
		case "km":
			return new KiloMetro(0.000001*this.getCantidad());
		case "mm":
			return new MiliMetro(getCantidad());
		default:
				return CambioDeSistema.getInstance().cambiarSistema(unidad, new Metro(getCantidad()));
		}
	}



	@Override
	public Longitud suma(Longitud suma) {
		// TODO Auto-generated method stub
		return new MiliMetro(this.getCantidad()+suma.cambioLocal("mm").getCantidad());
	}

	@Override
	public Longitud resta(Longitud suma) {
		// TODO Auto-generated method stub
		return new MiliMetro(this.getCantidad()-suma.cambioLocal("mm").getCantidad());
	}

	@Override
	public int comparar(Longitud comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("mm").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("mm").getCantidad()) 
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
		return "mm";
	}


}
