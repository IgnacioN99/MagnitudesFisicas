package info.unlp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.SondaEspacial;
import info.unlp.conversor.sistemaIngles.LongIngles;
import info.unlp.conversor.sistemaInternacional.LongInternacional;

public class Main {

	public static void main(String[] args) {
		List<LongIngles> l = new LinkedList<LongIngles>();
		SondaEspacial<LongInternacional> sonda = new SondaEspacial<LongInternacional>();
		Scanner s = new Scanner(System.in);
		double cantidad;
		String unidad;
		Magnitud aux;
		do {
			do {
				System.out.println("Ingrese unidad a cargar en la lista");
				System.out.println("Unidades soportadas :  ft,mi,yd,in");
				unidad = s.next();
			} while (!new LongIngles().cambioLocal(unidad));
			System.out.println("Ingrese la cantidad de " + unidad);
			cantidad = s.nextDouble();
			aux = new LongIngles(cantidad, unidad);
			l.add((LongIngles) aux);
			System.out.println("Desea continuar? s/n");
		} while (s.next().equals("s"));

		for (LongIngles p : l) {
			System.out.println("Convirtiendo...");
			System.out.println(p.toString());
			aux = CambioDeMagnitud.getInstance().cambiarSistema("m", p);
			System.out.println("Convertido!");
			sonda.imprimirMagnitud((LongInternacional)aux);

		}
		s.close();
	}

}
