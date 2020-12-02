package info.unlp.conversor.magnitudes;

import info.unlp.conversor.Magnitud;

public abstract class Peso extends Magnitud{
	public Peso(double cantidad) {
		super(cantidad);
	}
	public abstract Peso suma(Peso suma);
	public abstract Peso resta(Peso suma);
	public abstract int comparar(Peso suma);
}
