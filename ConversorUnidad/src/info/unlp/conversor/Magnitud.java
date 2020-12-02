package info.unlp.conversor;

public abstract class Magnitud {
	private double cantidad; //medida 
	/*Crea una nueva instancia de magnitud en la que se le especifica el tipo y el sistema en el que se trabajara*/
	public Magnitud( double cantidad) {
		this.cantidad=cantidad;
	}


	public abstract String getSubfijo();

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	public String toString() {
		return this.cantidad + " " + this.getSubfijo();
	}
	public abstract Magnitud cambioLocal(String unidad);

}
