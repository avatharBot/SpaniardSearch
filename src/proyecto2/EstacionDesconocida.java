package proyecto2;

public class EstacionDesconocida extends Exception {

    /**
     *
     */

    private String faltante;

    public EstacionDesconocida(String nombre) {
        this.faltante = nombre;
    }

    @Override
    public String toString() {
        return "No existe la estacion " + this.faltante;
    }
}
