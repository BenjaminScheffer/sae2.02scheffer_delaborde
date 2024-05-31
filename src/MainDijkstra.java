public class MainDijkstra {
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
        System.out.println("Dikstra en partant de D");
        System.out.println(Dijkstra.resoudre(graphe, "D"));
        System.out.println("Chemin pour aller a E");
        System.out.println(Dijkstra.resoudre(graphe, "D").calculerChemin("E"));
        System.out.println("Dikstra en partant de A");
        System.out.println(Dijkstra.resoudre(graphe, "A"));
        System.out.println("Chemin pour aller a C");
        System.out.println(Dijkstra.resoudre(graphe, "A").calculerChemin("C"));
    }
}
