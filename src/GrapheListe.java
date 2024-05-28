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
            int indice  = getIndice(depart);
            this.adjacence.add(indice, new Arcs());
        }
        if (!noeuds.contains(destination)){
            noeuds.add(destination);
            int indice  = getIndice(destination);
            this.adjacence.add(indice, new Arcs());
        }
        int indexDepart = getIndice(depart);

        try{
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
        }catch(IndexOutOfBoundsException e ){
            Arcs arc = new Arcs();
            arc.ajouterArc(new Arc(destination, cout));
            this.adjacence.add(indexDepart, arc);
        }
    }



    public int getIndice(String n){
        return this.noeuds.indexOf(n);
    }
    public String toString(){
            String s = "";
            for (int i = 0; i < this.noeuds.size(); i++) {
                s = s + this.noeuds.get(i) + "=> ";
                for (int j = 0; j < this.adjacence.get(i).getArcs().size(); j++) {
                    s = s + this.adjacence.get(i).getArcs().get(j).getDestination() + "(" + this.adjacence.get(i).getArcs().get(j).getValeur() + ")" + ", ";
                }
                s = s + "\n";
            }
            return s;
    }


}
