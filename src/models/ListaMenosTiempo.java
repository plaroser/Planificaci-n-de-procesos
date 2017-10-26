package models;

import java.util.Comparator;
import java.util.LinkedList;

import javax.print.attribute.standard.RequestingUserName;

public class ListaMenosTiempo<E> extends LinkedList<Proceso> {
	Comparator<Proceso> comparator = ((Proceso o1, Proceso o2) -> {
		if (o1.getCiclos_restantes() == o2.getCiclos_restantes())
			return (o1.getTiempo_llegada() - o2.getTiempo_llegada());
		else
			return (o1.getCiclos_restantes() - o2.getCiclos_restantes());
	});

	public boolean add(Proceso e) {
		boolean esCorrecto;
		if (e instanceof Proceso) {
			esCorrecto = super.add(e);
			this.sort((Comparator<? super Proceso>) comparator);
			return esCorrecto;
		} else {
			return false;
		}
	}

	public Proceso getSiguiente(int cicloActual) {
		this.sort((Comparator<? super Proceso>) comparator);
		Proceso pAux = super.getFirst();
		if (pAux.getTiempo_llegada() <= cicloActual)
			return pAux;
		else {
			for (Proceso p : this) {
				if (p.getTiempo_llegada() <= cicloActual)
					return p;
			}
			return null;
		}
	}

	public boolean hayProcesos(int cicloActual) {
		this.sort(comparator);
		for (Proceso p : this) {
			if (p.getTiempo_llegada() <= cicloActual) {
				return true;
			}
		}
		return false;
	}

	public Proceso procesar(int cicloActual) {
		// System.out.println(hayProcesos(cicloActual));
		if (hayProcesos(cicloActual)) {
			Proceso aux = getSiguiente(cicloActual);
			aux.restarciclo();
			if (aux.getCiclos_restantes() == 0) {
				this.remove(aux);
			}
			return aux;
		} else {
			return null;
		}
	}
}
