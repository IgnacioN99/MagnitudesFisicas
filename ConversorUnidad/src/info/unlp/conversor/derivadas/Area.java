package info.unlp.conversor.derivadas;



public interface Area {
	public String getSubfijo();
	public Area cambioLocal(String unidad);
	public Area suma(Area ar);
	public Area resta(Area ar);
	public int Comparar(Area ar);
	double getCantidad();
}
