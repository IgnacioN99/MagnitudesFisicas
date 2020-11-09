package info.unlp.conversor.sistemaIngles;

import info.unlp.conversor.Subfijo;

/**
 * Enum que contiene los subfijos utilizados en la longitud inglesa
 */
public enum SubfijoLongIngles implements Subfijo {
	
	/** Longitud en pulgadas. */
	pulgadas("in"),
	
	/** Longitud en  pies. */
	pie("ft"),
	
	/** Longitud en yardas. */
	yarda("yd"),
	
	/** Longitud en millas. */
	milla("mi");
	
	/** abreviatura del subfijo. */
	private String abrev;
	
	private SubfijoLongIngles(String tipo) {
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
		return TipoMagnitud.LONGING;
	}
}
