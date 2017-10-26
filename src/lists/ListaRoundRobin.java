package lists;

import models.Proceso;

public class ListaRoundRobin<E> extends ListaFIFO<Proceso> {
	private int cuantum;

	public ListaRoundRobin(int quuamtun) {
		super();
		this.cuantum = quuamtun;
	}

	@Override
	public Proceso procesar(int cicloActual) {
		if (hayProcesos(cicloActual)) {
			Proceso aux = getSiguiente(cicloActual);
			aux.restarCiclo(cuantum);
			if (aux.getCiclos_restantes() == 0) {
				this.remove(aux);
			}
			return aux;
		} else {
			return null;
		}
	}
}
