package info.unlp.conversor.derivadas.subfijosVelocidad;

import info.unlp.conversor.Tiempo.subfijosTiempo.Segundo;
import info.unlp.conversor.derivadas.Velocidad;
import info.unlp.conversor.sistemaInternacional.subfijosLong.Metro;

public class MetroSegundo implements Velocidad {
	private Metro m;
	private Segundo s;
	public MetroSegundo(Metro m,Segundo s) {
		// TODO Auto-generated constructor stub
		this.m=m;
		this.s=s;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCantidad()+" "+this.getSubfijo();
	}



	@Override
	public double getCantidad() {
		// TODO Auto-generated method stub
		return m.getCantidad()/s.getCantidad();
	}


	@Override
	public Velocidad cambioLocal(String unidad) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Velocidad suma(Velocidad ar) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Velocidad resta(Velocidad ar) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int Comparar(Velocidad ar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSubfijo() {
		// TODO Auto-generated method stub
		return "m/s";
	}



}
