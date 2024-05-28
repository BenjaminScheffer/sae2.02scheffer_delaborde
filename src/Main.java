//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    GrapheListe graphe = new GrapheListe();
    graphe.ajouterArc("D","B",23);
    graphe.ajouterArc("D","C",10);
    graphe.ajouterArc("C","A",19);
    graphe.ajouterArc("A","B",12);
    graphe.ajouterArc("A","D",87);
    graphe.ajouterArc("B","E",11);
    graphe.ajouterArc("E","D",43);
    System.out.println(graphe.toString());

    }
}