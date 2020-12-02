package info.unlp.conversor.sistemaInternacional.subfijosLong;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Longitud;
import info.unlp.conversor.sistemaInternacional.LongInternacional;


public class Metro extends LongInternacional  {
	public Metro(double cantidad) {
		super(cantidad);
	}

	
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "cm": 
			return new Centimetro(100*this.getCantidad());
		case "mm":
			return new MiliMetro(1000*this.getCantidad());
		case "km":
			return new KiloMetro(0.001*this.getCantidad());
		case "m":
			return new Metro(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Metro(getCantidad()));
		}
	}





	@Override
	public Longitud suma(Longitud suma) {
		// TODO Auto-generated method stub
		return new Metro(this.getCantidad()+suma.cambioLocal("m").getCantidad());
	}


	@Override
	public Longitud resta(Longitud suma) {
		// TODO Auto-generated method stub
		return new Metro(this.getCantidad()-suma.cambioLocal("m").getCantidad());
	}


	@Override
	public int comparar(Longitud comparacion) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return "m";
	}




}
