package models;

public class Proceso extends Object {
	private char nombre;
	private int tiempo_llegada;
	private int ciclos_restantes;
	private int ciclos_necesarios;

	public Proceso(char nombre, int tiempo_llegada, int ciclos_necesarios) {
		super();
		this.nombre = nombre;
		this.tiempo_llegada = tiempo_llegada;
		this.ciclos_necesarios = ciclos_necesarios;
		this.ciclos_restantes = ciclos_necesarios;
	}

	public boolean restarCiclo(int ciclos) {
		boolean esCorrecto = (getCiclos_restantes() - ciclos) >= 0;
		if (esCorrecto)
			this.setCiclos_restantes(getCiclos_restantes() - ciclos);
		else
			this.setCiclos_restantes(0);
		return esCorrecto;

	}

	public boolean restarCiclo() {
		return restarCiclo(1);
	}

	public char getNombre() {
		return nombre;
	}

	public void setNombre(char nombre) {
		this.nombre = nombre;
	}

	public int getTiempo_llegada() {
		return tiempo_llegada;
	}

	public void setTiempo_llegada(int tiempo_llegada) {
		this.tiempo_llegada = tiempo_llegada;
	}

	public int getCiclos_restantes() {
		return ciclos_restantes;
	}

	public void setCiclos_restantes(int ciclos_restantes) {
		this.ciclos_restantes = ciclos_restantes;
	}

	public int getCiclos_necesarios() {
		return ciclos_necesarios;
	}

	public void setCiclos_necesarios(int ciclos_necesarios) {
		this.ciclos_necesarios = ciclos_necesarios;
	}

	@Override
	public String toString() {
		return nombre + " , llegada=" + tiempo_llegada + ", restantes=" + ciclos_restantes + ", necesarios="
				+ ciclos_necesarios;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Proceso) {
			Proceso p = (Proceso) obj;
			return (p.getNombre() == this.getNombre());
		} else {
			return false;
		}

	}

}
