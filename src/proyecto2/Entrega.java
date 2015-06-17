package proyecto2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Comprueba si estan todos los FICHEROS en su sitio.
 *
 * @author Laboratorio de Programacion
 * @version 15/3/2012
 */

public class Entrega {
    private static final String ENTREGA = "";
    private static final String PRACTICA = "" + ENTREGA;
    private static final List<String> FICHEROS = new ArrayList<String>();

    static {

        FICHEROS.add("proyecto2/Estacion.java");
        FICHEROS.add("proyecto2/EstacionDesconocida.java");
        FICHEROS.add("proyecto2/Red.java");
        FICHEROS.add("proyecto2/TestRed.java");
    }

    public static void main(String[] argumentos) throws IOException {
        String home = System.getProperty("user.home");
        File homeFile = new File(home);
        System.out.printf("$HOME = %s%n", homeFile.getCanonicalPath());
        File practicaFile = new File(homeFile, PRACTICA);
        for (String fichero : FICHEROS) {
            File ficheroFile = new File(practicaFile, fichero);
            boolean ok = ficheroFile.exists();
            String mensaje = ok ? "perfecto" : "no existe";
            System.out.printf("%s: %s%n", ficheroFile.getCanonicalPath(),
                    mensaje);
        }
    }
}
