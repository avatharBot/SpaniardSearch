package proyecto2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Red {

    private List<Estacion> estaciones;

    public Red(String plano) {
        this.estaciones = new ArrayList<Estacion>();
        try {
            BufferedReader lector = new BufferedReader(new InputStreamReader(
                    new FileInputStream(plano), "UTF-8"));
            String linea;

            while ((linea = lector.readLine()) != null) {
                // comentarios y lineas vacías
                if (linea.startsWith("//") || linea.length() == 0) {
                    continue;
                }

                String[] tokens = linea.split(",");

                for (int i = 0; i < tokens.length; i++) {
                    String nombre = tokens[i].trim();
                    Estacion estacion = new Estacion(nombre);

                    // enlaza con estacion anterior y siguiente
                    // el primer elemento solo con siguiente
                    // el último elemento solo con anterior
                    if (i == 0) {
                        estacion.enlaza(new Estacion(tokens[i + 1].trim()));
                    } else if (i == tokens.length - 1) {
                        estacion.enlaza(new Estacion(tokens[i - 1].trim()));
                    } else {
                        estacion.enlaza(new Estacion(tokens[i - 1].trim()));
                        estacion.enlaza(new Estacion(tokens[i + 1].trim()));
                    }
                    // si la estación ya existe, solo agrega los nuevos enlaces
                    if (this.estaciones.contains(estacion)) {
                        Estacion actualiza = this.busca(nombre);
                        actualiza.enlaces.addAll(estacion.enlaces);
                    } else {
                        this.estaciones.add(estacion);
                    }
                }
            }
            lector.close();
        } catch (IOException ioe) {
            System.err.format("IOException: %s%n", ioe);
        }
    }

    public Estacion busca(String nombre) {
        for (Estacion estacion : this.estaciones) {
            if (estacion.getNombre().equals(nombre)) {
                return estacion;
            }
        }
        return null;
    }

    public List<String> ruta(String origen, String destino)
            throws EstacionDesconocida {

        // Validar que las estaciones existan en el metro
        if (this.busca(origen) == null)
            throw new EstacionDesconocida(origen);
        if (this.busca(destino) == null)
            throw new EstacionDesconocida(destino);

        // reiniciamos las estaciones
        for (Estacion estacion : this.estaciones) {
            estacion.reset();
        }


        this.rutaRecursiva(origen, this.busca(origen), 0);

        Estacion temp = this.busca(destino);

        ArrayList<String> ruta = new ArrayList<String>();

        for (int i = temp.getDistancia()-1; i >= 0; i--) {
            ruta.add(0, temp.getNombre());
            temp = this.busca(temp.getDesde().getNombre());
        }
        ruta.add(0, origen);
        System.out.println(this);
        return ruta;
    }

    private void rutaRecursiva(String estacion, Estacion desde, int distancia){
        Estacion actual = this.busca(estacion);
        int index = this.estaciones.indexOf(actual);
        // mancha estacion actual
        actual.mancha(desde, distancia);
        this.estaciones.set(index, actual);
        // caso base
        if (actual.getDistancia() < distancia) return;

        // recursive tree
//        for (int i = 0; i < distancia; i++) {
//            System.out.print("\t");
//        }
//        System.out.println(actual + ":" + distancia +":"+actual.enlaces);

        // caso recursivo
        for (Estacion enlace : actual.enlaces) {
            if (enlace.equals(desde)){
                continue;
            }
            rutaRecursiva(enlace.getNombre(), actual, distancia+1);
        }
    }

    public String toString() {
        String resultado = "";
        for (Estacion estacion : this.estaciones) {
            resultado += estacion + "[";
            for (Estacion enlace : estacion.enlaces) {
                enlace = this.busca(enlace.getNombre());
                resultado += enlace.getNombre() + ":" + "("
                        + enlace.getDistancia() + ")";
            }
            resultado += "]\n";
        }
        return resultado;
    }
}
