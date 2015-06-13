package proyecto2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Red {

	private List<Estacion> estaciones;

	public Red(String plano) {
		try (BufferedReader reader = new BufferedReader(new FileReader(plano))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	public Estacion busca(String nombre) {
		for (Iterator<Estacion> iterator = estaciones.iterator(); iterator
				.hasNext();) {
			Estacion estacion = (Estacion) iterator.next();
			if (estacion.getNombre().equals(nombre)) {
				return estacion;
			}
		}
		return null;
	}

	// public List<Estacion> ruta(String origen, String destino)
	// throws EstacionDesconocida {
	//
	// }
}
