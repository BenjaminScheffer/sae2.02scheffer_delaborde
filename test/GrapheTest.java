import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class GrapheTest {
    @Test
    public void testAjoutListe(){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 2);
        boolean b = g.listeNoeuds().contains("A");
        boolean t = g.listeNoeuds().contains("B");
        assertEquals(true, t);
        assertEquals(true, b);
        Arc a = new Arc("B",2);
        boolean i = g.suivants("A").get(0).egal(a);
        assertEquals(i,true);
        g.ajouterArc("A","B",3);
        boolean r = g.suivants("A").get(0).egal(a);
        assertEquals(r,false);
        a = new Arc("B",3);
         r = g.suivants("A").get(0).egal(a);
        assertEquals(r,true);
    }
}
