package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.magnitudes.Peso;

public abstract class PesoInternacional extends Peso {

	public PesoInternacional(double cantidad) {
		super(cantidad);
	}
	public int hashCode() {
		return 1;
	}
}
