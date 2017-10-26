package test;

import java.util.LinkedList;

import models.ListaMenosTiempo;
import models.Proceso;

public class Main {

	public static void main(String[] args) {
		LinkedList<Proceso> procesos = new LinkedList<>();
		ListaMenosTiempo<Proceso> listaMenosTiempo = new ListaMenosTiempo<Proceso>();

		procesos.add(new Proceso('A', 4, 1));
		procesos.add(new Proceso('B', 8, 1));
		procesos.add(new Proceso('C', 10, 1));
		procesos.add(new Proceso('D', 10, 2));
		procesos.add(new Proceso('E', 20, 1));
		procesos.add(new Proceso('F', 14, 3));
		procesos.add(new Proceso('G', 12, 1));
		procesos.add(new Proceso('H', 13, 3));
		procesos.add(new Proceso('E', 30, 1));
		procesos.add(new Proceso('F', 27, 4));
		procesos.add(new Proceso('G', 20, 1));
		procesos.add(new Proceso('H', 6, 1));

		for (Proceso proceso : procesos) {
			listaMenosTiempo.add(proceso);
		}

		for (int i = 1; listaMenosTiempo.size() > 0; i++) {
			Proceso pAux = listaMenosTiempo.procesar(i);
			System.out.println("Ciclo " + i + ((pAux != null) ? (". " + pAux) : (".- Esperando...")));
		}

	}

}
