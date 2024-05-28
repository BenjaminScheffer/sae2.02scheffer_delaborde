import java.util.ArrayList;
import java.util.List;

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
        if (!noeuds.contains(depart)){
            noeuds.add(depart);
        }
        if (!noeuds.contains(destination)){
            noeuds.add(destination);
        }
        int indexDepart = getIndice(depart);

        if(this.adjacence.get(indexDepart)==null){
            Arcs arc = new Arcs();
            arc.ajouterArc(new Arc(destination,cout));
            this.adjacence.add(indexDepart,arc);
        }else{
            Arcs list = this.adjacence.get(indexDepart);
            int i = 0;
            boolean arret = false;
            while (!arret && i!=list.getArcs().size()){
             if(list.getArcs().get(i).getDestination().equals(destination)){
                 arret = true;
             }
             i++;
            }
            if(arret){
                list.getArcs().get(i).setValeur(cout);
            }else{
                list.getArcs().add(new Arc(destination,cout));
            }
        }

    }

    /**
     * Méthode qui permet de recuperer l'indice d'un noeud dans la liste de noeud
     * @param n noeud dont on souhaite recupérer l'indice
     * @return l'indice du noeud n
     */
    public int getIndice(String n){
        return this.noeuds.indexOf(n);
    }

    /**
     * Méthode qui permet de récuperer la liste de noeuds
     * @return la liste de noeuds
     */
    @Override
    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    /**
     * Méthode qui permet de connaitre les arcs que possède un noeud
     * @param n noeud dont on veut connaitre ses arcs
     * @return la liste des arcs partant du nœud n passée en paramètre.
     */
    @Override
    public List<Arc> suivants(String n) {
        int index = getIndice(n);
        return this.adjacence.get(index).getArcs();
    }
}
