package info.unlp;
import info.unlp.conversor.*;
import info.unlp.conversor.sistemaIngles.Libra;
import info.unlp.conversor.sistemaIngles.Pie;
import info.unlp.conversor.sistemaInternacional.KiloGramos;
import info.unlp.conversor.sistemaInternacional.Metro;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Magnitud m = new Tiempo(10, "min");
		System.out.println(m.toString());
	}

}
