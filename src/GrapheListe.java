import java.util.ArrayList;

public class GrapheListe implements  Graphe{

    /** Attribut
     * Liste de noeuds du graphe
     */
    private ArrayList<String> noeuds;

    /** Attribut
     * liste des arcs qui partent de chaque noeud du graphe
     */
    private ArrayList<Arcs> adjacence;

    /**
     * constructeur de la classe GrapheListe
     */
    public GrapheListe () {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    /**
     * Méthode qui permet d'ajouter un arc
     * @param depart noeud de depart de l'arc
     * @param destination noeud d'arriver de l'arc
     * @param cout valeur de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        if ((noeuds.contains(depart)) && (noeuds.contains(depart))){
            int indexDepart = noeuds.indexOf(depart);


        }
    }

}
