package lists;

import java.util.Comparator;

import models.Proceso;

public class ListaRoundRobin<E> extends ListaFIFO<Proceso> {
	private int quantum;
	private Proceso[] procesosAnteriores;
	static Comparator<Proceso> comparator = ((Proceso p1, Proceso p2) -> {
		return p1.getCiclos_restantes() - p2.getCiclos_restantes();

<<<<<<< Upstream, based on branch 'master' of https://plaroser@bitbucket.org/sergioplarojas/planificacion-de-procesos.git
	public ListaRoundRobin(int quuamtun) {
		super();
		this.cuantum = quuamtun;
=======
	});

	public ListaRoundRobin(int quamtun) {
		super(comparator);
		this.quantum = quamtun;
		this.procesosAnteriores = new Proceso[quamtun];
>>>>>>> bc9c7c1 Lista RoundRobin reparada
	}

	@Override
	public Proceso procesar(int cicloActual) {
		if (hayProcesos(cicloActual)) {
			Proceso aux = null;
			// Si el proceso anterior es nulo
			if (procesosAnteriores[0] != null) {
				int anteriorProceso = 0;
				for (int i = 0; i < procesosAnteriores.length; i++) {
					if (procesosAnteriores[0].equals(procesosAnteriores[i]))
						anteriorProceso = i;
				}
				aux = procesosAnteriores[anteriorProceso];

				// Si el ultimo proceso ha sido nulo
			} else {
				aux = this.getSiguiente(cicloActual);
			}
			aux.restarCiclo();
			// Si el ultimo elemento anterior es como el ejecutado pone todo a nulo para que
			// la siguiente vez pida uno a la lista
			if (aux.equals(procesosAnteriores[quantum - 1])) {
				for (int i = 0; i < procesosAnteriores.length; i++) {
					procesosAnteriores[i] = null;
				}
			}
			// Si los ciclos restantes son menores o igual a cero lo saca de la lista
			if (aux.getCiclos_restantes() <= 0) {
				this.remove(aux);
				for (int i = 0; i < procesosAnteriores.length; i++) {
					procesosAnteriores[i] = null;
				}
			}
			return aux;
		} else {
			return null;
		}
	}
}
