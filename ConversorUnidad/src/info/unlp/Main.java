package info.unlp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import info.unlp.conversor.CambioDeSistema;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.SondaEspacial;
import info.unlp.conversor.sistemaIngles.subfijosLong.Pie;
import info.unlp.conversor.sistemaInternacional.subfijosLong.Metro;

public class Main {

	public static void main(String[] args) {
		List<Pie> l = new LinkedList<Pie>();
		SondaEspacial<Metro> sonda = new SondaEspacial<Metro>();
		Scanner s = new Scanner(System.in);
		double cantidad;
		String unidad="ft";
		Magnitud aux;
		do {
			System.out.println("Ingrese la cantidad de " + unidad);
			cantidad = s.nextDouble();
			aux = new Pie(cantidad);
			l.add((Pie) aux);
			System.out.println("Desea continuar? s/n");
		} while (s.next().equals("s"));

		for (Pie p : l) {
			System.out.println("Convirtiendo...");
			System.out.println(p.toString());
			aux = CambioDeSistema.getInstance().cambiarSistema("m", p);
			System.out.println("Convertido!");
			sonda.imprimirMagnitud((Metro)aux);

		}
		s.close();
	}

}
