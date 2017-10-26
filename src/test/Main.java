package test;

import java.util.Comparator;

import models.ListaMenosTiempo;
import models.Proceso;

public class Main {

	public static void main(String[] args) {
		ListaMenosTiempo<Proceso> listaProcesos = new ListaMenosTiempo();

		listaProcesos.add(new Proceso('A', 4, 4));
		listaProcesos.add(new Proceso('B', 8, 2));
		listaProcesos.add(new Proceso('C', 1, 2));
		listaProcesos.add(new Proceso('D', 10, 1));

		for (int i = 1; listaProcesos.size() > 0; i++) {
			Proceso aux = null;
			if (listaProcesos.hayProcesos(i)) {
				aux = listaProcesos.getActual(i);
				aux.setCiclos_restantes(aux.getCiclos_restantes() - 1);
				System.out.println(i + ".-" + aux);
			} else {
				System.out.println(i + ".------");

			}
			if (aux != null && aux.getCiclos_restantes() < 1) {
				System.out.println(listaProcesos.remove(aux));

			}
		}

	}

}
