package proyecto2;

import java.util.ArrayList;
import java.util.List;

public class Estacion {
    private String nombre;
    private Estacion desde;
    private int distancia;
    public List<Estacion> enlaces = new ArrayList<Estacion>();

    public Estacion(String nombre) {
        this.nombre = nombre;
        this.desde = null;
        this.distancia = 666;
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
        if (distancia < this.distancia) {
            if (this.desde != null){
                System.out.println("[fine]: " + this + ": antes:" + this.desde + "(" + this.distancia + ")" );
                System.out.println("[fine]: " + this + ": mejor:" + desde + "(" + distancia + ")" );
            }
            this.desde = desde;
            this.distancia = distancia;
        }
    }

    public void reset() {
        this.desde = null;
    }

    public String aString() {
        return this.nombre + ":" + this.enlaces;
    }

    public String toString() {
        return this.nombre;

    }

    public boolean equals(Object o) {
        return o instanceof Estacion
                && ((Estacion) o).nombre.equals(this.nombre);
    }

}
