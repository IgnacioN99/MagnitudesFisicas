package info.unlp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import info.unlp.conversor.CambioDeMagnitud;
import info.unlp.conversor.Magnitud;
import info.unlp.conversor.SondaEspacial;
import info.unlp.conversor.sistemaIngles.Pie;
import info.unlp.conversor.sistemaInternacional.Metro;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Magnitud k = new Metro(1, "km");
//		System.out.println(k.toString());
//		Magnitud a =new CambioDeMagnitud().cambiarSistema("ft", k);
//		System.out.println(a);
		List<Pie> l = new LinkedList<Pie>();
		SondaEspacial<Metro> sonda= new SondaEspacial<Metro>();
		Scanner s= new Scanner(System.in);
		double cantidad;
		String unidad;
		Magnitud aux;
		do {
			do {
				System.out.println("Ingrese unidad a cargar en la lista");
				System.out.println("Unidades soportadas :  ft,mi,yd,in");
				unidad=s.next();
			}while(!new Pie().cambioLocal(unidad));
			System.out.println("Ingrese la cantidad de "+unidad);
			cantidad=s.nextDouble();
			aux= new Pie(cantidad,unidad);
			l.add((Pie)aux);
			System.out.println("Desea continuar? s/n");
		}while (s.next().equals("s"));
		
		for(Pie p : l) {
			System.out.println("Convirtiendo...");
			System.out.println(p.toString());
			aux=CambioDeMagnitud.getInstance().cambiarSistema("m", p);
			System.out.println("Convertido!");
			sonda.imprimirMagnitud((Metro)aux);
			
		}
		s.close();

	}

}
