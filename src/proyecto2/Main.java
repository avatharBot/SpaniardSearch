package proyecto2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Red madrid = new Red("MetroMadrid.txt");

        try {
            List<String> ruta;
            ruta = madrid.ruta("Bilbao", "La Rambla");
            System.out.println(ruta);
        } catch (EstacionDesconocida ed) {
            // TODO Auto-generated catch block
            ed.printStackTrace();
        }

    }
}
