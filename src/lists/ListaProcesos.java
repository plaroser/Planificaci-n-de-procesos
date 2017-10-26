package lists;

import java.util.Comparator;
import java.util.LinkedList;

import models.Proceso;

public abstract class ListaProcesos<E> extends LinkedList<Proceso> {
	Comparator<Proceso> comparator;

	public ListaProcesos(Comparator<Proceso> comparator) {
		super();
		this.comparator = comparator;
	}

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
		if (hayProcesos(cicloActual)) {
			Proceso aux = getSiguiente(cicloActual);
			aux.restarCiclo();
			if (aux.getCiclos_restantes() <= 0) {
				this.remove(aux);
			}
			return aux;
		} else {
			return null;
		}
	}

}
