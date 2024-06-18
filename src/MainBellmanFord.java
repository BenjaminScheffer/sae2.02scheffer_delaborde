public class MainBellmanFord {
    public static void main(String[] args) throws Exception {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("C", "A", 19);
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("E", "D", 43);
        System.out.println("Graphe : ");
        System.out.println(graphe.toString());
        System.out.println("*****************************");
        System.out.println("Bellmanford en partant de D");
        System.out.println(BellmanFord.pointfixe(graphe, "D"));
        System.out.println("Chemin pour aller a E");
        System.out.println(BellmanFord.pointfixe(graphe, "D").calculerChemin("E"));
        System.out.println("BellmanFord en partant de A");
        System.out.println(BellmanFord.pointfixe(graphe, "A"));
        System.out.println("Chemin pour aller a C");
        System.out.println(BellmanFord.pointfixe(graphe, "A").calculerChemin("C"));
        GrapheListe g = new GrapheListe("graphes/Graphe1.txt");
        System.out.println(g);
    }
}
