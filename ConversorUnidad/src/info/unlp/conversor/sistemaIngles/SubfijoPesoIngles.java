package info.unlp.conversor.sistemaIngles;

import info.unlp.conversor.Subfijo;


/**
 * Enum que contiene los subfijos utilizados en el peso ingles
 */
public enum SubfijoPesoIngles implements Subfijo {
	
	/** peso en Granos */
	Grano("gr"),
	
	/** peso en Libras */
	Libra("lb"),
	
	/** peso en Onzas. */
	Onza("oz");
	
	/** abreviatura del subfijo. */
	private String abrev;
	
	/*
	 * @param tipo tipo de subfijo
	 */
	SubfijoPesoIngles(String tipo) {
		this.abrev = tipo;
	}
	
	/**
	 * @return la abreviatura del subfijo
	 */
	public String abrev() {
		return this.abrev;
	}

	@Override
	public TipoMagnitud getTipoMagnitud() {
		// TODO Auto-generated method stub
		return TipoMagnitud.PESOING;
	}
}
