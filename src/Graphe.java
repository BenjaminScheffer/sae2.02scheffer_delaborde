import java.util.List;
public interface Graphe {
    /**
     * Méthode qui permet de connaitre les noeuds d'un graphe
     * @return une liste qui contient les noeuds du graphe
     */
    public List<String> listeNoeuds();

    /**
     * Méthode qui permet de connaitre les arcs que possède un noeud
     * @param n noeud dont on veut connaitre ses arcs
     * @return la liste des arcs partant du nœud n passée en paramètre.
     */
    public List<Arcs> suivants(String n);
}
