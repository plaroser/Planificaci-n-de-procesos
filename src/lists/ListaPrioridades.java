package lists;

import java.util.Comparator;

import models.Proceso;

public class ListaPrioridades extends ListaFIFO<Proceso> {
	static Comparator<Proceso> comparador = (Proceso p1, Proceso p2) -> {
		if (p1.isPrioridadAlta() != p2.isPrioridadAlta()) {
			if (p1.isPrioridadAlta())
				return -1;
			else
				return 1;
		} else {
			return (p1.getTiempo_llegada() - p2.getTiempo_llegada());
		}

	};

	public ListaPrioridades() {
		super(comparador);
	}
}
