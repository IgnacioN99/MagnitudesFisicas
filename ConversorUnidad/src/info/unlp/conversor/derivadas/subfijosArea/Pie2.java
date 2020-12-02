package info.unlp.conversor.derivadas.subfijosArea;

import info.unlp.conversor.derivadas.Area;
import info.unlp.conversor.sistemaIngles.subfijosLong.Pie;

public class Pie2 implements Area {
	private Pie p1,p2;
	public Pie2(Pie p1, Pie p2) {
		// TODO Auto-generated constructor stub
		this.p1=p1;
		this.p2=p2;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCantidad()+" "+this.getSubfijo();
	}


	@Override
	public double getCantidad() {
		// TODO Auto-generated method stub
		return this.p1.getCantidad()*this.p2.getCantidad();
	}
	@Override
	public Area cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Area suma(Area ar) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Area resta(Area ar) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int Comparar(Area ar) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getSubfijo() {
		// TODO Auto-generated method stub
		return "ft^2";
	}


}
