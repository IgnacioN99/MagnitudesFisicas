package info.unlp.conversor.derivadas.subfijosVolumen;


import info.unlp.conversor.derivadas.Volumen;
import info.unlp.conversor.sistemaInternacional.subfijosLong.Metro;

public class Metro3 implements Volumen {
	private Metro m1,m2,m3;
	public Metro3(Metro... m) {
		// TODO Auto-generated constructor stub
		if(m.length==3) {
			m1=m[0];
			m2=m[1];
			m3=m[2];
		}
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCantidad()+" "+this.getSubfijo();
	}

	@Override
	public double getCantidad() {
		// TODO Auto-generated method stub
		return m1.getCantidad()*m2.getCantidad()*m3.getCantidad();
	}




	@Override
	public Volumen cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Volumen suma(Volumen ar) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Volumen resta(Volumen ar) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int Comparar(Volumen ar) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String getSubfijo() {
		// TODO Auto-generated method stub
		return "m^3";
	}

}
