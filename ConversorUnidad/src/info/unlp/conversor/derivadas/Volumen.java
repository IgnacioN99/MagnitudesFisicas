package info.unlp.conversor.derivadas;




public interface Volumen{
	public String getSubfijo();
	public Volumen cambioLocal(String unidad);
	public Volumen suma(Volumen ar);
	public Volumen resta(Volumen ar);
	public int Comparar(Volumen ar);
	double getCantidad();
}
