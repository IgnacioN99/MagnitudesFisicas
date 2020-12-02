package info.unlp.conversor.sistemaInternacional.subfijosMasa;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Peso;
import info.unlp.conversor.sistemaInternacional.PesoInternacional;


public class Tonelada extends PesoInternacional {

	public Tonelada(double cantidad) {
		super(cantidad);
		// TODO Auto-generated constructor stub
	}

	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "kg":
			return new KiloGramo(getCantidad() * 1000);
		case "mg":
			return new MiliGramo(getCantidad() * 1000000000);
		case "g":
			return new Gramo(getCantidad() * 1000000);
		case "ton":
			return new Tonelada(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Gramo(getCantidad()));
		}
	}



	@Override
	public Peso suma(Peso suma) {
		// TODO Auto-generated method stub
		return new Tonelada(this.getCantidad()+suma.cambioLocal("ton").getCantidad());
	}

	@Override
	public Peso resta(Peso suma) {
		// TODO Auto-generated method stub
		return new Tonelada(this.getCantidad()-suma.cambioLocal("ton").getCantidad());
	}

	@Override
	public int comparar(Peso comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("ton").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("ton").getCantidad()) 
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
		return "ton";
	}





}
