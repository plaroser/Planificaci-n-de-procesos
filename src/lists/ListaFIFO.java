package lists;

import java.util.Comparator;

import models.Proceso;

public class ListaFIFO<E> extends ListaProcesos<Proceso> {

	static Comparator<Proceso> comparator = ((Proceso p1, Proceso p2) -> {
		if (p1.getTiempo_llegada() != p2.getTiempo_llegada())
			return p1.getTiempo_llegada() - p2.getTiempo_llegada();
		else
			return p1.getCiclos_restantes() - p2.getCiclos_restantes();
	});

	public ListaFIFO() {
		super(comparator);
	}

}
