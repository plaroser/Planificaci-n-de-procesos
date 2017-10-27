package test;

import lists.ListaFIFO;
import lists.ListaMasCorto;
import lists.ListaMenosTiempo;
import lists.ListaPrioridades;
import lists.ListaProcesos;
import lists.ListaRoundRobin;
import models.Proceso;

public class Main {
	// private final static Proceso[] PROCESOS = { new Proceso('A', 10, 3, true),
	// (new Proceso('C', 4, 4, true)),
	// (new Proceso('B', 8, 4)), (new Proceso('D', 10, 2)), (new Proceso('E', 2,
	// 10)), (new Proceso('F', 14, 3)),
	// (new Proceso('G', 3, 2, true)), (new Proceso('H', 13, 3)), (new Proceso('E',
	// 30, 1, true)),
	// (new Proceso('F', 27, 4)), (new Proceso('G', 20, 1, true)) };
	private final static int QUANTUM = 2;

	public static void main(String[] args) {
		ListaMenosTiempo<Proceso> listaMenosTiempo = new ListaMenosTiempo<Proceso>();
		ListaFIFO<Proceso> listaFIFO = new ListaFIFO<>();
		ListaRoundRobin<Proceso> listaRoundRobin = new ListaRoundRobin<>(QUANTUM);
		ListaMasCorto listaMasCorto = new ListaMasCorto();
		ListaPrioridades listaPrioridades = new ListaPrioridades();
		listaMenosTiempo.add(new Proceso('B', 8, 2));
		listaMenosTiempo.add(new Proceso('C', 4, 3));
		listaMenosTiempo.add(new Proceso('D', 10, 2));
		listaMenosTiempo.add(new Proceso('E', 20, 1));
		listaMenosTiempo.add(new Proceso('F', 14, 3));
		listaMenosTiempo.add(new Proceso('G', 12, 1));
		listaMenosTiempo.add(new Proceso('H', 13, 3));
		listaMenosTiempo.add(new Proceso('E', 30, 1));
		listaMenosTiempo.add(new Proceso('F', 27, 4));
		listaMenosTiempo.add(new Proceso('G', 20, 1));
		listaMenosTiempo.add(new Proceso('H', 6, 1));

		System.out.println("Ejecutados por menor tiempo:");
		ejecutarLista(listaMenosTiempo);

		listaFIFO.add(new Proceso('A', 10, 3));
		listaFIFO.add(new Proceso('B', 8, 2));
		listaFIFO.add(new Proceso('C', 4, 3));
		listaFIFO.add(new Proceso('D', 10, 2));
		listaFIFO.add(new Proceso('E', 20, 1));
		listaFIFO.add(new Proceso('F', 14, 3));
		listaFIFO.add(new Proceso('G', 12, 1));
		listaFIFO.add(new Proceso('H', 13, 3));
		listaFIFO.add(new Proceso('E', 30, 1));
		listaFIFO.add(new Proceso('F', 27, 4));
		listaFIFO.add(new Proceso('G', 20, 1));
		listaFIFO.add(new Proceso('H', 6, 1));
		System.out.println("Ejecutados por orden de llegada:");
		ejecutarLista(listaFIFO);

		listaRoundRobin.add(new Proceso('A', 10, 3));
		listaRoundRobin.add(new Proceso('B', 8, 2));
		listaRoundRobin.add(new Proceso('C', 4, 3));
		listaRoundRobin.add(new Proceso('D', 10, 2));
		listaRoundRobin.add(new Proceso('E', 20, 1));
		listaRoundRobin.add(new Proceso('F', 15, 3));
		listaRoundRobin.add(new Proceso('G', 12, 1));
		listaRoundRobin.add(new Proceso('H', 13, 3));
		listaRoundRobin.add(new Proceso('E', 30, 1));
		listaRoundRobin.add(new Proceso('F', 27, 4));
		listaRoundRobin.add(new Proceso('G', 20, 1));
		listaRoundRobin.add(new Proceso('H', 6, 1));
		System.out.println("Ejecutados por orden de RoundRobin:");
		ejecutarLista(listaRoundRobin);

		listaMasCorto.add(new Proceso('A', 10, 3));
		listaMasCorto.add(new Proceso('B', 8, 4));
		listaMasCorto.add(new Proceso('C', 4, 4));
		listaMasCorto.add(new Proceso('D', 10, 2));
		listaMasCorto.add(new Proceso('E', 20, 1));
		listaMasCorto.add(new Proceso('F', 15, 3));
		listaMasCorto.add(new Proceso('G', 12, 1));
		listaMasCorto.add(new Proceso('H', 13, 3));
		listaMasCorto.add(new Proceso('E', 30, 1));
		listaMasCorto.add(new Proceso('F', 27, 4));
		listaMasCorto.add(new Proceso('G', 20, 1));
		listaMasCorto.add(new Proceso('H', 6, 1));
		System.out.println("Ejecutados por orden de Mas Corto:");
		ejecutarLista(listaMasCorto);

		listaPrioridades.add(new Proceso('A', 10, 3, true));
		listaPrioridades.add(new Proceso('B', 8, 4));
		listaPrioridades.add(new Proceso('C', 4, 4, true));
		listaPrioridades.add(new Proceso('D', 10, 2));
		listaPrioridades.add(new Proceso('E', 2, 10));
		listaPrioridades.add(new Proceso('F', 14, 3));
		listaPrioridades.add(new Proceso('G', 3, 2, true));
		listaPrioridades.add(new Proceso('H', 13, 3));
		listaPrioridades.add(new Proceso('E', 30, 1, true));
		listaPrioridades.add(new Proceso('F', 27, 4));
		listaPrioridades.add(new Proceso('G', 20, 1, true));
		listaPrioridades.add(new Proceso('H', 6, 1));
		System.out.println("Ejecutados por orden Prioridad:");
		ejecutarLista(listaPrioridades);
	}

	@SuppressWarnings("unused")
	private static void ejecutarLista(ListaProcesos<Proceso> lista) {
		for (int i = 1; lista.size() > 0; i++) {
			Proceso pAux = lista.procesar(i);
			System.out.println("Ciclo " + i + ((pAux != null) ? (". " + pAux) : (".- Esperando...")));
		}
	}

}
