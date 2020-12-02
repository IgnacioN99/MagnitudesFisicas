package info.unlp.conversor.derivadas.subfijosVelocidad;


import info.unlp.conversor.Tiempo.subfijosTiempo.Hora;
import info.unlp.conversor.derivadas.Velocidad;
import info.unlp.conversor.sistemaIngles.subfijosLong.Milla;

public class MillaHora implements Velocidad {
	private Milla m;
	private Hora h;

	public MillaHora(Milla m, Hora h) {
		// TODO Auto-generated constructor stub
		this.m = m;
		this.h = h;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCantidad()+" "+this.getSubfijo();
	}

	@Override
	public double getCantidad() {
		// TODO Auto-generated method stub
		return m.getCantidad()/h.getCantidad();
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
		return "mi/h";
	}



}
