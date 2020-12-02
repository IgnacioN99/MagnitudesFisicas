package info.unlp.conversor.derivadas.subfijosArea;

import info.unlp.conversor.derivadas.Area;
import info.unlp.conversor.sistemaInternacional.subfijosLong.Metro;

public class Metro2  implements Area{
	private Metro m1,m2;

	public Metro getM1() {
		return m1;
	}
	public void setM1(Metro m1) {
		this.m1 = m1;
	}
	public Metro getM2() {
		return m2;
	}
	public void setM2(Metro m2) {
		this.m2 = m2;
	}
	public Metro2(Metro m1,Metro m2) {
		// TODO Auto-generated constructor stub
		this.m1=m1;
		this.m2=m2;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCantidad()+" "+this.getSubfijo();
	}


	@Override
	public double getCantidad() {
		// TODO Auto-generated method stub
		return m1.getCantidad()*m2.getCantidad();
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
		return "m^2";
	}


}
