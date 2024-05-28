import java.util.ArrayList;
import java.util.List;

public class Arcs {
    /**
     * Attributs
     * Liste d'arc
     */
    private List<Arc> arcs;

    /**
     * Constructeur qui construit une liste d'arc vide
     */

    public Arcs(){
        this.arcs = new ArrayList<>();
    }

    /**
     * Méthode qui ajoute l'arc en paramètre dans la liste
     * @param a
     */
    public void ajouterArc(Arc a ){
        this.arcs.add(a);
    }

    /**
     * Getter qui retourne la liste d'arcs
     * @return
     */
    public List<Arc> getArcs() {
        return this.arcs;
    }
}
