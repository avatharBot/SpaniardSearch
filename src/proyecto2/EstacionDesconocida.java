package proyecto2;

public class EstacionDesconocida extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String faltante;

    public EstacionDesconocida(String nombre) {
        this.faltante = nombre;
    }

    public String toString() {
        return "No existe la estacion " + this.faltante;
    }

}
