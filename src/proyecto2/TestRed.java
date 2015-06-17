package proyecto2;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class TestRed extends TestCase {

    private Red mini;

    public TestRed(String name) { super(name); }

    public void setUp(){
       this.mini = new Red("MiniRed.txt");
    }

    public void test00(){
        Estacion a = mini.busca("A");
        Estacion b = mini.busca("B");
        Estacion m = mini.busca("M");
        Estacion e = mini.busca("E");

        assertEquals("Nope", "A", a.getNombre());
        assertEquals("Nope", "B", b.getNombre());
        assertEquals("Nope", "M", m.getNombre());
        assertEquals("Nope", "E", e.getNombre());
    }

    public void test01(){
        try {
            List<String> test = mini.ruta("A", "C");
            assertEquals("Nope", 3, test.size());
            assertEquals("Nope", "A", test.get(0));
            assertEquals("Nope", "B", test.get(1));
            assertEquals("Nope", "C", test.get(2));
        } catch (EstacionDesconocida ede){
            // no debe fallar
        }
    }

    public void test02(){
        try {
            List<String> test = mini.ruta("A", "Z");
            Assert.fail("Test falla. Estación desconocida");
        } catch (EstacionDesconocida ede){
            // something;
        }
    }

    public void test03(){
        try {
            List<String> test = mini.ruta("A", "E");
            Estacion a = mini.busca("A");
            Estacion m = mini.busca("M");
            Estacion d = mini.busca("D");
            Estacion e = mini.busca("E");

            // camino de la ruta
            assertEquals("Nope", 4, test.size());
            assertEquals("Nope", "A", test.get(0));
            assertEquals("Nope", "E", test.get(test.size()-1));
            // estaciones intermedias
            assertEquals("Nope", "D", e.getDesde().getNombre());
            assertEquals("Nope", 3, e.getDistancia());
            assertEquals("Nope", 2, d.getDistancia());
            assertEquals("Nope", 0, a.getDistancia());
        } catch (EstacionDesconocida ede){
            // no debe fallar
        }
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestRed.class);
    }

}
