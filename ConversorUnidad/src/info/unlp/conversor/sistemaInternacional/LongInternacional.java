package info.unlp.conversor.sistemaInternacional;

import info.unlp.conversor.magnitudes.Longitud;

public abstract class LongInternacional extends Longitud {

	public LongInternacional(double cantidad) {
		super(cantidad);
	}
	@Override
	public int hashCode() {
		return 1;
	}


}
