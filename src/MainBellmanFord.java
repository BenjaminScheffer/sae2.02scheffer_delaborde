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
        System.out.println(graphe.toString());
        System.out.println(BellmanFord.pointfixe(graphe, "D"));
        System.out.println(BellmanFord.pointfixe(graphe, "D").calculerChemin("E"));
        System.out.println(BellmanFord.pointfixe(graphe, "A"));
        System.out.println(BellmanFord.pointfixe(graphe, "A").calculerChemin("C"));
    }
}
