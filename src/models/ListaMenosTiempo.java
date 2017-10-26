package models;

import java.util.Comparator;
import java.util.LinkedList;

public class ListaMenosTiempo<E> extends LinkedList<E> {
	Comparator<Proceso> comparator = ((Proceso o1,
			Proceso o2) -> (o1.getCiclos_restantes() - o2.getCiclos_restantes()));

	public Proceso getActual(int cicloActual) {
		this.sort((Comparator<? super E>) comparator);
		Proceso aux = (Proceso) super.getFirst();
		if (aux.getTiempo_llegada() > cicloActual) {
			Proceso p = (Proceso) this.getFirst();
			for (E iterable_element : this) {
				Proceso pAux = (Proceso) iterable_element;
				if (p.getCiclos_restantes() < pAux.getCiclos_restantes()) {
					p = pAux;
				}
			}
			return p;
		} else {
			return (Proceso) super.getFirst();
		}
	}

	public boolean hayProcesos(int cicloActual) {
		for (E iterable_element : this) {
			Proceso p = (Proceso) iterable_element;
			if (p.getTiempo_llegada() <= cicloActual && p.getCiclos_restantes() > 0)
				return true;
		}
		return false;
	}
}
