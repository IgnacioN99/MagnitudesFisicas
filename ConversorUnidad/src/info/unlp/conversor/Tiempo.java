package info.unlp.conversor;

/**
 * Clase Tiempo encargada de manejar los cambios de unidad del sistema.
 */
public class Tiempo extends Magnitud {

	/**
	 * Crea una nueva instancia de tiempo 
	 *
	 * @param cantidad tiempo
	 * @param unidad unidad de medida
	 */
	public Tiempo(double cantidad, String unidad) {
		super(TipoMagnitud.TIEMPO, 1);
		super.setCantidad(cantidad);
		cambioLocal(unidad);

	}
	
	/**
	 * crea una nueva instancia de tiempo vacia
	 */
	public Tiempo() {
		super(TipoMagnitud.TIEMPO,1);
		super.setCantidad(0);
		cambioLocal("s");
	}

	/**
	 * Cambio local de unidad.
	 *
	 * @param unidad unidad a la que se quiere cambiar
	 * @return resultado del cambio
	 */
	@Override
	public boolean cambioLocal(String unidad) {
		switch (unidad.toLowerCase()) {
		case "h":
			this.cambioH();
			return true;
		case "min":
			this.cambioMin();
			return true;
		case "ms":
			this.cambioMs();
			return true;
		case "s":
			this.cambioS();
			return true;
		default:
			return false;
		}

	}

	/**
	 * Cambio H.
	 */
	private void cambioH() {
		if (super.getSb() != null) {
			switch (super.getSb().abrev()) {
			case "s":
				super.setCantidad(getCantidad() / 3600);
				break;
			case "min":
				super.setCantidad(getCantidad() / 60);
				break;
			case "ms":
				super.setCantidad(getCantidad() / 3600000);
				break;
			}
		}
		super.setSb(SubfijoTiempo.Hora);
	}

	/**
	 * Cambio min.
	 */
	private void cambioMin() {
		if (super.getSb() != null) {
			switch (super.getSb().abrev()) {
			case "h":
				super.setCantidad(getCantidad() / 0.016667);
				break;
			case "s":
				super.setCantidad(getCantidad() / 60);
				break;
			case "ms":
				super.setCantidad(getCantidad() / 60000);
				break;
			}
		}
		super.setSb(SubfijoTiempo.Minuto);
	}

	/**
	 * Cambio ms.
	 */
	private void cambioMs() {
		if (super.getSb() != null) {
			switch (super.getSb().abrev()) {
			case "h":
				super.setCantidad(getCantidad() * 3600000);
				break;
			case "s":
				super.setCantidad(getCantidad() / 0.001);
				break;
			case "min":
				super.setCantidad(getCantidad() / 0.0000166667);
				break;
			}
		}
		super.setSb(SubfijoTiempo.MiliSegundo);
	}

	/**
	 * Cambio S.
	 */
	private void cambioS() {
		if (super.getSb() != null) {
			switch (super.getSb().abrev()) {
			case "h":
				super.setCantidad(getCantidad() / 0.00027778);
				break;
			case "ms":
				super.setCantidad(getCantidad() / 1000);
				break;
			case "min":
				super.setCantidad(getCantidad() / 0.016667);
				break;
			}
		}
		super.setSb(SubfijoTiempo.Segundo);
	}

}
