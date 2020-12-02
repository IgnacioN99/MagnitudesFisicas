package info.unlp.conversor.sistemaInternacional.subfijosLong;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Longitud;
import info.unlp.conversor.sistemaInternacional.LongInternacional;


public class Centimetro extends LongInternacional {

	public Centimetro(double cantidad) {
		super(cantidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "m": 
			return new Metro(0.01*this.getCantidad());
		case "mm":
			return new MiliMetro(10*this.getCantidad());
		case "km":
			return new KiloMetro(0.00001*this.getCantidad());
		case "cm":
			return new Centimetro(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Metro(getCantidad()));
		}
	}


	@Override
	public Longitud suma(Longitud suma) {
		return new Centimetro(this.getCantidad()+suma.cambioLocal("cm").getCantidad());
	}

	@Override
	public Longitud resta(Longitud suma) {
		return new Centimetro(this.getCantidad()-suma.cambioLocal("cm").getCantidad());
	}

	@Override
	public int comparar(Longitud comparacion) {
		if(this.getCantidad() > comparacion.cambioLocal("cm").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("cm").getCantidad()) 
		{
			return (-1);
		}
		else
		{
			return 0;
		}
		//Mayor =1
		//Menor =-1
		//Igual =0		
	}

	@Override
	public String getSubfijo() {
		// TODO Auto-generated method stub
		return "cm";
	}

}
