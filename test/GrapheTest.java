import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class GrapheTest {
    @Test
    public void testAjoutListe(){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 2);
        boolean b = g.listeNoeuds().contains("A");
        assertEquals(true, b);
    }
}
