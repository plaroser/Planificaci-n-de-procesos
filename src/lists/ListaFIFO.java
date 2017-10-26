package lists;

import java.util.Comparator;

import models.Proceso;

public class ListaFIFO<E> extends ListaProcesos<Proceso> {

	static Comparator<Proceso> comparator = ((Proceso p1, Proceso p2) -> {
			return p1.getTiempo_llegada() - p2.getTiempo_llegada();
	
	});

	public ListaFIFO() {
		super(comparator);
	}

}
