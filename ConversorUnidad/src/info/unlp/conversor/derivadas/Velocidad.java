package info.unlp.conversor.derivadas;



public interface Velocidad{
	public String getSubfijo();
	public Velocidad cambioLocal(String unidad);
	public Velocidad suma(Velocidad ar);
	public Velocidad resta(Velocidad ar);
	public int Comparar(Velocidad ar);
	double getCantidad();

}
