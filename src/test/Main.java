package test;

import lists.ListaFIFO;
import lists.ListaMasCorto;
import lists.ListaMenosTiempo;
import lists.ListaPrioridades;
import lists.ListaProcesos;
import lists.ListaRoundRobin;
import models.Proceso;

public class Main {
	private final static Proceso[] PROCESOS = { new Proceso('A', 10, 3, true), (new Proceso('C', 4, 4, true)),
			(new Proceso('B', 8, 4)), (new Proceso('D', 10, 2)), (new Proceso('E', 2, 10)), (new Proceso('F', 14, 3)),
			(new Proceso('G', 3, 2, true)), (new Proceso('H', 13, 3)), (new Proceso('E', 30, 1, true)),
			(new Proceso('F', 27, 4)), (new Proceso('G', 20, 1, true)) };
	private final static int QUANTUM = 2;

	public static void main(String[] args) {
		ListaMenosTiempo<Proceso> listaMenosTiempo = new ListaMenosTiempo<Proceso>();
		ListaFIFO<Proceso> listaFIFO = new ListaFIFO<>();
		ListaRoundRobin<Proceso> listaRoundRobin = new ListaRoundRobin<>(QUANTUM);
		ListaMasCorto listaMasCorto = new ListaMasCorto();
		ListaPrioridades listaPrioridades = new ListaPrioridades();
		// Tiempo restante menor
		for (Proceso proceso : PROCESOS) {
			listaMenosTiempo.add(proceso);
		}
		System.out.println("Ejecutados por menor tiempo:");
		ejecutarLista(listaMenosTiempo);

		// Ejecutados por fifo
		for (Proceso proceso : PROCESOS) {
			listaFIFO.add(proceso);
		}
		System.out.println("\nEjecutados por orden de llegada:");
		ejecutarLista(listaFIFO);

		// Ejecutado por RoundRobin
		for (Proceso proceso : PROCESOS) {
			listaRoundRobin.add(proceso);
		}
		System.out.println("\nEjecutados por orden de RoundRobin:");
		ejecutarLista(listaRoundRobin);

		// Ejecutado por mas corto
		for (Proceso proceso : PROCESOS) {
			listaMasCorto.add(proceso);
		}
		System.out.println("\nEjecutados por orden de Mas Corto:");
		ejecutarLista(listaMasCorto);

		// Ejecutado por prioridades
		for (Proceso proceso : PROCESOS) {
			listaPrioridades.add(proceso);
		}
		System.out.println("\nEjecutados por orden Prioridad:");
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
