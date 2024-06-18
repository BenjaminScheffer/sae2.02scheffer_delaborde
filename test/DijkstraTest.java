import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {
    @Test
    public void Test()throws Exception{
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("E","D",43);
        Valeur v = Dijkstra.resoudre(graphe,"D");
        assertEquals(v.getValeur("A"),29.0);
        assertEquals(v.getValeur("B"),23.0);
        assertEquals(v.getValeur("C"),10.0);
        assertEquals(v.getValeur("D"),0.0);
        assertEquals(v.getValeur("E"),34.0);
        assertEquals(v.getParent("A"),"C");
        assertEquals(v.getParent("B"),"D");
        assertEquals(v.getParent("C"),"D");
        assertEquals(v.getParent("D"),null);
        assertEquals(v.getParent("E"),"B");
    }
    @Test
    public void Test2()throws Exception{
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("E","D",43);
        Valeur v = Dijkstra.resoudre(graphe,"A");
        assertEquals(v.getValeur("A"),0.0);
        assertEquals(v.getValeur("B"),12.0);
        assertEquals(v.getValeur("C"),76.0);
        assertEquals(v.getValeur("D"),66.0);
        assertEquals(v.getValeur("E"),23.0);
        assertEquals(v.getParent("A"),null);
        assertEquals(v.getParent("B"),"A");
        assertEquals(v.getParent("C"),"D");
        assertEquals(v.getParent("D"),"E");
        assertEquals(v.getParent("E"),"B");
    }

}