package info.unlp.conversor.sistemaInternacional.subfijosMasa;

import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.magnitudes.Peso;
import info.unlp.conversor.sistemaInternacional.PesoInternacional;



public class MiliGramo extends PesoInternacional  {

	public MiliGramo(double cantidad) {
		super(cantidad);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Magnitud cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "kg":
			return new KiloGramo(1000 );
		case "g":
			return new Gramo(getCantidad()*0.001);
		case "ton":
			return new Tonelada(getCantidad()/1000000000);
		case "mg":
			return new MiliGramo(getCantidad());
		default:
			return CambioDeSistema.getInstance().cambiarSistema(unidad, new Gramo(getCantidad()));
		}
		
	}


	@Override
	public Peso suma(Peso suma) {
		// TODO Auto-generated method stub
		return new MiliGramo(this.getCantidad()+suma.cambioLocal("mg").getCantidad());
	}
	@Override
	public Peso resta(Peso suma) {
		// TODO Auto-generated method stub
		return new MiliGramo(this.getCantidad()-suma.cambioLocal("mg").getCantidad());
	}
	@Override
	public int comparar(Peso comparacion) {
		// TODO Auto-generated method stub
		if(this.getCantidad() > comparacion.cambioLocal("mg").getCantidad())
		{
			return 1;
		}
		else if(this.getCantidad() < comparacion.cambioLocal("mg").getCantidad()) 
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
		return "mg";
	}


}
