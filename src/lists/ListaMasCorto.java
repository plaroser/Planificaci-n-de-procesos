package lists;

import java.util.Comparator;

import models.Proceso;

public class ListaMasCorto extends ListaProcesos<Proceso> {

	static Comparator<Proceso> comparator = (Proceso p1, Proceso p2) -> {
		if (p1.getCiclos_necesarios() != p2.getCiclos_necesarios())
			return p1.getCiclos_necesarios() - p2.getCiclos_necesarios();
		else
			return p1.getCiclos_restantes() - p2.getCiclos_restantes();
	};

	public ListaMasCorto() {
		super(comparator);
	}

}
