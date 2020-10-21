package info.unlp.conversor;

public class Tiempo extends Magnitud {

	public Tiempo(double cantidad, String unidad) {
		super(TipoMagnitud.SEGUNDOS, 1);
		super.setCantidad(cantidad);
		cambioLocal(unidad);

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 3;
	}

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

	private void cambioH() {
		if (super.getSb().abrev() != null) {
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

	private void cambioMin() {
		if (super.getSb().abrev() != null) {
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

	private void cambioMs() {
		if (super.getSb().abrev() != null) {
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

	private void cambioS() {
		if (super.getSb().abrev() != null) {
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
		super.setSb(SubfijoTiempo.MiliSegundo);
	}


}
