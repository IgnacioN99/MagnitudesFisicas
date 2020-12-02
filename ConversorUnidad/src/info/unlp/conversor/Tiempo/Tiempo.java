package info.unlp.conversor.Tiempo;

import info.unlp.conversor.Magnitud;


public abstract class Tiempo extends Magnitud {
	public Tiempo(double cantidad) {
		super(cantidad);
	}
	public abstract Tiempo suma(Tiempo suma);
	public abstract Tiempo resta(Tiempo suma);
	public abstract int comparar(Tiempo suma);
}
