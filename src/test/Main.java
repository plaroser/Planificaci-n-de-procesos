package test;

import models.ListaMenosTiempo;
import models.Proceso;

public class Main {

	public static void main(String[] args) {
		ListaMenosTiempo<Proceso> listaProcesos = new ListaMenosTiempo<Proceso>();

		listaProcesos.add(new Proceso('A', 4, 1));
		listaProcesos.add(new Proceso('B', 8, 1));
		listaProcesos.add(new Proceso('C', 10, 1));
		listaProcesos.add(new Proceso('D', 10, 2));
		listaProcesos.add(new Proceso('E', 20, 1));
		listaProcesos.add(new Proceso('F', 14, 3));
		listaProcesos.add(new Proceso('G', 12, 1));
		listaProcesos.add(new Proceso('H', 13, 3));
		listaProcesos.add(new Proceso('E', 30, 1));
		listaProcesos.add(new Proceso('F', 27, 4));
		listaProcesos.add(new Proceso('G', 20, 1));
		listaProcesos.add(new Proceso('H', 6, 1));

		for (int i = 1; listaProcesos.size() > 0; i++) {
			Proceso pAux = listaProcesos.procesar(i);
			System.out.println("Ciclo " + i + ((pAux != null) ? (". " + pAux) : (".- Esperando...")));
		}

	}

}
