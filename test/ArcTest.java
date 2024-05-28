import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArcTest {
    /**
     * Test Constructeur
     */
        @Test
        public void testConstructeur(){
              Arc c = new Arc("D",30);
              assertEquals("D",c.getDestination());
              assertEquals(30,c.getValeur());
        }
    /**
     * Test ajout dans la liste
     */
        @Test
        public void TestAjoutListe(){
            Arc c = new Arc("D",40);
            Arcs a = new Arcs();
            a.ajouterArc(c);
            boolean t = a.getArcs().contains(c);
            assertEquals(true,t);
        }


}