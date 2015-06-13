package proyecto2;

import java.util.List;

public class Estacion {
	private String nombre;
	private Estacion desde;
	private int distancia;
	private List<Estacion> enlaces;

	public Estacion(String nombre) {
		this.nombre = nombre;
		this.distancia = 0;
		this.desde = null;
	}

	public void enlaza(Estacion estacion) {
		this.enlaces.add(estacion);
	}

	public Estacion getDesde() {
		return this.desde;
	}

	public int getDistancia() {
		return this.distancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void mancha(Estacion desde, int distancia) {
		// TODO implement
	}

	public void reset() {
		this.desde = null;
	}

	public String toString() {
		return this.nombre;
	}

	public List<Estacion> getEnlaces() {
		return enlaces;
	}

	public void setEnlaces(List<Estacion> enlaces) {
		this.enlaces = enlaces;
	}

}
