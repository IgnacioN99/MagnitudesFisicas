package info.unlp.conversor.magnitudes;

import info.unlp.conversor.Magnitud;

public abstract class Longitud extends Magnitud{
	public Longitud(double cantidad) {
		super(cantidad);
	}
	public abstract Longitud suma(Longitud suma);
	public abstract Longitud resta(Longitud suma);
	public abstract int comparar(Longitud suma);
}
