package models;

import java.util.Comparator;
import java.util.LinkedList;

import javax.print.attribute.standard.RequestingUserName;

@SuppressWarnings("serial")
public class ListaMenosTiempo<E> extends ListaProcesos<Proceso> {
	static Comparator<Proceso> comparator = ((Proceso o1, Proceso o2) -> {
		if (o1.getCiclos_restantes() == o2.getCiclos_restantes())
			return (o1.getTiempo_llegada() - o2.getTiempo_llegada());
		else
			return (o1.getCiclos_restantes() - o2.getCiclos_restantes());
	});

	public ListaMenosTiempo() {
		super(comparator);
	}

}
