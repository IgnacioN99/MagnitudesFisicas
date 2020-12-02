package info.unlp.conversor.sistemaInternacional.subfijosMasa;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Peso;
import info.unlp.conversor.sistemaInternacional.PesoInternacional;



public class KiloGramo extends PesoInternacional  {

	public KiloGramo(double cantidad) {
		super(cantidad);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "g":
			return new Gramo(1000*getCantidad());
		case "mg":
			return new MiliGramo(getCantidad()*1000000);
		case "ton":
			return new Tonelada(getCantidad()*0.001);
		case "kg":
			return new KiloGramo(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Gramo(getCantidad()));
		}
		
	}


	@Override
	public Peso suma(Peso suma) {
		// TODO Auto-generated method stub
		return new KiloGramo(this.getCantidad()+suma.cambioLocal("kg").getCantidad());
	}
	@Override
	public Peso resta(Peso suma) {
		// TODO Auto-generated method stub
		return new KiloGramo(this.getCantidad()-suma.cambioLocal("kg").getCantidad());
	}
	@Override
	public int comparar(Peso comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("kg").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("kg").getCantidad()) 
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
		return "kg";
	}



}
