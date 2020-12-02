package info.unlp.conversor.derivadas.subfijosVolumen;

import info.unlp.conversor.derivadas.Volumen;
import info.unlp.conversor.sistemaIngles.subfijosLong.Pie;

public class Pie3 implements Volumen {
	private Pie p1,p2,p3;
	public Pie3(Pie... p) {
		// TODO Auto-generated constructor stub}
		if(p.length==3) {
			p1=p[0];
			p2=p[1];
			p3=p[2];
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
		return p1.getCantidad()*p2.getCantidad()*p3.getCantidad();
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
		return "ft^3";
	}

}
